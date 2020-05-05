/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.util.ArrayList;
import java.util.Date;

public class Client {
      
    private String password; 
    private Date significantDay;
    private static String numbDay = "(￢_￢)";
     
    public Date getSignificantDay() {
	    return significantDay;
	}       
    public void setSignificantDay(Date significantDay) {
	    this.significantDay = significantDay;
	}
    public String getNumbDay() {
	    return numbDay;
	} 
        
        
        public String getPassword() {
	    return password;
	} 
        public void setPassword(String password) {
	    this.password = password;
	}
        
      
           
        public String checkLogin(){
            if (password.equalsIgnoreCase("111")){
                return "success";
            } else {
                return "failed";
            }
        }
        
    public String length(){
        Date date = new Date();
        if (significantDay.after(date)){
            long time = significantDay.getTime()- date.getTime();
            time = time/(24*60*60*1000)+1;
            if (time==1) {numbDay =  "До события: "+time+" день";  return "success";}
            if ((time>1)&&(time<5)) {numbDay =  "До события: "+time+" дня"; return "success";} 
            if (time>4) {numbDay = "До события: "+time+" дней"; return "success";} 
        }
        if (significantDay.before(date)){
            numbDay = "Событие уже прошло"; return "success";
        }
        numbDay = "День Х сегодня!!!";
        return "success";
    }
        
    private int slag1;
    private int slag2;
    private double result;
    
    public void setSlag1(int slag1) {
	    this.slag1 = slag1;
	}    
    public void setSlag2(int slag2) {
	    this.slag2 = slag2;
	}    
    public double getResult() {
	    return result;
	}
    public int getSlag1() {
	    return slag1;
	}
    public int getSlag2() {
	    return slag2;
	}
    
    public String sum(int slag1, int slag2){
         result = slag1+slag2;
         return "success";
    }
    
    public String dif(int slag1, int slag2){
         result = slag1-slag2;
         return "success";
    }
    
    public String mult(int slag1, int slag2){
         result = slag1*slag2;
         return "success";
    }
    
    public String sub(int slag1, int slag2){
         result = (double)slag1/(double)slag2;
         return "success";
    }
}
