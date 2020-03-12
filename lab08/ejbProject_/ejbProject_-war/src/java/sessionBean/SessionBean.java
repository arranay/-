/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

/**
 *
 * @author Лера
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 30)
public class SessionBean implements SessionBeanLocal {
    
   
}
