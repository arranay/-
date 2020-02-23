package lab07.dao;

import lab07.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.xml.bind.SchemaOutputResolver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class UserDao {
    JdbcTemplate template;

    public List<User> getAllUsers(){
        try{
            return template.query("select * from user",new RowMapper<User>(){

                public User mapRow(ResultSet rs, int row) throws SQLException {
                    User u =  new User();
                    u.setUserId(rs.getInt("userId"));
                    u.setLogin(rs.getString("login"));
                    u.setPassword(rs.getString("password"));
                    u.setEmail(rs.getString("email"));
                    return u;
                }
            });

        }catch (Exception e){
            throw new RuntimeException( "An error has occurred in listAllTasks method", e);
        }
    }

    public User getUserById(int idUser){
        String query="select*from user where userId=?";
        return template.queryForObject(query, new Object[]{idUser}, new BeanPropertyRowMapper<User>(User.class));
    }

    public int update(User user){
        String query="update user set login=?, password=?, email=? where userId=?";
        Object[] params = {user.getLogin(), user.getPassword(), user.getEmail(), user.getUserId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
        return template.update(query,params,types);
    }

    public int insert(User user){
        String query="insert into user(login, password, email) values (?, ?, ?)";
        Object[] params = {user.getLogin(), user.getPassword(), user.getEmail()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return template.update(query,params,types);
    }

    public int delete(int idUser){
        String query="delete from user where userId=?";
        Object[] params = {idUser};
        int[] types = {Types.INTEGER};
        return template.update(query,params,types);
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
