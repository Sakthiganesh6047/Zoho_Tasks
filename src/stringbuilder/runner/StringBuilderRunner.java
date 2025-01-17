package stringbuilder.runner;

import stringbuilder.task.StringBuilderTask;
import util.CustomException;
import util.UtilGetInput;
import java.util.logging.Logger;

public class StringBuilderRunner {
	
    StringBuilderTask task = new StringBuilderTask(); 
    private static final Logger logger = Logger.getLogger(StringBuilderRunner.class.getName());

    public static void main(String[] args) throws CustomException {
        StringBuilderRunner runner = new StringBuilderRunner();
        runner.runOperations();
    }

    private void runOperations() throws CustomException {
        int enteredChoice = 0;
        
        try {

	        do {
	        	
	            logger.info("Select an operation to perform:");
	            logger.info("1. Create a StringBuilder and add strings to it");
	            logger.info("2. Create a StringBuilder and add strings to it with a separator");
	            logger.info("3. Create a StringBuilder and insert another string");
	            logger.info("4. Create a StringBuilder and delete strings");
	            logger.info("5. Create a StringBuilder and replace the separator");
	            logger.info("6. Create a StringBuilder and reverse it");
	            logger.info("7. Create a StringBuilder and delete characters");
	            logger.info("8. Create a StringBuilder and replace characters");
	            logger.info("9. Create a StringBuilder and find the first separator index");
	            logger.info("10. Create a StringBuilder and find the last separator index");
	            logger.info("0. Exit");
	
	            enteredChoice = UtilGetInput.getIntInput("Enter a choice from 0 to 10: ");
	
	            if (enteredChoice < 0 || enteredChoice > 10) {
	                logger.info("Invalid Choice, Enter a choice from 0 to 10");
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
	                	logger.info("Terminated successfully");
	                    break;
	            }
	        } while (enteredChoice != 0);
        } catch(Exception e) {
        	logger.severe("An Error occured: " + e.getMessage());
        }
    }

    public void createAndAddStringsToIt() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        String[] addStringsInput = getStringInput();
        task.addToStringBuilder(addStringsInput, createdSB, separator);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
    }

    public void addStringsWithSeparator() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        String[] addStringsInput = getStringInput();
        task.addToStringBuilder(addStringsInput, createdSB, separator);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
    }

    public void insertAnotherString() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
        String[] insertStrings = getStringInput();
        int insertAfterNo = UtilGetInput.getIntInput("Enter the index of the existing string to insert these strings: ");
        task.insertToStringBuilder(insertStrings, stringBuilderInput, createdSB, separator, insertAfterNo);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
    }

    public void deleteStrings() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
        int delStringIndex = getDeleteStringIndex(createdSB, separator);
        try { 
        	createdSB = task.deleteStringsInSB(createdSB, delStringIndex, separator);
        } catch (CustomException e) {
    		e.printStackTrace();
        }
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
    }

    public void replaceSeparator() throws CustomException {
        String[] stringBuilderInput = getStringInput();
        String separator = UtilGetInput.getStringInput("Enter the separator: ");
        StringBuilder createdSB = task.createStringBuilder(stringBuilderInput, separator);
        String newSeparator = UtilGetInput.getStringInput("Enter the replacement separator: ");
        createdSB = task.replaceSeperator(createdSB, separator, newSeparator);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
    }

    public void reverseStringBuilder() throws CustomException {
        StringBuilder createdSB = completeStringBuilder();
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
        createdSB = task.reversingString(createdSB);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
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
        
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
    }

    public void replaceCharacters() throws CustomException {
        StringBuilder createdSB = completeStringBuilder();
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        String replacementString = UtilGetInput.getStringInput("Enter the replacement string: ");
        int startCharIndex = UtilGetInput.getIntInput("Enter the starting char index to substitute the string: ");
        int endCharIndex = UtilGetInput.getIntInput("Enter the ending char index to substitute the string: ");
        createdSB = task.replaceChars(createdSB, replacementString, startCharIndex, endCharIndex);
        logger.info("The Length of the StringBuilder is: " + task.getLength(createdSB));
        logger.info(task.getFinalString(createdSB));
    }

    public void firstSeparatorIndex() throws CustomException {
        StringBuilder createdSB = completeStringBuilder();
    }
    
    private static String[] getStringInput() throws CustomException {
        int numStrings = UtilGetInput.getIntInput("Enter the number of strings you want to input: ");
        String[] strings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            UtilGetInput.getStringInput("Enter string " + (i + 1) + ": ");
        }
        return strings;
    }

    private int getDeleteStringIndex(StringBuilder createdSB, String separator) throws CustomException {
    	logger.info("The Available Strings are: ");
        String[] splittedArray = task.splitStringBuilder(createdSB, separator);
        for (int i = 0; i < splittedArray.length; i++) {
        	logger.info((i + 1) + ". " + splittedArray[i]);
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
       
