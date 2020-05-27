package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
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
           Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", ex);
        }
    }
    
    public String receiveMessage(){
        Connection connection = null;
        String msgStr = "";
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("amqmsg");
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            Message msg;
            msg = consumer.receive(60);
            if (msg==null) return "В очереди нет сообщений";
            TextMessage textMsg = (TextMessage)msg;
            msgStr = msg.getJMSMessageID() + " ТЕКСТ: " + textMsg.getText(); 
            connection.close();
        }catch (JMSException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", ex);
        }
        return msgStr;
    }
    
    public NewManagedBeanJMS() {
    }
    
}
