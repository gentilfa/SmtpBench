package po;

import java.util.List;

public class StatisticPojo {

	private double timeOperation;
	private List<StatisticSingleMessage> timesSingleMessage;
	private double minTime;
	private double maxTime;
	private double avgTime;
	private double incidenza;
	private String messageError;
	
	public StatisticPojo(){};
	
	public double getTimeOperation() {
		return timeOperation;
	}
	public void setTimeOperation(double timeOperation) {
		this.timeOperation = timeOperation;
	}
	public List<StatisticSingleMessage> getTimesSingleMessage() {
		return timesSingleMessage;
	}
	public void setTimesSingleMessage(List<StatisticSingleMessage> timesSingleMessage) {
		this.timesSingleMessage = timesSingleMessage;
	}
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public double getMinTime() {
		return minTime;
	}

	public void setMinTime(double minTime) {
		this.minTime = minTime;
	}

	public double getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(double maxTime) {
		this.maxTime = maxTime;
	}

	public double getAvgTime() {
		return avgTime;
	}

	public void setAvgTime(double avgTime) {
		this.avgTime = avgTime;
	}

	public double getIncidenza() {
		return incidenza;
	}

	public void setIncidenza(double incidenza) {
		this.incidenza = incidenza;
	}
	
	
}
