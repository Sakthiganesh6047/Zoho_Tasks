package util;

import java.util.Scanner;
import exception.CustomException;

public class UtilGetInput {
	
	private static Scanner scanner = new Scanner(System.in);

	public static int getIntInput(String prompt) throws CustomException {
		System.out.print(prompt);
		try {
			int input = Integer.parseInt(scanner.nextLine());
			return input;
		} catch (NumberFormatException e) {
			throw new CustomException("Invalid input, please enter a valid integer" , e);
		}
	}
	
	public static double getDoubleInput(String prompt) throws CustomException {
        System.out.print(prompt);
        try {
            double input = Double.parseDouble(scanner.nextLine());
            return input;
        } catch (NumberFormatException e) {
        	throw new CustomException("Invalid input, please enter a valid decimal number." , e);
        }
	}
	
	public static long getLongInput(String prompt) throws CustomException {
        System.out.print(prompt);
        try {
            long input = Long.parseLong(scanner.nextLine());
            return input;
        } catch (NumberFormatException e) {
        	throw new CustomException("Invalid input, please enter a valid long integer." , e);
        }
    }

	public static String getStringInput(String prompt) {
		System.out.print(prompt);
		String input = scanner.nextLine();
		return input;
	}

}