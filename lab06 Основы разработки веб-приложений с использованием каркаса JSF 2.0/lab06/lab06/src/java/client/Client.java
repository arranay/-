/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.util.Date;

/**
 *
 * @author Лера
 */
public class Client { private String password; 
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
        
    public void length(){
        Date date = new Date();
        boolean flag = true;
        if (significantDay.after(date)){
            long time = significantDay.getTime()- date.getTime();
            time = time/(24*60*60*1000)+1;
            if (time==1) {numbDay =  "До события: "+time+" день"; }
            if ((time>1)&&(time<5)) {numbDay =  "До события: "+time+" дня";} 
            if (time>4) {numbDay = "До события: "+time+" дней";} 
            flag=false;
        }
        if(flag) numbDay = "Событие уже прошло";
    }
        
    private int slag1;
    private int slag2;
    private static double result;
    
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
    
    public void sum(int slag1, int slag2){
         result=slag1+slag2;
    }
    
    public void dif(int slag1, int slag2){
         result = slag1-slag2;
    }
    
    public void mult(int slag1, int slag2){
         result = slag1*slag2;
    }
    
    public void sub(int slag1, int slag2){
         result = (double)slag1/(double)slag2;
    }
}
