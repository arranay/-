/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Лера
 */
public interface ISendBean {
    public void sendJMSMessageToAmqmsg(String messageData);
}
