package thread;

import java.util.concurrent.Callable;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import po.MailPoThread;
import statistic.StatisticTime;
import utils.Utils;

public class ExeCallable implements Callable<MailPoThread> {

	private MailPoThread poThread;
    
    public ExeCallable(MailPoThread poThread) {
        this.poThread = poThread;
    }
     
    public MailPoThread call() throws Exception {
        
    	long start = 0;
    	long end = 0;
    	
    	long startMess = 0;
    	long endMess = 0;
    	
    	startMess = System.nanoTime();
    	MimeMessage message = new MimeMessage(poThread.getSession());
		message.setFrom(new InternetAddress(poThread.getMailFrom()));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(poThread.getMailTo()));
		message.setSubject(poThread.getSubject());
		message.setText(Utils.createMessage(poThread.getSizeMessage()).toString(),"utf-8","plain");
		endMess = System.nanoTime();
		
		start = System.nanoTime();
		Transport.send(message);
		end = System.nanoTime(); 
		
		StatisticTime.setSingleMessage((end - start) + (endMess - startMess));
		StatisticTime.addDeliverMessagesTime(end - start,endMess - startMess);
		
		return poThread;
    }
	
}
