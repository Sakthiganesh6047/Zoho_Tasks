package stringbuilder.runner;

import stringbuilder.task.StringBuilderTask;
import util.UtilGetInput;
import util.UtilPrintOutput;
import exception.CustomException;
import java.util.*;

public class StringBuilderRunner {
    static Scanner scanner = new Scanner(System.in);
    StringBuilderTask task = new StringBuilderTask(); 

    public static void main(String[] args) throws CustomException {
        StringBuilderRunner runner = new StringBuilderRunner();
        runner.runOperations();
    }

    private void runOperations() throws CustomException {
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

            enteredChoice = UtilGetInput.getIntInput("Enter a choice from 0 to 10: ");

            if (enteredChoice < 0 || enteredChoice > 10) {
                UtilPrintOutput.printOutput("Invalid Choice, Enter a choice from 0 to 10");
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
                	UtilPrintOutput.printOutput("Terminated successfully");
                    break;
            }
        } while (enteredChoice != 0);
    }

    public void createAndAddStringsToIt() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        String[] addStringsInput = getStringInput();
        task.addToStringBuilder(addStringsInput, createdSB, separator);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
    }

    public void addStringsWithSeparator() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        String[] addStringsInput = getStringInput();
        task.addToStringBuilder(addStringsInput, createdSB, separator);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
    }

    public void insertAnotherString() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
        String[] insertStrings = getStringInput();
        int insertAfterNo = UtilGetInput.getIntInput("Enter the index of the existing string to insert these strings: ");
        task.insertToStringBuilder(insertStrings, stringBuilderInput, createdSB, separator, insertAfterNo);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
    }

    public void deleteStrings() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
        int delStringIndex = getDeleteStringIndex(createdSB, separator);
        try { 
        	createdSB = task.deleteStringsInSB(createdSB, delStringIndex, separator);
        } catch (CustomException e) {
    		e.printStackTrace();
        }
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
    }

    public void replaceSeparator() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        String newSeparator = UtilGetInput.getStringInput("Enter the replacement separator: ");
        createdSB = task.replaceSeperator(createdSB, separator, newSeparator);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
    }

    public void reverseStringBuilder() throws CustomException {
        StringBuilder createdSB = completeStringBuilder();
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
        createdSB = task.reversingString(createdSB);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
    }

    public void deleteCharacters() throws CustomException {
        StringBuilder createdSB = completeStringBuilder();
        int startCharIndex = UtilGetInput.getIntInput("Enter the starting char index to delete: ");
        int endCharIndex = UtilGetInput.getIntInput("Enter the ending char index to delete: ");
        try {
        	createdSB = task.deleteCharsInSB(createdSB, startCharIndex, endCharIndex);
        } catch (CustomException e) {
        	e.printStackTrace();
        }
        
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
    }

    public void replaceCharacters() throws CustomException {
        StringBuilder createdSB = completeStringBuilder();
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        String replacementString = UtilGetInput.getStringInput("Enter the replacement string: ");
        int startCharIndex = UtilGetInput.getIntInput("Enter the starting char index to substitute the string: ");
        int endCharIndex = UtilGetInput.getIntInput("Enter the ending char index to substitute the string: ");
        createdSB = task.replaceChars(createdSB, replacementString, startCharIndex, endCharIndex);
        UtilPrintOutput.printOutput(task.getLength(createdSB));
        UtilPrintOutput.printOutput(task.getFinalString(createdSB));
    }

    public void firstSeparatorIndex() throws CustomException {
        StringBuilder createdSB = completeStringBuilder();
    }
    
    private static String[] getStringInput() {
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

    private int getDeleteStringIndex(StringBuilder createdSB, String separator) throws CustomException {
    	UtilPrintOutput.printOutput("The Available Strings are: ");
        String[] splittedArray = task.splitStringBuilder(createdSB, separator);
        for (int i = 0; i < splittedArray.length; i++) {
        	UtilPrintOutput.printOutput((i + 1) + ". " + splittedArray[i]);
        }
        return UtilGetInput.getIntInput("Enter the index of the string you want to delete: ");
    }
    
    private StringBuilder completeStringBuilder() throws CustomException {
    	String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        return createdSB;
    }
}
       
