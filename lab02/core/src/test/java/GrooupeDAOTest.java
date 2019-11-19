
import dao.GrooupeDAO;
import modelDao.Grooup;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GrooupeDAOTest {

    @Test
    public void insert() throws ParseException {
        System.out.println("Test insert");
        String date = "2018-01-09";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Grooup grooup = new Grooup("ВТ-118", format.parse(date), "Привалов М.Е.");

        boolean expectation = true;
        GrooupeDAO grooupeDAO = new GrooupeDAO();
        boolean reality = grooupeDAO.insert(grooup);

        assertEquals("Добавление записи не произошло",expectation,reality);
    }

    @Test
    public void getById() {
        System.out.println("Test getById");
        int id = 1;
        GrooupeDAO grooupeDAO = new GrooupeDAO();
        Grooup grooup =  grooupeDAO.getById(id);

        assertEquals("Поиск записи по id провален",grooup.getGroupName(),"ПРИ-117");
    }

    @Test
    public void update() {
        System.out.println("Test update");
        Grooup grooup = new Grooup();
        grooup.setCuratorName("Синичкин В.И.");
        grooup.setId(2);

        boolean expectation = true;
        GrooupeDAO grooupeDAO = new GrooupeDAO();
        boolean reality = grooupeDAO.update(grooup);

        assertEquals("Обновление записи не произошло",expectation,reality);
    }

    @Test
    public void delete() {
        System.out.println("Test delete");
        int id = 4;
        boolean expectation = true;
        GrooupeDAO grooupeDAO = new GrooupeDAO();
        boolean reality = grooupeDAO.delete(id);

        assertEquals("Удаление записи не произошло",expectation,reality);

    }

    @Test
    public void getAll() {
        System.out.println("Test getAll");
        GrooupeDAO grooupeDAO = new GrooupeDAO();
        ArrayList<Grooup> grooupList= grooupeDAO.getAll();

        int expectation = 3;
        int reality = grooupList.size();

        assertEquals("Все записи не были получениы",expectation,reality);

        for (Grooup i : grooupList){
            System.out.print(i.getId()+ "  " +i.getGroupName()+ "  " + i.getCuratorName() + "  "
                    + i.getCreationDate() + "  " + i.getCreationDate());
            System.out.println();
        }
    }
}
