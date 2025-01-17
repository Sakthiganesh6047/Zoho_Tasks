package util;

import java.util.Scanner;
import java.util.logging.Logger;

public class UtilGetInput {
	
	private static Scanner scanner = new Scanner(System.in);
	private static final Logger logger = Logger.getLogger(UtilGetInput.class.getName());

	public static int getIntInput(String prompt) throws CustomException {
		logger.info(prompt);
		try {
			int input = Integer.parseInt(scanner.nextLine());
			return input;
		} catch (NumberFormatException e) {
			throw new CustomException("Invalid input, please enter a valid integer" , e);
		}
	}
	
	public static double getDoubleInput(String prompt) throws CustomException {
        logger.info(prompt);
        try {
            double input = Double.parseDouble(scanner.nextLine());
            return input;
        } catch (NumberFormatException e) {
        	throw new CustomException("Invalid input, please enter a valid decimal number." , e);
        }
	}
	
	public static long getLongInput(String prompt) throws CustomException {
        logger.info(prompt);
        try {
            long input = Long.parseLong(scanner.nextLine());
            return input;
        } catch (NumberFormatException e) {
        	throw new CustomException("Invalid input, please enter a valid long integer." , e);
        }
    }

	public static String getStringInput(String prompt) {
		logger.info(prompt);
		String input = scanner.nextLine();
		return input;
	}

}