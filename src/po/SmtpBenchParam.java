package po;

import java.io.Serializable;

public class SmtpBenchParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1042752694236164619L;
	private String user;
	private String pass;
	private String host;
	private String port;
	private String portSSL;
	private String mailTo;
	private String mailFrom;
	private int numThread;
	private int numMess;
	private int[] sizeMessage;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public int getNumThread() {
		return numThread;
	}
	public void setNumThread(int numThread) {
		this.numThread = numThread;
	}
	public int getNumMess() {
		return numMess;
	}
	public void setNumMess(int numMess) {
		this.numMess = numMess;
	}
	public int[] getSizeMessage() {
		return sizeMessage;
	}
	public void setSizeMessage(int[] sizeMessage) {
		this.sizeMessage = sizeMessage;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getPortSSL() {
		return portSSL;
	}
	public void setPortSSL(String portSSL) {
		this.portSSL = portSSL;
	}
		
}
