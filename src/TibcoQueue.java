import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import javax.jms.*;
/*import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;*/


public class TibcoQueue {

	/* // Defines the JNDI context factory.
    public final static String JNDI_FACTORY="com.tibco.tibjms.naming.TibjmsInitialContextFactory";

    // Defines the JMS context factory.
    public final static String JMS_FACTORY="jms/TestConnectionFactory";

    // Defines the queue.
    public final static String QUEUE="CPW.GBR.POR.Public.Request.Order.Management.UpdateProvisioningStatus.1";

    private QueueConnectionFactory qconFactory;
    private ConnectionFactory conFactory;
    private QueueConnection qcon;
    private QueueSession qsession;
    private QueueSender qsender;
    private Queue queue;
    private TextMessage msg;
	*//**
     * Creates all the necessary objects for sending
     * messages to a JMS queue.
     *
     * @param ctx JNDI initial context
     * @param queueName name of queue
     * @exception NamingException if operation cannot be performed
     * @exception JMSException if JMS fails to initialize due to internal error
     *//*
    public void init(Context ctx, String queueName)
       throws NamingException, JMSException
    {

       qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_FACTORY);
       qcon = qconFactory.createQueueConnection();
       qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
       queue = (Queue) ctx.lookup(queueName);
       qsender = qsession.createSender(queue);
       msg = qsession.createTextMessage();
       qcon.start();
    }
    
	
	private static InitialContext getInitialContext(String url)  throws NamingException
         {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
            env.put(Context.PROVIDER_URL, url);
            return new InitialContext(env);
    }
	
	
	
	*//** main() method.
    *
    * @param args WebLogic Server URL
    * @exception Exception if operation fails
    *//*
    public static void main(String[] args) throws Exception {
       if (args.length != 1) {
        System.out.println("Usage: java examples.jms.queue.QueueSend WebLogicURL");
        return;
       }
       InitialContext ic = getInitialContext(args[0]);
       emm qs = new emm();
       qs.init(ic, QUEUE);
       readAndSend(qs);
       qs.close();
    }

    *//**
     * Closes JMS objects.
     * @exception JMSException if JMS fails to close objects due to internal error
     *//*
    public void close() throws JMSException {
       qsender.close();
       qsession.close();
       qcon.close();
    }
    
    *//**
     * Sends a message to a JMS queue.
     *
     * @param message  message to be sent
     * @exception JMSException if JMS fails to send message due to internal error
     *//*
    public void send(String message) throws JMSException {
       msg.setText(message);
       qsender.send(msg);
    }*/

}
