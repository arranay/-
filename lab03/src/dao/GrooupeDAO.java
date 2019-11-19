package dao;

import modelDao.Grooup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrooupeDAO implements DAO<Grooup>{

    private static String url = "jdbc:mysql://localhost:3306/lab02?useSSL=false&useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "root";
    private static String query;

    @Override
    public boolean insert(Grooup obj) {
        query = "insert into Grooup (groupName, creationDate, curatorName) " +
                "values (?, ?, ?);";
        try(Connection con = DriverManager.getConnection(url, username, password)){
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setString(1, obj.getGroupName());
            pStmt.setDate(2,new java.sql.Date(obj.getCreationDate().getTime()));
            pStmt.setString(3,obj.getCuratorName());
            if (pStmt.executeUpdate()>0) return true;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
       }
        return false;
    }

    @Override
    public Grooup getById(int id) {
        query = "select * from grooup where id="+id+";";

        try(Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);){
            while (rs.next()){
                return new Grooup(id, rs.getString("groupName"),
                        rs.getDate("creationDate"), rs.getString("curatorName"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Grooup obj) {
        query = "update grooup set CuratorName='"+ obj.getCuratorName() + "', groupName='"+ obj.getGroupName()+ "' where id=" + obj.getId() + ";";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            if(con.prepareStatement(query).executeUpdate()>0)return true;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        query = "delete from grooup where id=" + id +";";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            if(con.prepareStatement(query).executeUpdate()>0) return true;
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Grooup> getAll() {
        List<Grooup> grooupList = new ArrayList<>();
        query = "select*from grooup;";

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                Grooup grooup = new Grooup(rs.getInt("id"), rs.getString("groupName"),
                        rs.getDate("creationDate"), rs.getString("curatorName"));
                grooupList.add(grooup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grooupList;
    }

}