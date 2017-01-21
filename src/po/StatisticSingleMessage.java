package po;

public class StatisticSingleMessage {

	private double timeOperation;
	private double timeCreateMess;

	public StatisticSingleMessage(double timeOperation,double timeCreateMess){
		this.timeOperation = timeOperation;
		this.timeCreateMess = timeCreateMess;
	}
	
	public double getTimeOperation() {
		return timeOperation;
	}

	public void setTimeOperation(double timeOperation) {
		this.timeOperation = timeOperation;
	}
	
	public double getTimeCreateMess() {
		return timeCreateMess;
	}
	
	public void setTimeCreateMess(double timeCreateMess) {
		this.timeCreateMess = timeCreateMess;
	}
	
}
