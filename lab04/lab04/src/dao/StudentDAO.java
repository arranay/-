package dao;

import modelDao.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO implements DAO<Student>{

    private static String url = "jdbc:mysql://localhost:3306/lab02?useSSL=false&useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "root";
    private static String query;

    @Override
    public boolean insert(Student obj) {
        query = "insert into Student (grooupId,  lastName,  firstName,  birthDate, age) " +
                "values (?, ?, ?, ?, ?)";
        try(Connection con = DriverManager.getConnection(url, username, password)){
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setInt(1, obj.getGrooupeId());
            pStmt.setString(2,obj.getLastName());
            pStmt.setString(3,obj.getFirstName());
            pStmt.setDate(4,new java.sql.Date(obj.getBirthDate().getTime()));
            pStmt.setInt(5,obj.getAge());
            if(pStmt.executeUpdate()>0) return true;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return false;
    }

    @Override
    public Student getById(int id) {
        //query = "select * from student where id="+id+";";
        query = "select Student.id, groupName,  lastName,  firstName,  birthDate, age " +
                "from Student inner join grooup " +
                "on Student.grooupID = grooup.Id where id= "+id+";";

        try(Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);){
            while (rs.next()){
                return new Student(id, rs.getString("groupName"), rs.getString("lastname"),
                        rs.getString("firstname"), rs.getDate("birthDate"), rs.getInt("age"));
            }
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Student obj) {
        query = "update student set grooupID="+ obj.getGrooupeId()+" where id=" + obj.getId()+";";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            if(con.prepareStatement(query).executeUpdate()>0) return true;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        query = "delete from student where id="+id;
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            if(con.prepareStatement(query).executeUpdate()>0) return true;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList= new ArrayList<>();
        //query = "select*from student;";
        query = "select Student.id, groupName,  lastName,  firstName,  birthDate, age " +
                "from Student inner join grooup " +
                "on Student.grooupID = grooup.Id;";

        try(Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);){
            while (rs.next()){
                Student student = new Student(rs.getInt("id"), rs.getString("groupName"), rs.getString("lastname"),
                        rs.getString("firstname"), rs.getDate("birthDate"), rs.getInt("age"));
                studentList.add(student);
            }
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return studentList;
    }
}
