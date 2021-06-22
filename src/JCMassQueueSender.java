import javax.jms.InvalidDestinationException;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import com.walmart.axon.jms.AxonConnectionFactory;
import com.walmart.axon.jms.AxonQueue;


public class JCMassQueueSender {

	public static void main(String[] args) throws InvalidDestinationException {
       // AxonConnectionFactory factory = new AxonConnectionFactory();
      //  factory.setConfigurationLocation("/maas-jms-client-config.xml");

        //CachingConnectionFactory factory2 = new CachingConnectionFactory(factory);

        AxonQueue queue = new AxonQueue("WM.Q.LP");

        JmsTemplate template = new JmsTemplate();
        template.setDefaultDestination(queue);
       // template.setConnectionFactory(factory2);

       /* template.send(new MessageCreator() {

                        @Override
                        public Message createMessage(Session session) throws JMSException {
                                        TextMessage tm = session.createTextMessage("payload");
                                        System.out.println("Sending message " + tm.getText());
                                        return tm;
                        }
        });*/
        
        
        

}


}
