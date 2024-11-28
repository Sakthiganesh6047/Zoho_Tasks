package com.zoho.string.runner;

import com.zoho.util.getinput.UtilGetInput;
import com.zoho.string.task.StringTask;
import com.zoho.string.exception.StringException;
import com.zoho.string.validator.StringValidator;
import java.util.*;

public class StringRunner {
	static Scanner scanner = new Scanner(System.in);
	StringTask task = new StringTask();
	
	public static void main(String[] args)throws StringException {
		StringRunner runner = new StringRunner();
		runner.runOperations(args);
	}
	
	private void runOperations (String[] args) {
		int enteredchoice = 0;
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
				System.out.println("8. Replace Characters");
				System.out.println("9. Check String Starts With");
				System.out.println("10. Check String Ends With");
				System.out.println("11. Convert to Uppercase");
				System.out.println("12. Convert to Lowercase");
				System.out.println("13. Reverse String");
				System.out.println("14. Accept Multiple String Line");
				System.out.println("15. Concatenate Strings");
				System.out.println("16. Enclose in Array");
				System.out.println("17. Merge Strings with Symbol");
				System.out.println("18. Equal Case Sensitive");
				System.out.println("19. Equal Ignore Case Sensitive");
				System.out.println("20. Space Check");
				System.out.println("0. Exit");
				
				enteredchoice = UtilGetInput.getIntInput("Enter your choice: ");
				
				if(enteredchoice < 0 || enteredchoice > 20){
					printOutput("Invalid Choice, Enter a choice from 0 to 20");
				}
				
				switch (enteredchoice){
					case 1:
						printStringLength (args);
						break;

					case 2:
						convertIntoCharacterArray();
						break;

					case 3:
						penultimateCharacter();
						break;

					case 4:
						numberOfOccurrences();
						break;

					case 5:
						greatestPositionOfCharacter();
						break;

					case 6:
						lastNCharacters();
						break;

					case 7:
						firstNCharacters();
						break;

					case 8:
						replaceCharacters();
						break;

					case 9:
						checkStringStartsWith();
						break;

					case 10:
						checkStringEndsWith();
						break;

					case 11:
						convertToUppercase();
						break;

					case 12:
						convertToLowercase();
						break;

					case 13:
						reverseString();
						break;

					case 14:
						acceptMultipleStringLine();
						break;
					
					case 15:
						concatenateStrings();
						break;

					case 16:
						encloseInArray();
						break;

					case 17:
						mergeStringsWithSymbol();
						break;

					case 18:
						equalCaseSensitive();
						break;

					case 19:
						equalIgnoreCaseSensitive();
						break;

					case 20:
						spaceCheck();
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

	public static void printOutput(String value) {
		System.out.println(value);
	}
	
	public static void printOutput(Boolean value) {
		System.out.println(value);
	}
	
	public static void printOutput(int value) {
		System.out.println(value);
	}

	public void printStringLength (String[] args) throws StringException  {
		if(args.length > 0){
			StringValidator.checkNullOrEmpty(args[0]);
			printOutput("Length of the String is " + task.getLength(args[0]));
		}
		else{
			printOutput("Input not found in the arguments");
		}

	}

	public void convertIntoCharacterArray() throws StringException {
		String chararrayinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		char[] arrayResult = task.convertCharArray(chararrayinput);
		printOutput("Character Array: ");
			for (char c : arrayResult) {
			System.out.print(c + " ");
			}
	}

	public void penultimateCharacter() throws StringException {
	String penultimateinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	char penultimateResult = task.getPenultimateChar(penultimateinput, 2);
	printOutput("The character from last 2 places is " + penultimateResult);
	}

	public void numberOfOccurrences() throws StringException {
	String occurrenceinput = UtilGetInput.getStringInput("Enter a string to perform no. of Occurrences search: ");
	char searchingChar = UtilGetInput.getStringInput("Enter a character to search: ").charAt(0);
	printOutput("The Number of Occurrences of the char is " + task.getCharOccurrence(occurrenceinput , searchingChar));
	}

	public void greatestPositionOfCharacter() throws StringException {
	String greatestpositioninput = UtilGetInput.getStringInput("Enter a string to perform no. of Occurrences search: ");
	char repeatingChar = UtilGetInput.getStringInput("Enter a character to find Greatest Position: ").charAt(0);
	if (task.getGreatestPosition(greatestpositioninput , repeatingChar) == -1){
		printOutput("No such character exists.");
	} else {
	printOutput("The greatest position of the char is " + task.getGreatestPosition(greatestpositioninput , repeatingChar));
	}
	}

	public void lastNCharacters() throws StringException {
	String lastncharinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	int noOfLastChars = UtilGetInput.getIntInput("Enter the number of characters to print from the last: ");
	printOutput("The last " + noOfLastChars + " characters are: " + task.getLastNChar(lastncharinput , noOfLastChars));
	}

	public void firstNCharacters() throws StringException {
	String firstncharinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	int noOfStartChars = UtilGetInput.getIntInput("Enter the number of characters to print from the beginning: ");
	printOutput("The First " + noOfStartChars + " characters are: " + task.getFirstNChar(firstncharinput , noOfStartChars));
	}
	
	public void replaceCharacters() throws StringException {
	String replacefirstninput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	String replacementstring = UtilGetInput.getStringInput("Enter the string to replace: ");
	int replacelength = UtilGetInput.getIntInput("Enter the no. of characters to replace: ");
	printOutput("The Replaced String is: " + task.replaceSubstring(replacefirstninput , replacementstring , replacelength));
	}
	
	public void checkStringStartsWith() throws StringException {
	String startswithinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	String startCheckString = UtilGetInput.getStringInput("Enter the string to check from the start: ");
	printOutput(task.compareStartChars(startswithinput , startCheckString));
	}
	
	public void checkStringEndsWith() throws StringException {
	String endswithinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	String endCheckString = UtilGetInput.getStringInput("Enter the string to check from the end: ");
	printOutput(task.compareEndChars(endswithinput , endCheckString));
	}
	
	public void convertToUppercase() throws StringException {
	String touppercaseinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	printOutput(task.convertingToUpperCase(touppercaseinput));
	}
	
	public void convertToLowercase() throws StringException {
	String tolowercaseinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	printOutput(task.convertingToLowerCase(tolowercaseinput));
	}
	
	public void reverseString() throws StringException {
	String reversinginput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	printOutput(task.reversingString(reversinginput));
	}
	
	public void acceptMultipleStringLine() throws StringException {
	String multiStringLine = UtilGetInput.getStringInput("Enter a line of multiple strings: ");
	StringValidator.checkNullOrEmpty(multiStringLine);
	printOutput("The Entered Multiple String line is: " + multiStringLine);
	}
	
	public void concatenateStrings() throws StringException {
	String concatenateStringLine = UtilGetInput.getStringInput("Enter a line of multiple strings: ");
	printOutput("The Concatenated String: " + task.concatenateMultipleStrings(concatenateStringLine , " "));
	}
	
	public void encloseInArray() throws StringException {
	String toBeEnclosedLine = UtilGetInput.getStringInput("Enter a line of multiple strings: ");
	String splittingchars = UtilGetInput.getStringInput("Enter the enclosing character: ");
	String[] enclosedArray = task.encloseInArray(toBeEnclosedLine , splittingchars);
	printOutput("Enclosed Strings:");
	for (String str : enclosedArray){
		printOutput(str);
	}
	}
	
	public void mergeStringsWithSymbol() throws StringException {
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
	CharSequence joiningcharacter = UtilGetInput.getStringInput("Enter the joining character: ");
	printOutput("Merged string: " + task.mergeStringWithSymbol(multiStringArrayList , joiningcharacter));
	}
	
	public void equalCaseSensitive() throws StringException {
	String firstStringLine = UtilGetInput.getStringInput("Enter the first string: ");
	String secondStringLine = UtilGetInput.getStringInput("Enter the second string: ");
	printOutput(task.areStringsCaseEqual(firstStringLine, secondStringLine));
	}
	
	public void equalIgnoreCaseSensitive() throws StringException {
	String firstStringLineIC = UtilGetInput.getStringInput("Enter the first string: ");
	String secondStringLineIC = UtilGetInput.getStringInput("Enter the second string: ");
	printOutput(task.areStringsIgnoreCaseEqual(firstStringLineIC, secondStringLineIC));
	}
	
	public void spaceCheck() throws StringException {
	String toBeTrimmedString = UtilGetInput.getStringInput("Enter the string: ");
	printOutput(task.trimString(toBeTrimmedString));
	}	
}