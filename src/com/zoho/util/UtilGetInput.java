package com.zoho.util.getinput;

import java.util.*;

public class UtilGetInput {
	
	static Scanner scanner = new Scanner(System.in);

	public static int getIntInput(String prompt) {
	Boolean condition = true;
		while (condition) {
			System.out.print(prompt);
			try {
				int input = Integer.parseInt(scanner.nextLine());
				condition = false;
				return input;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter a valid integer.");
			}
		}
		return 0;
	}
	
	public static String getStringInput(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

}