package RegEx.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import RegEx.task.RegExTask;
import arraylist.runner.ArrayListRunner;
import util.CustomException;
import util.LoggerUtility;
import util.UtilGetInput;

public class RegExRunner {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerUtility.getLogger(ArrayListRunner.class , "/home/sakthi-pt7767/eclipse-workspace/Zoho_Tasks/LogFiles/RegexLogs"); 
	
	public static void main(String[] args) {
		RegExRunner runner = new RegExRunner();
		runner.runOperations();
	}
	
	private void runOperations() {
		int enteredChoice = 0;
		
		do {
			
			try {
			
				System.out.println("1. Check on MobileNumber");
				System.out.println("2. Check a given string is Alphanumeric");
				System.out.println("3. Operations on Strings");
				System.out.println("4. Comparing the strings in Lists");
				System.out.println("5. Email Validation");
				System.out.println("6. Checking the length of the strings");
				System.out.println("7. Creating a map of matching string");
				System.out.println("8. HTML Extraction");
				System.out.println("0. Terminate Program");
				enteredChoice = UtilGetInput.getIntInput("Enter the choice of operation: ");
				
				 if (enteredChoice < 0 || enteredChoice > 8) {
					 System.out.println("Invalid Choice, Enter a choice from 0 to 8");
				 }
				
				switch(enteredChoice) {
				case 1:
					exercise1();
					break;
					
				case 2:
					exercise2();
					break;
					
				case 3:
					exercise3();
					break;
					
				case 4:
					exercise4();
					break;
					
				case 5:
					exercise5();
					break;
					
				case 6:
					exercise6();
					break;
					
				case 7:
					exercise7();
					break;
					
				case 8:
					exercise8();
					break;
					
				case 0:
					System.out.println("Terminated Successfully!");
					break;
					
				}
			} catch (Exception e) {
				System.out.println("An Error occured: " + e.getMessage());
			}
		}
		while (enteredChoice != 0);
	}
	
	private void exercise1() throws CustomException {
		String mobileNumber = UtilGetInput.getStringInput("Enter your Mobile Number: ");
		RegExTask regExTask = RegExTask.getRegExTaskInstance();
		if (regExTask.isValidMobileNumber(mobileNumber)) {
			System.out.println("Valid mobile number.");
        } else {
            System.out.println("Invalid mobile number. Please enter a 10-digit number starting with 7, 8, or 9.");
		}
	}
	
	private void exercise2() throws CustomException {
		String alphanumericinput = UtilGetInput.getStringInput("Enter the Alphanumeric String: ");
		RegExTask regExTask = RegExTask.getRegExTaskInstance();
		if (regExTask.isAlphaNumeric(alphanumericinput)) {
	            System.out.println("Valid alphanumeric string.");
	        } else {
	            System.out.println("Invalid input. Only letters and digits are allowed (no special characters).");
	        }
	}
	
	private void exercise3() throws CustomException {
		String inputString = UtilGetInput.getStringInput("Enter the input string: ");
		String matchingString = UtilGetInput.getStringInput("Enter the string for compare with: ");
		RegExTask regExTask = RegExTask.getRegExTaskInstance();
		System.out.println("Starts with matching string? " + regExTask.checkStringStartsWith(inputString, matchingString));
		System.out.println("Contains the matching string? " + regExTask.checkStringContains(inputString, matchingString));
		System.out.println("Ends with matching string? " + regExTask.checkStringEndsWith(inputString, matchingString));
		System.out.println("Exact match of matching string? " + regExTask.checkStringExactMatch(inputString, matchingString));
	}
		
	private void exercise4() throws CustomException {
		List<String> inputList = createArrayListWithStrings();
		String matchingString = UtilGetInput.getStringInput("Enter the matching string: ");
		RegExTask regExTask = RegExTask.getRegExTaskInstance();
		System.out.println(regExTask.findCaseInsensitiveMatches(inputList , matchingString));
	}
	
	private void exercise5() throws CustomException {
		String email = UtilGetInput.getStringInput("Enter the email: ");
		RegExTask regExTask = RegExTask.getRegExTaskInstance();
		System.out.println(regExTask.isValidEmail(email));
	}
	
	private void exercise6() throws CustomException {
		List<String> inputList = createArrayListWithStrings();
		RegExTask regExTask = RegExTask.getRegExTaskInstance();
		System.out.println(regExTask.checkLenghtOfStrings(inputList));
	}
	
	private void exercise7() throws CustomException {
		List<String> inputList1 = createArrayListWithStrings();
		List<String> inputList2 = createArrayListWithStrings();
		RegExTask regExTask = RegExTask.getRegExTaskInstance();
		System.out.println(regExTask.findMatchingIndices(inputList1, inputList2));
	}
	
	private void exercise8() throws CustomException {
		String html = UtilGetInput.getStringInput("Enter the HTML string to ");
		RegExTask regExTask = RegExTask.getRegExTaskInstance();
		System.out.println(regExTask.extractTags(html));
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> createArrayListWithStrings() throws CustomException {
		List<T> arrayList = new ArrayList<>();
		int stringCount = UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		for (int i = 0; i < stringCount; i++) {
			arrayList.add((T) UtilGetInput.getStringInput("Enter the String " + (i+1) + ":"));
        }
		return arrayList;
	}
}
