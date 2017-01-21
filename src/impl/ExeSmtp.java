package impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import po.MailPoThread;
import po.SmtpBenchParam;
import po.StatisticPojo;
import statistic.StatisticTime;
import thread.ExeCallable;

public class ExeSmtp {

	public static StatisticPojo executeBench(SmtpBenchParam param) throws InterruptedException{
		
		StatisticPojo res = null;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", param.getHost());
		props.put("mail.smtp.socketFactory.port", param.getPortSSL());
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", param.getPort());

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(param.getUser(),param.getPass());
				}
			});

		StatisticTime.init();
		StatisticTime.start();
		
		ExecutorService executor = Executors.newFixedThreadPool(30);
		List<Callable<MailPoThread>> lst = new ArrayList<Callable<MailPoThread>>();
		
		if(param.getNumMess() > 1){
			//invio di più messaggi
			for(int i = 0; i<param.getNumMess(); i++){
				MailPoThread obj = new MailPoThread(param.getMailFrom(), param.getMailTo(), "TEST BENCH SMTP", session, param.getSizeMessage()[0]);
				lst.add(new ExeCallable(obj));
			}
		}else{
			//invio di messaggi di dimensioni differenti
			for(int i = 0; i<param.getSizeMessage().length; i++){
				MailPoThread obj = new MailPoThread(param.getMailFrom(), param.getMailTo(), "TEST BENCH SMTP", session, param.getSizeMessage()[i]);
				lst.add(new ExeCallable(obj));
			}
		}
		
        executor.invokeAll(lst);
        
        executor.shutdown();
        StatisticTime.stop();
		res = StatisticTime.finalResult();
		
		return res;
	}
	
	
	
}
