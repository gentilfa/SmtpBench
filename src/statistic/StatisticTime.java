package statistic;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics;

import po.StatisticPojo;
import po.StatisticSingleMessage;
import utils.Utils;

public class StatisticTime {

	private static long startOperation;
	private static long endOperation;
	
	static SummaryStatistics messages;
	
	private static StatisticPojo statFinal;
	
	public static void init(){
		
		startOperation = 0;
		endOperation = 0;
		
		messages = new SynchronizedSummaryStatistics();
		
		statFinal = new StatisticPojo();
		statFinal.setTimesSingleMessage(new ArrayList<StatisticSingleMessage>());
		
	}
	
	public static void start(){
		
		startOperation = System.nanoTime();
	}
	
	public static void stop(){
		
		endOperation = System.nanoTime();
	}
	
	public static double timeOperation(){
		
		return Utils.nanoToSecond(endOperation - startOperation);
	}
	
	public static void setSingleMessage(long val){
		messages.addValue(val);
	}
	
	public static void resetSingleMessage(){
		messages = new SynchronizedSummaryStatistics();
	}
	
	public static void addDeliverMessagesTime(long timeDeliver, long timeCreateMessage){
		statFinal.getTimesSingleMessage().add(new StatisticSingleMessage(Utils.nanoToSecond(timeDeliver),Utils.nanoToSecond(timeCreateMessage)));
	}
	
	public static StatisticPojo finalResult(){
		statFinal.setTimeOperation(timeOperation());
		statFinal.setMinTime(Utils.nanoToSecondDouble(messages.getMin()));
		statFinal.setMaxTime(Utils.nanoToSecondDouble(messages.getMax()));
		statFinal.setAvgTime(Utils.nanoToSecondDouble(messages.getMean()));
		
		return statFinal;
	}
	
}
