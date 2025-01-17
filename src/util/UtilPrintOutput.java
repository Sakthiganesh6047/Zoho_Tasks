package util;

import java.util.logging.Logger;

public class UtilPrintOutput {
	
	private static final Logger logger = Logger.getLogger(UtilPrintOutput.class.getName());
	
	public static <T> void printOutput(T value) {
			logger.info((String) value);
		}
}
