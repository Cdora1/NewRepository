import java.util.ArrayList;

import javax.jms.DeliveryMode;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.tibco.tibjms.TibjmsQueueConnectionFactory;

import java.util.*;
/*import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;*/

public class RTPQueueSender{
	
	private String tibcoInstance;
	private String tibcoQueueName;
	private String userName;
	private String passWord;
	private QueueConnection queueConnection;
	private QueueSession queueSession;		
	private Queue sendQueue;
	private MessageProducer messageProducer;
	private MessageConsumer messageConsumer;
	
		
	public RTPQueueSender(String tibcoInstance, String tibcoQueueName, String userName, String password){
		this.tibcoInstance = tibcoInstance;
		this.tibcoQueueName = tibcoQueueName;
		this.userName = userName;
		this.passWord = password;
	}
	
	
	private void configureTibcoConnection() throws Exception{
		
		QueueConnectionFactory queueConnectionFactory =  new TibjmsQueueConnectionFactory(tibcoInstance);
		queueConnection = queueConnectionFactory.createQueueConnection(userName,passWord);
		queueSession = queueConnection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		sendQueue = queueSession.createQueue(tibcoQueueName);
		
	}
	
	private void configureProducer() throws Exception{
		
		configureTibcoConnection();
		
		messageProducer = queueSession.createProducer(sendQueue);
		messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
		queueConnection.start();
		
	}
	
	private void configureConsumer() throws Exception{
		
		configureTibcoConnection();

		messageConsumer = queueSession.createConsumer(sendQueue);
		queueConnection.start();
		
	}
    
	private void closeProducer() throws Exception{
		
		messageProducer.close();
		closeTibcoConnection();
		
	}
	private void closeConsumer() throws Exception{
		
		messageConsumer.close();
		closeTibcoConnection();
		
	}
	private void closeTibcoConnection() throws Exception{

		queueSession.close();
		queueConnection.stop();
		queueConnection.close();
		
	}
	
	public void sendMessage(String messageText, Hashtable<String, String> properties) throws Exception{
		
		configureProducer();
		
		TextMessage message = queueSession.createTextMessage(messageText);
		
		if(properties != null){
		
		Set<String> keySet = properties.keySet();
		Iterator it = keySet.iterator();
		for (String key: keySet)
			message.setStringProperty(key, properties.get(key));
		}
		
		messageProducer.send(message);
		System.out.println("Successfully pushed message:\n" + messageText);
		
		closeProducer();		
	}
	
	public void sendMessageById(String messageText) throws Exception{
		
		configureProducer();
		
		TextMessage message = queueSession.createTextMessage(messageText);
		message.setStringProperty("CONSUMER", "CANCELRESERVATION");
		message.setStringProperty("MODE", "CANCEL");
		messageProducer.send(message);
		System.out.println("Successfully pushed message:\n" + messageText);
		
		closeProducer();		
	}
	
	public void sendMessageByLines(String messageText) throws Exception{
		
		configureProducer();
		
		TextMessage message = queueSession.createTextMessage(messageText);
		//message.setStringProperty("CONSUMER", "CANCELRESERVATION");
		//message.setStringProperty("MODE", "LINECANCEL");
		messageProducer.send(message);		
		System.out.println("Successfully pushed message:\n" + messageText);
		
		closeProducer();		
	}

	public ArrayList<String> readTextMessages(int noOfMessages) throws Exception{
		
		configureConsumer();
		
		ArrayList<String> messages = new ArrayList<String>();
		Message message;
		
		while(noOfMessages >0 && (message = messageConsumer.receiveNoWait()) != null ){
			String orderMessage = ((TextMessage)message).getText();
			System.out.println("Pulled Message :- "+orderMessage);
			messages.add(orderMessage);
		}
		
		closeConsumer();
		
		return messages;
		
	}
	
    /*public String convertDateToString(Date date)
    {
        String orderDateString = null;
                if (date != null) {
                        DateTime dt = new DateTime(date);
                        DateTimeFormatter dtf = ISODateTimeFormat.dateTimeNoMillis();
                        orderDateString = dtf.print(dt);
                }
                return orderDateString;
    }*/
    
	public static void main(String args[]) throws Exception {
		
		String serverUrl = "tcp://ukgr-ems-qa5.walmart.com:7222";
		String userName = "emsca";
		String password = "emsca";
		String qName = "MTEP.WMT.GB.Q.CSL.CACHEREF.OB.1.0.XML";
		
		String jsonString = "{\"publishType\":\"RTP\", \"messageid\":12345, \"timeinmsecs\":1234544444444, \"env\":\"prod-jc\", \"assets\":[{\"assetType\":\"sku\",\"assetIds\":[\"34446306\", \"1000000453747\", \"1000002214981\"]},{\"assetType\":\"category\",\"assetIds\":[\"sku_id1\", \"sku_id2\"]}]}";
		
		TibcoQueueSender queueSender = new TibcoQueueSender(serverUrl, qName, userName, password);
		queueSender.sendMessage(jsonString, null);
		
		//ArrayList<String> list = queueSender.readTextMessages(1);
		//System.out.println(list.get(0));
	}
}
