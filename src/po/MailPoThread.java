package po;

import javax.mail.Session;

public class MailPoThread {

	private String mailFrom;
	private String mailTo;
	private String subject;
	private int sizeMessage;
	private Session session;
	
	public MailPoThread(String mailFrom, String mailTo, String subject, Session session, int sizeMessage){
		this.mailFrom = mailFrom;
		this.mailTo = mailTo;
		this.subject = subject;
		this.session = session;
		this.sizeMessage = sizeMessage;
	}
	
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public int getSizeMessage() {
		return sizeMessage;
	}
	public void setSizeMessage(int sizeMessage) {
		this.sizeMessage = sizeMessage;
	}
	
}
