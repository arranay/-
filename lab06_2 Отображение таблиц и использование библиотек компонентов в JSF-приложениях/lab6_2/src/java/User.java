import java.util.Date;

public class User {
    
    final int id;
    private String login;
    private Date dateRegistration;
    private String state;
    private int numberPost;
    private boolean check;
    
    public User(int id, String login, 
            Date dateRegistration, String state, int numberPost){
        this.id=id;
        this.login=login; 
        this.dateRegistration=dateRegistration;
        this.state=state;
        this.numberPost=numberPost;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public int getNumberOrder() {
        return numberPost;
    }

    public void setNumberOrder(int numberPost) {
        this.numberPost = numberPost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
