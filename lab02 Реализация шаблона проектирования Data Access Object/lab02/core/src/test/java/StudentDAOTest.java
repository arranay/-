import dao.StudentDAO;
import modelDao.Student;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentDAOTest {

    @Test
    public void insert() throws ParseException {
        System.out.println("Test insert");
        String date = "1996-03-01";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Student student = new Student(3,"Филипов","Илья", format.parse(date),21);

        boolean expectation = true;
        StudentDAO studentDAO = new StudentDAO();
        boolean reality = studentDAO.insert(student);

        assertEquals("Добавление записи не произошло",expectation,reality);
    }

    @Test
    public void getById() {
        System.out.println("Test getById");
        int id = 1;
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getById(id);

        assertEquals("Поиск записи по id провален",student.getLastName(),"Михайлов");
        System.out.println(student.getLastName()+" "+student.getFirstName()
                +" "+student.getBirthDate()+" "+student.getAge()+ " лет");
    }

    @Test
    public void update() {
        System.out.println("Test update");
        Student student = new Student();
        student.setGrooupeId(3);
        student.setId(1);

        boolean expectation = true;
        StudentDAO studentDAO = new StudentDAO();
        boolean reality = studentDAO.update(student);

        assertEquals("Обновление записи не произошло",expectation,reality);
    }

    @Test
    public void delete() {
        System.out.println("Test delete");
        int id = 4;
        boolean expectation = true;
        StudentDAO studentDAO = new StudentDAO();
        boolean reality = studentDAO.delete(id);

        assertEquals("Удаление записи не произошло",expectation,reality);
    }

    @Test
    public void getAll() {
        System.out.println("Test getAll");
        StudentDAO studentDAO = new StudentDAO();
        ArrayList<Student> studentList= studentDAO.getAll();

        int expectation = 5;
        int reality = studentList.size();

        assertEquals("Все записи не были получениы",expectation,reality);

        for (Student i : studentList){
            System.out.print(i.getId()+ "  " +i.getGrooupeId()+ "  " + i.getLastName() + "  "
                    + i.getFirstName() + "  " + i.getBirthDate());
            System.out.println();
        }
    }
}
