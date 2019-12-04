public class sessionBean {    
    private static int numb;
    private String login;
    
    public String getLogin() {
	    return login;
	}
    public void setLogin(String login) {
	    this.login = login;
	}
    
    public int getNumb(){
        return numb++;
    }    
}
