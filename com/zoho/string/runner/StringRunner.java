package com.stringrunner;

import com.stringtask.StringTask;
import com.stringexception.StringException;
import com.utils.StringValidator;
import java.util.*;

public class StringRunner {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args)throws StringException {
		StringTask task = new StringTask();
		int enteredchoice = 1;
		Boolean condition = true;
		
		do{

			try {
				
				System.out.println("Select an operation to perform:");
				System.out.println("1. Print String Length");
				System.out.println("2. Convert into Character Array");
				System.out.println("3. Penultimate Character");
				System.out.println("4. Number of Occurrences");
				System.out.println("5. Greatest Position of Character");
				System.out.println("6. Last N Characters");
				System.out.println("7. First N Characters");
				System.out.println("8. Replace First Three Characters");
				System.out.println("9. Check String Starts With");
				System.out.println("10. Check String Ends With");
				System.out.println("11. Convert to Uppercase");
				System.out.println("12. Convert to Lowercase");
				System.out.println("13. Reverse String");
				System.out.println("14. Accept Multiple String Line");
				System.out.println("15. Concatenate Strings");
				System.out.println("16. Enclose in Array");
				System.out.println("17. Merge Strings with Hyphen");
				System.out.println("18. Equal Case Sensitive");
				System.out.println("19. Equal Ignore Case Sensitive");
				System.out.println("20. Space Check");
				System.out.println("0. Exit");
				System.out.print("Enter your choice: ");
				
				while (condition == true){
					try {
						enteredchoice = scanner.nextInt();
						scanner.nextLine();
						break;
					}
					catch (InputMismatchException e){
						printOutput("Invalid Choice, Please enter a valid number ");
						scanner.nextLine();
					}
				}
				if(enteredchoice < 0 || enteredchoice > 20){
					printOutput("Invalid Choice, Enter a choice from 0 to 20");
				}
				
				switch (enteredchoice){
					case 1:
						case1(args , task);
						break;

					case 2:
						case2(task);
						break;

					case 3:
						case3(task);
						break;

					case 4:
						case4(task);
						break;

					case 5:
						case5(task);
						break;

					case 6:
						case6(task);
						break;

					case 7:
						case7(task);
						break;

					case 8:
						case8(task);
						break;

					case 9:
						case9(task);
						break;

					case 10:
						case10(task);
						break;

					case 11:
						case11(task);
						break;

					case 12:
						case12(task);
						break;

					case 13:
						case13(task);
						break;

					case 14:
						case14(task);
						break;
					
					case 15:
						case15(task);
						break;

					case 16:
						case16(task);
						break;

					case 17:
						case17(task);
						break;

					case 18:
						case18(task);
						break;

					case 19:
						case19(task);
						break;

					case 20:
						case20(task);
						break;

					case 0:
						printOutput("Terminated successfully");
						break;
				}
			}
		catch(StringException e){
			e.printStackTrace();
			}
		
		finally{
			System.out.println("Operation executed successfully");
		}
		}
		while (enteredchoice != 0);
	}

	public static String getStringInput(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

	public static int getIntInput(String prompt) {
	Boolean condition = true;
		while (condition == true) {
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

	public static void printOutput(String value) {
		System.out.println(value);
	}
	
	public static void printOutput(Boolean value) {
		System.out.println(value);
	}
	
	public static void printOutput(int value) {
		System.out.println(value);
	}

	public static void case1(String[] args, StringTask task) throws StringException  {
		if(args.length > 0){
			StringValidator.checkNullOrEmpty(args[0]);
			printOutput("Length of the String is " + task.getStringLength(args[0]));
		}
		else{
			printOutput("Input not found in the arguments");
		}

	}

	public static void case2(StringTask task) throws StringException {
		String chararrayinput = getStringInput("Enter a string to perform the selected operation: ");
		char[] arrayResult = task.convertCharArray(chararrayinput);
		printOutput("Character Array: ");
			for (char c : arrayResult) {
			System.out.print(c + " ");
			}
	}

	public static void case3(StringTask task) throws StringException {
	String penultimateinput = getStringInput("Enter a string to perform the selected operation: ");
	char penultimateResult = task.getPenultimateChar(penultimateinput, 2);
	printOutput("The character from last 2 places is " + penultimateResult);
	}

	public static void case4(StringTask task) throws StringException {
	String occurrenceinput = getStringInput("Enter a string to perform no. of Occurrences search: ");
	char searchingChar = getStringInput("Enter a character to search: ").charAt(0);
	printOutput("The Number of Occurrences of the char is " + task.getCharOccurrence(occurrenceinput , searchingChar));
	}

	public static void case5(StringTask task) throws StringException {
	String greatestpositioninput = getStringInput("Enter a string to perform no. of Occurrences search: ");
	char repeatingChar = getStringInput("Enter a character to find Greatest Position: ").charAt(0);
	if (task.getGreatestPosition(greatestpositioninput , repeatingChar) == -1){
		printOutput("No such character exists.");
	} else {
	printOutput("The greatest position of the char is " + task.getGreatestPosition(greatestpositioninput , repeatingChar));
	}
	}

	public static void case6(StringTask task) throws StringException {
	String lastncharinput = getStringInput("Enter a string to perform the selected operation: ");
	int noOfLastChars = getIntInput("Enter the number of characters to print from the last: ");
	printOutput("The last " + noOfLastChars + " characters are: " + task.getLastNChar(lastncharinput , noOfLastChars));
	}

	public static void case7(StringTask task) throws StringException {
	String firstncharinput = getStringInput("Enter a string to perform the selected operation: ");
	int noOfStartChars = getIntInput("Enter the number of characters to print from the beginning: ");
	printOutput("The First " + noOfStartChars + " characters are: " + task.getFirstNChar(firstncharinput , noOfStartChars));
	}
	
	public static void case8(StringTask task) throws StringException {
	String replacefirstninput = getStringInput("Enter a string to perform the selected operation: ");
	String replacementstring = getStringInput("Enter the string to replace: ");
	int replacelength = getIntInput("Enter the no. of characters to replace: ");
	String substringposition = getStringInput("Enter the position to place the substring: front/middle/rear ");
	printOutput("The Replaced String is: " + task.replaceSubstring(replacefirstninput , replacementstring , replacelength , substringposition));
	}
	
	public static void case9(StringTask task) throws StringException {
	String startswithinput = getStringInput("Enter a string to perform the selected operation: ");
	String startCheckString = getStringInput("Enter the string to check from the start: ");
	printOutput(task.compareStartChars(startswithinput , startCheckString));
	}
	
	public static void case10(StringTask task) throws StringException {
	String endswithinput = getStringInput("Enter a string to perform the selected operation: ");
	String endCheckString = getStringInput("Enter the string to check from the end: ");
	printOutput(task.compareEndChars(endswithinput , endCheckString));
	}
	
	public static void case11(StringTask task) throws StringException {
	String touppercaseinput = getStringInput("Enter a string to perform the selected operation: ");
	printOutput(task.convertingToUpperCase(touppercaseinput));
	}
	
	public static void case12(StringTask task) throws StringException {
	String tolowercaseinput = getStringInput("Enter a string to perform the selected operation: ");
	printOutput(task.convertingToLowerCase(tolowercaseinput));
	}
	
	public static void case13(StringTask task) throws StringException {
	String reversinginput = getStringInput("Enter a string to perform the selected operation: ");
	printOutput(task.reversingString(reversinginput));
	}
	
	public static void case14(StringTask task) throws StringException {
	String multiStringLine = getStringInput("Enter a line of multiple strings: ");
	StringValidator.checkNullOrEmpty(multiStringLine);
	printOutput("The Entered Multiple String line is: " + multiStringLine);
	}
	
	public static void case15(StringTask task) throws StringException {
	String concatenateStringLine = getStringInput("Enter a line of multiple strings: ");
	printOutput("The Concatenated String: " + task.concatenateMultipleStrings(concatenateStringLine , " "));
	}
	
	public static void case16(StringTask task) throws StringException {
	String toBeEnclosedLine = getStringInput("Enter a line of multiple strings: ");
	String splittingchars = getStringInput("Enter the enclosing character: ");
	String[] enclosedArray = task.encloseInArray(toBeEnclosedLine , splittingchars);
	printOutput("Enclosed Strings:");
	for (String str : enclosedArray){
		printOutput(str);
	}
	}
	
	public static void case17(StringTask task) throws StringException {
	Boolean condition = true;
	ArrayList<String> multiStringArrayList = new ArrayList<>();
	printOutput("Enter a line of multiple strings (enter an empty line to finish): ");
	while (condition == true) {
		String stringInput = scanner.nextLine();
		if (stringInput.isEmpty()) {
			break;
		}
		multiStringArrayList.add(stringInput);
	}
	CharSequence joiningcharacter = getStringInput("Enter the joining character: ");
	printOutput("Merged string: " + task.mergeStringWithSymbol(multiStringArrayList , joiningcharacter));
	}
	
	public static void case18(StringTask task) throws StringException {
	String firstStringLine = getStringInput("Enter the first string: ");
	String secondStringLine = getStringInput("Enter the second string: ");
	printOutput(task.areStringsCaseEqual(firstStringLine, secondStringLine));
	}
	
	public static void case19(StringTask task) throws StringException {
	String firstStringLineIC = getStringInput("Enter the first string: ");
	String secondStringLineIC = getStringInput("Enter the second string: ");
	printOutput(task.areStringsIgnoreCaseEqual(firstStringLineIC, secondStringLineIC));
	}
	
	public static void case20(StringTask task) throws StringException {
	String toBeTrimmedString = getStringInput("Enter the string: ");
	printOutput(task.trimString(toBeTrimmedString));
	}	
}