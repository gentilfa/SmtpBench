package utils;

public class Utils {

	public static StringBuilder createMessage(int sizeMess){
		
		StringBuilder res = new StringBuilder();
        for (int i = 0; i < sizeMess; i++) {
            res.append("A");
        }
        
        return res;
		
	}
	
	public static double nanoToSecond(long nano){
		
		double inSecond = (double)nano / 1000000000.0;
		return inSecond;
	}
	
	public static double nanoToSecondDouble(double nano){
		
		double inSecond = nano / 1000000000.0;
		return inSecond;
	}
	
}
