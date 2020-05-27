/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author Лера
 */
@Named(value = "newManagedBeanJMS")
@ApplicationScoped
public class NewManagedBeanJMS {

    private final String user = ActiveMQConnection.DEFAULT_USER;
    private final String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private Destination destination;
 
    public void sendMessage(String textMsg) {
        try {
            Connection connection = null;
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("amqmsg");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
 
            TextMessage message = session.createTextMessage(textMsg);
            producer.send(message);
 
            connection.close();
 
        } catch (JMSException ex) {
            System.out.println(ex.getMessage());
        }
    }  
    
    public NewManagedBeanJMS() {
    }
    
}
