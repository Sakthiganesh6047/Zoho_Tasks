package com.zoho.stringbuilder.runner;

import com.zoho.stringbuilder.StringBuilderRunner;
import java.util.*;

public class StringBuilderRunner{
	static Scanner scanner = new Scanner(System.in);
	StringBuilderTask task = new StringBuilderTask();
	
	public static void main(String[] args){
		StringBuilderRunner runner = new StringBuilderRunner();
		runner.runOperations();

	
	private void runOperations() {
		
		int enteredchoice = 0;
		Boolean condition = true;
		
		do {
			
			System.out.println("Select an operation to perform:");
			System.out.println("1. Create a StringBuilder and add strings to it");
			System.out.println("2. Create a StringBuilder and add strings to it with a seperator");
			System.out.println("3. Create a StringBuilder and insert another strings");
			System.out.println("4. Create a StringBuilder and delete strings");
			System.out.println("5. Create a StringBuilder and replace the Seperator");
			System.out.println("6. Create a StringBuilder and reverse it");
			System.out.println("7. Create a StringBuilder and delete characters");
			System.out.println("8. Create a StringBuilder and replace characters");
			System.out.println("9. Create a StringBuilder and find the first seperator index");
			System.out.println("10. Create a StringBuilder and find the last seperator index");
			System.out.println("0. Exit");
			
			enteredchoice = getIntInput("Enter a choice from 0 to 10: ");
			
			if(enteredchoice < 0 || enteredchoice > 10){
				printOutput("Invalid Choice, Enter a choice from 0 to 10");
			}
			
			switch (enteredchoice){
				case 1:
					createAndAddStringsToIt();
					break;
				
				case 2:
					addStringsWithSeperator();
					break;
					
				case 3:
					insertAnotherStrings();
					break;
					
				case 4:
					deleteStrings();
					break;
					
				case 5:
					replaceSeperator();
					break;
					
				case 6:
					reverseStringBuilder();
					break;
					
				case 7:
					deleteCharacters();
					break;
					
				case 8:
					replaceCharacters();
					break;
					
				case 9:
					firstSeperatorIndex();
					break;
					
				case 10:
					lastSeperatorIndex();
					break;
					
				case 0:
					printOutput("Terminated successfully");
					break;
			}
		}
		while (enteredchoice != 0);
	}
	}
	
	public static String[] getStringInput(){
	System.out.print("Enter the number of strings you want to input: ");
        int numStrings = scanner.nextInt();
		scanner.nextLine();
        String[] strings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }
	return strings;
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
				printOutput("Invalid input, please enter a valid integer.");
			}
		}
		scanner.nextLine();
		return 0;
	}
	
	public static String getSeperator() {
		System.out.print("Enter the character to seperate strings: ");
		return scanner.nextLine();
	}
	
	public static String getString(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}
	
	public static int getDeleteStringIndex(StringBuilder createdSB , String seperator , StringBuilderTask task) {
		printOutput("The Available Strings are: ");
		String[] splittedarray = task.splitStringBuilder(createdSB , seperator);
		for(int i = 0; i < splittedarray.length; i++) {
			printOutput(i+1 + ". " + splittedarray[i]);
		}
		return getIntInput("Enter the index of the string you want to delete: ");
	}
	
	public static void printOutput(String value) {
		System.out.println(value);
	}
	
	public static void printOutput(int value) {
		System.out.println(value);
	}
	
	public static void createAndAddStringsToIt (StringBuilderTask task){
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		printOutput(task.getLength(createdSB));
		String[] addstringsinput = getStringInput();
		task.addToStringBuilder(addstringsinput , createdSB , seperator);
		
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
	}
	
	public static void addStringsWithSeperator (StringBuilderTask task){
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		printOutput(task.getLength(createdSB));
		String[] addstringsinput = getStringInput();
		task.addToStringBuilder(addstringsinput , createdSB , seperator);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
	}
	
	public static void insertAnotherStrings (StringBuilderTask task){
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
		String[] insertstrings = getStringInput();
		int insertafterno = getIntInput("Enter the index of the existing string to insert these strings: ");
		task.insertToStringBuilder(insertstrings , stringbuilderinput , createdSB , seperator , insertafterno);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
	}
	
	public static void deleteStrings (StringBuilderTask task){
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
		int delstringindex = getDeleteStringIndex(createdSB , seperator , task);
		createdSB = task. 	(createdSB , delstringindex , seperator);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
	}
	
	public static void replaceSeperator (StringBuilderTask task) {
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		String newseperator = getString("Enter the replacement seperator: ");
		createdSB = task.replaceSeperator(createdSB , seperator , newseperator);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
	}
	
	public static void reverseStringBuilder (StringBuilderTask task){
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
		createdSB = task.reversingString(createdSB);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
	}
	
	public static void deleteCharacters (StringBuilderTask task) {
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		int startcharindex = getIntInput("Enter the starting char index to delete: ");
		int endcharindex = getIntInput("Enter the ending char index to delete;  ");
		createdSB = task.deleteCharsInSB(createdSB , startcharindex , endcharindex);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
	}
	
	public static void replaceCharacters (StringBuilderTask task) {
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		printOutput(task.getLength(createdSB));
		String replacementstring = getString("Enter the replacement string: ");
		int startcharindex = getIntInput("Enter the starting char index to substitute the string: ");
		int endcharindex = getIntInput("Enter the ending char index to substitute the string: ");
		createdSB = task.replaceChars(createdSB , replacementstring , startcharindex , endcharindex);
		printOutput(task.getLength(createdSB));
		printOutput(task.getFinalString(createdSB));
	}
	
	public static void firstSeperatorIndex (StringBuilderTask task) {
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		//int seperatornum = getIntInput("Enter the seperator number to find its index: "); 
		printOutput(task.minimumIndex(createdSB , seperator));
	}
	
	public static void lastSeperatorIndex (StringBuilderTask task) {
		String[] stringbuilderinput = getStringInput();
		String seperator = getSeperator();
		StringBuilder createdSB = task.createStringBuilder(stringbuilderinput , seperator);
		printOutput(task.minimumIndex(createdSB , seperator));
	}
}