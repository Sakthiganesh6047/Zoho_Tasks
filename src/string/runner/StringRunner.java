package string.runner;

import util.CustomException;
import util.UtilGetInput;
import util.UtilValidator;

import java.util.ArrayList;
import java.util.logging.Logger;

import string.task.StringTask;

public class StringRunner {
	
	StringTask task = new StringTask();
	private static final Logger logger = Logger.getLogger(StringRunner.class.getName());
	
	public static void main(String[] args)throws CustomException {
		StringRunner runner = new StringRunner();
		runner.runOperations(args);
	}
	
	private void runOperations (String[] args) {
		int enteredchoice = 0;
		
		do{

			try {
				
				logger.info("Select an operation to perform:");
				logger.info("1. Print String Length");
				logger.info("2. Convert into Character Array");
				logger.info("3. Penultimate Character");
				logger.info("4. Number of Occurrences");
				logger.info("5. Greatest Position of Character");
				logger.info("6. Last N Characters");
				logger.info("7. First N Characters");
				logger.info("8. Replace Characters");
				logger.info("9. Check String Starts With");
				logger.info("10. Check String Ends With");
				logger.info("11. Convert to Uppercase");
				logger.info("12. Convert to Lowercase");
				logger.info("13. Reverse String");
				logger.info("14. Accept Multiple String Line");
				logger.info("15. Concatenate Strings");
				logger.info("16. Enclose in Array");
				logger.info("17. Merge Strings with Symbol");
				logger.info("18. Equal Case Sensitive");
				logger.info("19. Equal Ignore Case Sensitive");
				logger.info("20. Space Check");
				logger.info("0. Exit");
				
				enteredchoice = UtilGetInput.getIntInput("Enter your choice: ");
				
				if(enteredchoice < 0 || enteredchoice > 20){
					logger.info("Invalid Choice, Enter a choice from 0 to 20");
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
						logger.info("Terminated successfully");
						break;
				}
			}
		catch(CustomException e){
			e.printStackTrace();
			}
		
		finally{
			logger.info("Operation executed successfully");
		}
		}
		while (enteredchoice != 0);
	}

	public void printStringLength (String[] args) throws CustomException  {
		if(args.length > 0){
			UtilValidator.isNull(args[0]);
			logger.info("Length of the String is " + task.getLength(args[0]));
		}
		else{
			logger.info("Input not found in the arguments");
		}

	}

	public void convertIntoCharacterArray() throws CustomException {
		String chararrayinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		char[] arrayResult = task.convertCharArray(chararrayinput);
		logger.info("Character Array: ");
		for (char c : arrayResult) {
			logger.info(c + " ");
		}
	}

	public void penultimateCharacter() throws CustomException {
		String penultimateinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		char penultimateResult = task.getPenultimateChar(penultimateinput, 2);
		logger.info("The character from last 2 places is " + penultimateResult);
	}

	public void numberOfOccurrences() throws CustomException {
		String occurrenceinput = UtilGetInput.getStringInput("Enter a string to perform no. of Occurrences search: ");
		char searchingChar = UtilGetInput.getStringInput("Enter a character to search: ").charAt(0);
		logger.info("The Number of Occurrences of the char is " + task.getCharOccurrence(occurrenceinput , searchingChar));
	}

	public void greatestPositionOfCharacter() throws CustomException {
		String greatestpositioninput = UtilGetInput.getStringInput("Enter a string to perform no. of Occurrences search: ");
		char repeatingChar = UtilGetInput.getStringInput("Enter a character to find Greatest Position: ").charAt(0);
		if (task.getGreatestPosition(greatestpositioninput , repeatingChar) == -1){
			logger.info("No such character exists.");
		} else {
			logger.info("The greatest position of the char is " + task.getGreatestPosition(greatestpositioninput , repeatingChar));
		}
	}

	public void lastNCharacters() throws CustomException {
		String lastncharinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		int noOfLastChars = UtilGetInput.getIntInput("Enter the number of characters to print from the last: ");
		logger.info("The last " + noOfLastChars + " characters are: " + task.getLastNChar(lastncharinput , noOfLastChars));
	}

	public void firstNCharacters() throws CustomException {
		String firstncharinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		int noOfStartChars = UtilGetInput.getIntInput("Enter the number of characters to print from the beginning: ");
		logger.info("The First " + noOfStartChars + " characters are: " + task.getFirstNChar(firstncharinput , noOfStartChars));
	}
	
	public void replaceCharacters() throws CustomException {
		String replacefirstninput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		String replacementstring = UtilGetInput.getStringInput("Enter the string to replace: ");
		int replacelength = UtilGetInput.getIntInput("Enter the no. of characters to replace: ");
		logger.info("The Replaced String is: " + task.replaceSubstring(replacefirstninput , replacementstring , replacelength));
	}
	
	public void checkStringStartsWith() throws CustomException {
		String startswithinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		String startCheckString = UtilGetInput.getStringInput("Enter the string to check from the start: ");
		logger.info("The Result is: " + task.compareStartChars(startswithinput , startCheckString));
	}
	
	public void checkStringEndsWith() throws CustomException {
		String endswithinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		String endCheckString = UtilGetInput.getStringInput("Enter the string to check from the end: ");
		logger.info("The Result is: " + task.compareEndChars(endswithinput , endCheckString));
	}
	
	public void convertToUppercase() throws CustomException {
		String touppercaseinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		logger.info(task.convertingToUpperCase(touppercaseinput));
	}
	
	public void convertToLowercase() throws CustomException {
		String tolowercaseinput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		logger.info(task.convertingToLowerCase(tolowercaseinput));
	}
	
	public void reverseString() throws CustomException {
		String reversinginput = UtilGetInput.getStringInput("Enter a string to perform the selected operation: ");
		logger.info(task.reversingString(reversinginput));
	}
	
	public void acceptMultipleStringLine() throws CustomException {
		String multiStringLine = UtilGetInput.getStringInput("Enter a line of multiple strings: ");
		UtilValidator.isNull(multiStringLine);
		logger.info("The Entered Multiple String line is: " + multiStringLine);
	}
	
	public void concatenateStrings() throws CustomException {
		String concatenateStringLine = UtilGetInput.getStringInput("Enter a line of multiple strings: ");
		logger.info("The Concatenated String: " + task.concatenateMultipleStrings(concatenateStringLine , " "));
	}
	
	public void encloseInArray() throws CustomException {
		String toBeEnclosedLine = UtilGetInput.getStringInput("Enter a line of multiple strings: ");
		String splittingchars = UtilGetInput.getStringInput("Enter the enclosing character: ");
		String[] enclosedArray = task.encloseInArray(toBeEnclosedLine , splittingchars);
		logger.info("Enclosed Strings:");
		for (String str : enclosedArray){
			logger.info(str);
		}
	}
	
	public void mergeStringsWithSymbol() throws CustomException {
		Boolean condition = true;
		ArrayList<String> multiStringArrayList = new ArrayList<>();
		logger.info("Enter a line of multiple strings (enter an empty line to finish): ");
		while (condition == true) {
			String stringInput = UtilGetInput.getStringInput(null);
			if (stringInput.isEmpty()) {
				break;
			}
			multiStringArrayList.add(stringInput);
		}
		CharSequence joiningcharacter = UtilGetInput.getStringInput("Enter the joining character: ");
		logger.info("Merged string: " + task.mergeStringWithSymbol(multiStringArrayList , joiningcharacter));
	}
	
	public void equalCaseSensitive() throws CustomException {
		String firstStringLine = UtilGetInput.getStringInput("Enter the first string: ");
		String secondStringLine = UtilGetInput.getStringInput("Enter the second string: ");
		logger.info("The Result is: " + task.areStringsCaseEqual(firstStringLine, secondStringLine));
	}
	
	public void equalIgnoreCaseSensitive() throws CustomException {
		String firstStringLineIC = UtilGetInput.getStringInput("Enter the first string: ");
		String secondStringLineIC = UtilGetInput.getStringInput("Enter the second string: ");
		logger.info("The Result is: " + task.areStringsIgnoreCaseEqual(firstStringLineIC, secondStringLineIC));
	}
	
	public void spaceCheck() throws CustomException {
		String toBeTrimmedString = UtilGetInput.getStringInput("Enter the string: ");
		logger.info(task.trimString(toBeTrimmedString));
	}	
}