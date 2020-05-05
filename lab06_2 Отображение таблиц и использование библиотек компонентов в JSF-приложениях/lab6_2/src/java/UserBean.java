import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserBean{
    
    private static List<User> users = new ArrayList<User>(Arrays.asList(
                    new User(1, "Иванов", new Date(2019, 5, 15), "online", 5),
                    new User(2, "Семёнов", new Date(2008, 5, 2), "ofline", 1),
                    new User(3, "Булгаков", new Date(2017, 1, 1), "ofline", 5),
                    new User(4, "Митина", new Date(2009, 8, 5), "online", 2)
                ));
   
    public List<User> getUsers(){
        return users;
        
    }
    
    public String deleteUser(int idUser){
        try {
            int n=-1;
            for (User u: users){
                    n++;
                    if (u.id==idUser) users.remove(n);
                }
        }
            catch (Exception e){
                return "index";
            }
            return "index";
        }
    
    private User editUser;
        
    public User getEditUser() {
        return editUser;
    }
    
    public void setEditUser(User editUser) {
        this.editUser = editUser;
    }

    public String edit(User user){
        setEditUser(user);
        return "edit";
    }
    
    public String editGo(){
        int n=-1, id=0;
        for (User u: users){
                    n++;
                    if (u.id==editUser.id){
                        id=n;
                        break;
                    }
                }
        users.set(id,editUser);
        return "index";
    }
    
    private List<User> thisSelectUser;
    
    public List<User> getThisSelectUser() {
        return thisSelectUser;
    }

    public void setThisSelectUser(List<User> thisSelectUser) {
        this.thisSelectUser = thisSelectUser;
    }
    
    public String upgrateState(){
        for (User u: users){
            if (u.isCheck()) u.setState("online");
                    else u.setState("ofline");
        }
        return "index";
    }
    
    public String sortPost(){
        List<User> preSort = users;
        List<User> postSort = new ArrayList<User>(); int min=100, id=0, n;
        
         try {
            while (!preSort.isEmpty()){
            n = -1; min=100;
            for (User u: preSort){
                n++;
                if (u.getNumberOrder()<min){
                    min=u.getNumberOrder();
                    id=n;
                }
            }
            postSort.add(preSort.get(id));
            preSort.remove(id);
        }users=postSort;
        }catch (Exception e){
                return "index";
            }
        return "index";
    }
    
    public String sortId(){
        List<User> preSort = users;
        List<User> postSort = new ArrayList<User>(); int min=10, id=0, n;
        
         try {
            while (!preSort.isEmpty()){
            n = -1; min=10;
            for (User u: preSort){
                n++;
                if (u.getId()<min){
                    min=u.getId();
                    id=n;
                }
            }
            postSort.add(preSort.get(id));
            preSort.remove(id);
        }users=postSort;
        }catch (Exception e){
                return "index";
            }
        return "index";
    }
    
    public String sortDate(){
        List<User> preSort = users;
        List<User> postSort = new ArrayList<User>(); long max=0; int id=0, n;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
         try {
            while (!preSort.isEmpty()){
            n = -1; max=0;
            for (User u: preSort){
                n++;
                if (u.getDateRegistration().getTime()/(24*60*60*1000)>max){
                    max=u.getDateRegistration().getTime()/(24*60*60*1000);
                    id=n;
                }
            }
            postSort.add(preSort.get(id));
            preSort.remove(id);
        }users=postSort;
        }catch (Exception e){
                return "index";
            }
        return "index";
    }
}
   
