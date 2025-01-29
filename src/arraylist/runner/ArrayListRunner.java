package arraylist.runner;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import arraylist.customobj.CustomObj;
import arraylist.task.ArrayListTask;
import util.CustomException;
import util.LoggerUtility;
import util.UtilGetInput;
import util.UtilPrintInFile;

public class ArrayListRunner  {
	
	private String className;
	private ArrayListTask task;
	
	private static final Logger logger = LoggerUtility.getLogger(ArrayListRunner.class , "/home/sakthi-pt7767/eclipse-workspace/Zoho_Tasks/LogFiles/ALlogs"); 
	
	public ArrayListRunner() throws CustomException {
		try {
			this.className = System.getProperty("list.class.name");
			this.task = new ArrayListTask();
		} catch (Exception e) {
			throw new CustomException("Error in creating ArrayListTask Instance" , e);
		}
	}

	public static void main(String[] args) throws CustomException {
		
		ArrayListRunner runner = new ArrayListRunner();
		runner.runOperations();
	}
	
	private void runOperations() {
		int enteredChoice = 0;
			
		do {
			
			try {
			
				logger.info("1. Create a Arraylist");
				logger.info("2. Create a Arraylist with Strings");
				logger.info("3. Create a Arraylist with Integers");
				logger.info("4. Create a Arraylist with Coustom Objects");
				logger.info("5. Create a Arraylist with various types");
				logger.info("6. Find the Index of a string in the ArrayList");
				logger.info("7. Printing using Iterator method and Forloop");
				logger.info("8. Print the String at a given index in the ArrayList");
				logger.info("9. Find the first & last position of a duplicate string");
				logger.info("10. Insert String at a given index");
				logger.info("11. Create a SubArraylist with existing list");
				logger.info("12. Create a combined Arraylist");
				logger.info("13. Create a combined Arraylist in inverse order");
				logger.info("14. Create a Arraylist with Decimal entries");
				logger.info("15. Remove all from the Arraylist");
				logger.info("16. Retain all from the Arraylist");
				logger.info("17. Remove the all from Arraylist with long entries");
				logger.info("18. Check the presence of string in a ArrayList");
				logger.info("0. Terminate Program");
				enteredChoice = UtilGetInput.getIntInput("Enter the choice of operation: ");
				
				 if (enteredChoice < 0 || enteredChoice > 18) {
					 logger.info("Invalid Choice, Enter a choice from 0 to 18");
				 }
				
				switch(enteredChoice) {
				case 1:
					createArrayList();
					break;
					
				case 2:
					arrayListWithStrings();
					break;
					
				case 3:
					arrayListWithIntegers();
					break;
					
				case 4:
					arrayListWithCoustomObjects();
					break;
					
				case 5:
					arrayListOfDiffTypes();
					break;
					
				case 6:
					findIndex();
					break;
					
				case 7:
					printElementsInArrayList();
					break;
					
				case 8:
					getStringByIndex();
					break;
					
				case 9:
					findDuplicatesOfStrings();
					break;
					
				case 10:
					addStringByIndex();
					break;
						
				case 11:
					createSublist();
					break;
					
				
				case 12:
					createCombinedSublist();
					break;
					
				case 13:
					createCombinedSublistInverseOrder();
					break;
					
				case 14:
					arrayListOfDecimal();
					break;
					
				case 15:
					removeAllFromLists();
					break;
					
				case 16:
					retainAllFromLists();
					break;
					
				case 17:
					removeLongValues();
					break;
					
				case 18:	
					checkPresenceOfString();
					break;
					
				case 0:
					logger.info("Terminated Successfully!");
					break;
					
				}
			} catch (Exception e) {
				logger.severe("An Error occured: " + e.getMessage());
			}
		}
		while (enteredChoice != 0);
	}
	
	private <T> void createArrayList() throws CustomException {
		List<?> arrayList1 = task.createList(className);
		printSizeAndList(arrayList1);
		logger.warning("this is warning level log");
		logger.config("this is config level log");
	}
	
	private void arrayListWithStrings() throws CustomException {
		List<String> arrayList1 = createArrayListWithStrings();
		printSizeAndList(arrayList1);
		UtilPrintInFile.printOutput("The list is " + arrayList1);
	}
	
	@SuppressWarnings("unchecked")
	private <T> void arrayListWithIntegers() throws CustomException {
		//List<T> arraylist1 = task.createList();
		List<T> arraylist1 = null;
		int intCount = util.UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] intArray = (T[]) getArray(intCount , Integer.class);
		task.addElementsToList(arraylist1, intArray);
		printSizeAndList(arraylist1);
	}
	
	@SuppressWarnings("unchecked")
	private <T> void arrayListWithCoustomObjects() throws CustomException { 
		List<T> arrayList1 = task.createList(className);
		int customobjCount = UtilGetInput.getIntInput("Enter the Number of objects to add: ");
		for (int i = 0 ; i < customobjCount ; i++) {
			String objName = UtilGetInput.getStringInput("Enter the " + (i+1) + " object name: ");
			int objValue = UtilGetInput.getIntInput("Enter the object " + (i+1) + " value: ");
			CustomObj object1 = new CustomObj(objName , objValue);
			task.addCustomObject(arrayList1 , (T) object1);
		}
		printSizeAndList(arrayList1);
	}
	
	@SuppressWarnings("unchecked")
	private <T> void arrayListOfDiffTypes() throws CustomException {
		List<T> arrayList1 = task.createList(className);
		int intCount = UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] intArray = (T[]) getArray(intCount , Integer.class);
		int stringCount = UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] stringArray = (T[]) getArray(stringCount , String.class);
		task.addElementsToList(arrayList1 , stringArray);
		task.addElementsToList(arrayList1 , intArray);
		int customobjcount = UtilGetInput.getIntInput("Enter the Number of objects to add: ");
		for (int i = 0 ; i < customobjcount ; i++) {
			String objName = UtilGetInput.getStringInput("Enter the " + (i+1) + " object name: ");
			int objValue = UtilGetInput.getIntInput("Enter the object " + (i+1) + " value: ");
			CustomObj object1 = new CustomObj(objName , objValue);
			task.addCustomObject(arrayList1 , (T) object1);
		}
		printSizeAndList(arrayList1);
	}
	
	private <T> void findIndex() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		String stringToFind = UtilGetInput.getStringInput("Enter the string to find its index: ");
		int stringIndex = task.lastOccurenceOfString(arrayList1, stringToFind);
		 if (stringIndex != -1) {
	            logger.info("The index of " + stringToFind +" is: " + stringIndex);
	        } else {
	            logger.info(stringToFind + " is not in the ArrayList.");
	        }
		printSizeAndList(arrayList1);
	}
	
	private <T> void printElementsInArrayList() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		printByIterator(arrayList1);
		printByForloop(arrayList1);
	}
	
	private <T> void getStringByIndex() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		int stringIndex = UtilGetInput.getIntInput("Enter the index of the string to retrieve: ");
		logger.info("String at index " + stringIndex + ": " + task.getByIndex(arrayList1 , stringIndex));
		printSizeAndList(arrayList1);
	}
	
	private <T> void findDuplicatesOfStrings() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		String stringToFind = UtilGetInput.getStringInput("Enter the string to find its index: ");
		int firstIndex = task.firstOccurenceOfString(arrayList1, stringToFind);
		int lastIndex = task.lastOccurenceOfString(arrayList1, stringToFind);
		if (firstIndex != -1) {
			logger.info("First occurrence of " + stringToFind + " is at index: " + firstIndex);
			logger.info("Last occurrence of " + stringToFind + " is at index: " + lastIndex);
        } else {
        	logger.info( stringToFind + " is not in the ArrayList.");
        }
		printSizeAndList(arrayList1);
	}
	
	@SuppressWarnings("unchecked")
	private <T> void addStringByIndex() throws CustomException {
		List<T> arrayList1 = task.createList(className);
		int stringCount1 = UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] stringArray1 = (T[]) getArray(stringCount1 , String.class);
		task.addElementsToList(arrayList1 , stringArray1);
		int addIndex = UtilGetInput.getIntInput("Enter the index to add the strings: ");
		String stringInput = UtilGetInput.getStringInput("Enter the string to add in the " + addIndex + " index of arraylist: ");
		task.addStringInIndex(arrayList1, stringInput, addIndex);
		printSizeAndList(arrayList1);
	}
	
	private <T> void createSublist() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		int startIndex = UtilGetInput.getIntInput("Enter the start index to create a subarraylist: ");
		int endIndex = UtilGetInput.getIntInput("Enter the end index to create a subarraylist: ");
		List<?> arrayList2 = task.createSubArrayList(arrayList1, startIndex, endIndex);
		printSizeAndList(arrayList1);
		printSizeAndList(arrayList2);
	}
	
	@SuppressWarnings("unchecked")
	private <T> void createCombinedSublist() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		List<T> arrayList2 = createArrayListWithStrings();
	
		CustomObj object1 = new CustomObj("asg" , 21);
		task.addCustomObject(arrayList1 ,(T) object1);
		
		CustomObj object2 = new CustomObj("js" , 19);
		task.addCustomObject(arrayList2 , (T) object2);
		
		printSizeAndList(arrayList1);
		printSizeAndList(arrayList2);
		
		List<T> arrayList3 = task.combinedList(arrayList2, arrayList2 , className);
		
		printSizeAndList(arrayList3);
		
		object2.setValue(44);
		
		printSizeAndList(arrayList3);
		printSizeAndList(arrayList1);
		printSizeAndList(arrayList2);
		task.deleteList(arrayList1);
		printSizeAndList(arrayList3);
		printSizeAndList(arrayList1);
		
	}
	
	private <T> void createCombinedSublistInverseOrder() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		List<T> arrayList2 = createArrayListWithStrings();
		List<?> arrayList3 = task.combinedList(arrayList2 , arrayList1 , className);
		printSizeAndList(arrayList3);
	}
	
	@SuppressWarnings("unchecked")
	private <T> void arrayListOfDecimal() throws CustomException {
		List<T> arrayList1 = task.createList(className);
		int decimalCount = UtilGetInput.getIntInput("Enter the No. of decimal values need to be added: ");
		T[] doubleArray1 = (T[]) getArray(decimalCount , Double.class);
		task.addElementsToList(arrayList1, doubleArray1);
		int doubleIndex = UtilGetInput.getIntInput("Enter the index of decimal value needs to be removed: ");
		task.deleteElementByIndex(arrayList1 , doubleIndex);
		printSizeAndList(arrayList1);
	}
	
	private <T> void removeAllFromLists() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		int endIndex = UtilGetInput.getIntInput("Enter the end index to create the second arraylist: ");
		List<?> arrayList2 = task.createSubArrayList(arrayList1, 0 , endIndex);
		task.deleteSubList(arrayList1, arrayList2);
		printSizeAndList(arrayList1);
		printSizeAndList(arrayList2);
	}
	
	private <T> void retainAllFromLists() throws CustomException {
		try {
			List<T> arrayList1 = createArrayListWithStrings();
			int endIndex = UtilGetInput.getIntInput("Enter the end index to create the second arraylist: ");
			List<?> arrayList2 = task.createSubArrayList(arrayList1, 0 , endIndex);
			task.retainSubList(arrayList1, arrayList2);
			printSizeAndList(arrayList1);
			printSizeAndList(arrayList2);
		} catch (CustomException e) {
			e.appendMessage("Something went Wrong!");
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	private <T> void removeLongValues() throws CustomException {
		List<T> arrayList1 = task.createList(className);
		int longCount = UtilGetInput.getIntInput("Enter the Number of long values to add: ");
		T[] longArray = (T[]) getArray(longCount , Long.class);
		task.addElementsToList(arrayList1, longArray);
		printSizeAndList(arrayList1);
		task.deleteList(arrayList1);
		logger.info("The arraylist is: " + arrayList1);
		//printSizeAndList(arraylist1);
	}
	
	private void checkPresenceOfString() throws CustomException {
		List<?> arrayList1 = createArrayListWithStrings();
		String inputString = util.UtilGetInput.getStringInput("Enter the String to check availability in the list: ");
		Boolean availability = task.checkPresence(arrayList1 , inputString);
		if (availability == true) {
			logger.info("Yes, " + inputString + " is available in the created list");
		} else {
			logger.info("No, " + inputString + " is not available in the created list");
		}
	}
	
	private void printSizeAndList(List<?> list) throws CustomException {
		logger.info("The ArrayList is: " + list);
		logger.info("The size of the list is: " + task.getSize(list));
	}
	
	@SuppressWarnings("unchecked")
	private <T> void printByIterator(List<T> arraylist1) {
		logger.info("Using Iterator to print elements:");
		Iterator<String> iterator = (Iterator<String>) arraylist1.iterator();
		while (iterator.hasNext()) {
			logger.info(iterator.next());
		}
	}
	
	private <T> void printByForloop(List<T> arrayList1) {
		logger.info("Using for loop to print elements:");
	    for (T element : arrayList1) {
	    	logger.info((String) element);
	    }
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> createArrayListWithStrings() throws CustomException {
		List<T> arrayList1 = task.createList(className);
		int stringCount1 = util.UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] stringArray1 = (T[]) getArray(stringCount1 , String.class);
		task.addElementsToList(arrayList1 , stringArray1);
		return arrayList1;
	}
	
	 @SuppressWarnings("unchecked")
	private <T> T[] getArray(int count, Class<T> type) throws CustomException {
		 T[] array = (T[]) Array.newInstance(type, count);
		 for (int i = 0; i < count; i++) {
            if (type == Long.class) {
                array[i] = type.cast(UtilGetInput.getLongInput("Enter the long value " + (i + 1) + " to add: "));
            } else if (type == Integer.class) {
                array[i] = type.cast(UtilGetInput.getIntInput("Enter the integer value " + (i + 1) + " to add: "));
            } else if (type == Double.class) {
                array[i] = type.cast(UtilGetInput.getDoubleInput("Enter the decimal value " + (i + 1) + " to add: "));
            } else if (type == String.class) {
                array[i] = type.cast(UtilGetInput.getStringInput("Enter the string value " + (i + 1) + " to add: "));
            }
        }
		 return array;
	 }
}

