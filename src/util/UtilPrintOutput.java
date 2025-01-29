package util;

public class UtilPrintOutput {
	
	@SafeVarargs
	public static <T> void printOutput(T... values) {
	    for (T value : values) {
	        System.out.println((String) value); 
	    }
	}
}
