package string.runner;

import util.UtilGetInput;
import util.UtilPrintOutput;
import util.UtilValidator;
import string.task.StringTask;
import exception.CustomException;
import java.util.ArrayList;
import java.util.Scanner;

public class StringRunner {
	static Scanner scanner = new Scanner(System.in);
	StringTask task = new StringTask();
	
	public static void main(String[] args)throws CustomException {
		StringRunner runner = new StringRunner();
		runner.runOperations(args);
	}
	
	private void runOperations (String[] args) {
		int enteredchoice = 0;
		
		do{

			try {
				
				UtilPrintOutput.printOutput("Select an operation to perform:");
				UtilPrintOutput.printOutput("1. Print String Length");
				UtilPrintOutput.printOutput("2. Convert into Character Array");
				UtilPrintOutput.printOutput("3. Penultimate Character");
				UtilPrintOutput.printOutput("4. Number of Occurrences");
				UtilPrintOutput.printOutput("5. Greatest Position of Character");
				UtilPrintOutput.printOutput("6. Last N Characters");
				UtilPrintOutput.printOutput("7. First N Characters");
				UtilPrintOutput.printOutput("8. Replace Characters");
				UtilPrintOutput.printOutput("9. Check String Starts With");
				UtilPrintOutput.printOutput("10. Check String Ends With");
				UtilPrintOutput.printOutput("11. Convert to Uppercase");
				UtilPrintOutput.printOutput("12. Convert to Lowercase");
				UtilPrintOutput.printOutput("13. Reverse String");
				UtilPrintOutput.printOutput("14. Accept Multiple String Line");
				UtilPrintOutput.printOutput("15. Concatenate Strings");
				UtilPrintOutput.printOutput("16. Enclose in Array");
				UtilPrintOutput.printOutput("17. Merge Strings with Symbol");
				UtilPrintOutput.printOutput("18. Equal Case Sensitive");
				UtilPrintOutput.printOutput("19. Equal Ignore Case Sensitive");
				UtilPrintOutput.printOutput("20. Space Check");
				UtilPrintOutput.printOutput("0. Exit");
				
				enteredchoice = UtilGetInput.getIntInput("Enter your choice: ");
				
				if(enteredchoice < 0 || enteredchoice > 20){
					UtilPrintOutput.printOutput("Invalid Choice, Enter a choice from 0 to 20");
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
						UtilPrintOutput.printOutput("Terminated successfully");
						break;
				}
			}
		catch(CustomException e){
			e.printStackTrace();
			}
		
		finally{
			System.out.println("Operation executed successfully");
		}
		}
		while (enteredchoice != 0);
	}

	public void printStringLength (String[] args) throws CustomException  {
		if(args.length > 0){
			UtilValidator.isNull(args[0]);
			UtilPrintOutput.printOutput("Length of the String is " + task.getLength(args[0]));
		}
		else{
			UtilPrintOutput.printOutput("Input not found in the arguments");
		}

	}

	public void convertIntoCharacterArray() throws CustomException {
		String chararrayinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		char[] arrayResult = task.convertCharArray(chararrayinput);
		UtilPrintOutput.printOutput("Character Array: ");
		for (char c : arrayResult) {
			System.out.print(c + " ");
		}
	}

	public void penultimateCharacter() throws CustomException {
	String penultimateinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	char penultimateResult = task.getPenultimateChar(penultimateinput, 2);
	UtilPrintOutput.printOutput("The character from last 2 places is " + penultimateResult);
	}

	public void numberOfOccurrences() throws CustomException {
	String occurrenceinput = UtilGetInput.getStringInput("Enter a string to perform no. of Occurrences search: ");
	char searchingChar = UtilGetInput.getStringInput("Enter a character to search: ").charAt(0);
	UtilPrintOutput.printOutput("The Number of Occurrences of the char is " + task.getCharOccurrence(occurrenceinput , searchingChar));
	}

	public void greatestPositionOfCharacter() throws CustomException {
	String greatestpositioninput = UtilGetInput.getStringInput("Enter a string to perform no. of Occurrences search: ");
	char repeatingChar = UtilGetInput.getStringInput("Enter a character to find Greatest Position: ").charAt(0);
	if (task.getGreatestPosition(greatestpositioninput , repeatingChar) == -1){
		UtilPrintOutput.printOutput("No such character exists.");
	} else {
		UtilPrintOutput.printOutput("The greatest position of the char is " + task.getGreatestPosition(greatestpositioninput , repeatingChar));
	}
	}

	public void lastNCharacters() throws CustomException {
	String lastncharinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	int noOfLastChars = UtilGetInput.getIntInput("Enter the number of characters to print from the last: ");
	UtilPrintOutput.printOutput("The last " + noOfLastChars + " characters are: " + task.getLastNChar(lastncharinput , noOfLastChars));
	}

	public void firstNCharacters() throws CustomException {
	String firstncharinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	int noOfStartChars = UtilGetInput.getIntInput("Enter the number of characters to print from the beginning: ");
	UtilPrintOutput.printOutput("The First " + noOfStartChars + " characters are: " + task.getFirstNChar(firstncharinput , noOfStartChars));
	}
	
	public void replaceCharacters() throws CustomException {
	String replacefirstninput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	String replacementstring = UtilGetInput.getStringInput("Enter the string to replace: ");
	int replacelength = UtilGetInput.getIntInput("Enter the no. of characters to replace: ");
	UtilPrintOutput.printOutput("The Replaced String is: " + task.replaceSubstring(replacefirstninput , replacementstring , replacelength));
	}
	
	public void checkStringStartsWith() throws CustomException {
	String startswithinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	String startCheckString = UtilGetInput.getStringInput("Enter the string to check from the start: ");
	UtilPrintOutput.printOutput(task.compareStartChars(startswithinput , startCheckString));
	}
	
	public void checkStringEndsWith() throws CustomException {
	String endswithinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	String endCheckString = UtilGetInput.getStringInput("Enter the string to check from the end: ");
	UtilPrintOutput.printOutput(task.compareEndChars(endswithinput , endCheckString));
	}
	
	public void convertToUppercase() throws CustomException {
	String touppercaseinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	UtilPrintOutput.printOutput(task.convertingToUpperCase(touppercaseinput));
	}
	
	public void convertToLowercase() throws CustomException {
	String tolowercaseinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	UtilPrintOutput.printOutput(task.convertingToLowerCase(tolowercaseinput));
	}
	
	public void reverseString() throws CustomException {
	String reversinginput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
	UtilPrintOutput.printOutput(task.reversingString(reversinginput));
	}
	
	public void acceptMultipleStringLine() throws CustomException {
	String multiStringLine = UtilGetInput.getStringInput("Enter a line of multiple strings: ");
	UtilValidator.isNull(multiStringLine);
	UtilPrintOutput.printOutput("The Entered Multiple String line is: " + multiStringLine);
	}
	
	public void concatenateStrings() throws CustomException {
	String concatenateStringLine = UtilGetInput.getStringInput("Enter a line of multiple strings: ");
	UtilPrintOutput.printOutput("The Concatenated String: " + task.concatenateMultipleStrings(concatenateStringLine , " "));
	}
	
	public void encloseInArray() throws CustomException {
	String toBeEnclosedLine = UtilGetInput.getStringInput("Enter a line of multiple strings: ");
	String splittingchars = UtilGetInput.getStringInput("Enter the enclosing character: ");
	String[] enclosedArray = task.encloseInArray(toBeEnclosedLine , splittingchars);
	UtilPrintOutput.printOutput("Enclosed Strings:");
	for (String str : enclosedArray){
		UtilPrintOutput.printOutput(str);
	}
	}
	
	public void mergeStringsWithSymbol() throws CustomException {
	Boolean condition = true;
	ArrayList<String> multiStringArrayList = new ArrayList<>();
	UtilPrintOutput.printOutput("Enter a line of multiple strings (enter an empty line to finish): ");
	while (condition == true) {
		String stringInput = scanner.nextLine();
		if (stringInput.isEmpty()) {
			break;
		}
		multiStringArrayList.add(stringInput);
	}
	CharSequence joiningcharacter = UtilGetInput.getStringInput("Enter the joining character: ");
	UtilPrintOutput.printOutput("Merged string: " + task.mergeStringWithSymbol(multiStringArrayList , joiningcharacter));
	}
	
	public void equalCaseSensitive() throws CustomException {
	String firstStringLine = UtilGetInput.getStringInput("Enter the first string: ");
	String secondStringLine = UtilGetInput.getStringInput("Enter the second string: ");
	UtilPrintOutput.printOutput(task.areStringsCaseEqual(firstStringLine, secondStringLine));
	}
	
	public void equalIgnoreCaseSensitive() throws CustomException {
	String firstStringLineIC = UtilGetInput.getStringInput("Enter the first string: ");
	String secondStringLineIC = UtilGetInput.getStringInput("Enter the second string: ");
	UtilPrintOutput.printOutput(task.areStringsIgnoreCaseEqual(firstStringLineIC, secondStringLineIC));
	}
	
	public void spaceCheck() throws CustomException {
	String toBeTrimmedString = UtilGetInput.getStringInput("Enter the string: ");
	UtilPrintOutput.printOutput(task.trimString(toBeTrimmedString));
	}	
}