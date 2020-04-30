package beans;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@ApplicationScoped
public class SendManagedBean implements ISendBean{

    @Resource(mappedName = "amqmsg")
    private Queue amqmsg;

    @Inject
    @JMSConnectionFactory("amqres")
    private JMSContext context;

    /**
     * Creates a new instance of SendManagedBean
     */
    public SendManagedBean() {
    }

    @Override
    public void sendJMSMessageToAmqmsg(String messageData) {
        context.createProducer().send(amqmsg, messageData);
    }
    
}
