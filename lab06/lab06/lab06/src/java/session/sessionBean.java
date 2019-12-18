/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;
/**
 *
 * @author Лера
 */
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
