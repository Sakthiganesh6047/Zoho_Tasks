package stringbuilder.runner;

import stringbuilder.task.StringBuilderTask;
import exception.CustomException;
import java.util.*;

public class StringBuilderRunner {
    static Scanner scanner = new Scanner(System.in);
    StringBuilderTask task = new StringBuilderTask();  // Instance of StringBuilderTask

    public static void main(String[] args) {
        StringBuilderRunner runner = new StringBuilderRunner();
        runner.runOperations();
    }

    private void runOperations() {
        int enteredChoice = 0;

        do {
        	
            System.out.println("Select an operation to perform:");
            System.out.println("1. Create a StringBuilder and add strings to it");
            System.out.println("2. Create a StringBuilder and add strings to it with a separator");
            System.out.println("3. Create a StringBuilder and insert another string");
            System.out.println("4. Create a StringBuilder and delete strings");
            System.out.println("5. Create a StringBuilder and replace the separator");
            System.out.println("6. Create a StringBuilder and reverse it");
            System.out.println("7. Create a StringBuilder and delete characters");
            System.out.println("8. Create a StringBuilder and replace characters");
            System.out.println("9. Create a StringBuilder and find the first separator index");
            System.out.println("10. Create a StringBuilder and find the last separator index");
            System.out.println("0. Exit");

            enteredChoice = getIntInput("Enter a choice from 0 to 10: ");

            if (enteredChoice < 0 || enteredChoice > 10) {
                printOutput("Invalid Choice, Enter a choice from 0 to 10");
            }

            switch (enteredChoice) {
                case 1:
                    createAndAddStringsToIt();
                    break;
                case 2:
                    addStringsWithSeparator();
                    break;
                case 3:
                    insertAnotherString();
                    break;
                case 4:
                    deleteStrings();
                    break;
                case 5:
                    replaceSeparator();
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
                    firstSeparatorIndex();
                    break;
                case 10:
                	firstSeparatorIndex();
                    break;
                case 0:
                    printOutput("Terminated successfully");
                    break;
            }
        } while (enteredChoice != 0);
    }

    public static String[] getStringInput() {
        System.out.print("Enter the number of strings you want to input: ");
        int numStrings = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        String[] strings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }
        return strings;
    }

    public static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                printOutput("Invalid input, please enter a valid integer.");
            }
        }
    }

    public static String getSeparator() {
        System.out.print("Enter the character to separate strings: ");
        return scanner.nextLine();
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getDeleteStringIndex(StringBuilder createdSB, String separator) {
        printOutput("The Available Strings are: ");
        String[] splittedArray = task.splitStringBuilder(createdSB, separator);
        for (int i = 0; i < splittedArray.length; i++) {
            printOutput((i + 1) + ". " + splittedArray[i]);
        }
        return getIntInput("Enter the index of the string you want to delete: ");
    }

    public static void printOutput(String value) {
        System.out.println(value);
    }

    public static void printOutput(int value) {
        System.out.println(value);
    }

    // Remove `StringBuilderTask task` from parameters and use the instance directly
    public void createAndAddStringsToIt() {
        String[] stringBuilderInput = getStringInput();
        String separator = getSeparator();
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        printOutput(task.getLength(createdSB));
        String[] addStringsInput = getStringInput();
        task.addToStringBuilder(addStringsInput, createdSB, separator);

        printOutput(task.getLength(createdSB));
        printOutput(task.getFinalString(createdSB));
    }

    public void addStringsWithSeparator() {
        String[] stringBuilderInput = getStringInput();
        String separator = getSeparator();
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        printOutput(task.getLength(createdSB));
        String[] addStringsInput = getStringInput();
        task.addToStringBuilder(addStringsInput, createdSB, separator);
        printOutput(task.getLength(createdSB));
        printOutput(task.getFinalString(createdSB));
    }

    public void insertAnotherString() {
        String[] stringBuilderInput = getStringInput();
        String separator = getSeparator();
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        printOutput(task.getLength(createdSB));
        printOutput(task.getFinalString(createdSB));
        String[] insertStrings = getStringInput();
        int insertAfterNo = getIntInput("Enter the index of the existing string to insert these strings: ");
        task.insertToStringBuilder(insertStrings, stringBuilderInput, createdSB, separator, insertAfterNo);
        printOutput(task.getLength(createdSB));
        printOutput(task.getFinalString(createdSB));
    }

    public void deleteStrings() {
	        String[] stringBuilderInput = getStringInput();
	        String separator = getSeparator();
	        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
	        printOutput(task.getLength(createdSB));
	        printOutput(task.getFinalString(createdSB));
	        int delStringIndex = getDeleteStringIndex(createdSB, separator);
	        try { 
	        createdSB = task.deleteStringsInSB(createdSB, delStringIndex, separator);
	        }
	        catch (CustomException e) {
	    		e.printStackTrace();
	        }
	        printOutput(task.getLength(createdSB));
	        printOutput(task.getFinalString(createdSB));
    }

    public void replaceSeparator() {
        String[] stringBuilderInput = getStringInput();
        String separator = getSeparator();
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        String newSeparator = getString("Enter the replacement separator: ");
        createdSB = task.replaceSeperator(createdSB, separator, newSeparator);
        printOutput(task.getLength(createdSB));
        printOutput(task.getFinalString(createdSB));
    }

    public void reverseStringBuilder() {
        String[] stringBuilderInput = getStringInput();
        String separator = getSeparator();
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        printOutput(task.getLength(createdSB));
        printOutput(task.getFinalString(createdSB));
        createdSB = task.reversingString(createdSB);
        printOutput(task.getLength(createdSB));
        printOutput(task.getFinalString(createdSB));
    }

    public void deleteCharacters() {
        String[] stringBuilderInput = getStringInput();
        String separator = getSeparator();
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        int startCharIndex = getIntInput("Enter the starting char index to delete: ");
        int endCharIndex = getIntInput("Enter the ending char index to delete: ");
        try {
        createdSB = task.deleteCharsInSB(createdSB, startCharIndex, endCharIndex);
        } catch (CustomException e) {
        	e.printStackTrace();
        }
        
        printOutput(task.getLength(createdSB));
        printOutput(task.getFinalString(createdSB));
    }

    public void replaceCharacters() {
        String[] stringBuilderInput = getStringInput();
        String separator = getSeparator();
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        printOutput(task.getLength(createdSB));
        String replacementString = getString("Enter the replacement string: ");
        int startCharIndex = getIntInput("Enter the starting char index to substitute the string: ");
        int endCharIndex = getIntInput("Enter the ending char index to substitute the string: ");
        createdSB = task.replaceChars(createdSB, replacementString, startCharIndex, endCharIndex);
        printOutput(task.getLength(createdSB));
        printOutput(task.getFinalString(createdSB));
    }

    public void firstSeparatorIndex() {
        String[] stringBuilderInput = getStringInput();
        String separator = getSeparator();
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
    }
}
       
