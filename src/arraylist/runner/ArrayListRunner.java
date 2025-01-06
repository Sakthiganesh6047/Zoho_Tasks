package arraylist.runner;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import arraylist.customobj.CustomObj;
import arraylist.task.ArrayListTask;
import util.UtilGetInput;
import util.UtilPrintOutput;
import util.UtilPrintInFile;
import exception.CustomException;

public class ArrayListRunner  {
	
	ArrayListTask task = new ArrayListTask();
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws CustomException {
		ArrayListRunner runner = new ArrayListRunner();
		runner.runOperations();
	}
	
	private void runOperations() {
		int enteredChoice = 0;
			
		do {
			
			try {
			
				UtilPrintOutput.printOutput("1. Create a Arraylist");
				UtilPrintOutput.printOutput("2. Create a Arraylist with Strings");
				UtilPrintOutput.printOutput("3. Create a Arraylist with Integers");
				UtilPrintOutput.printOutput("4. Create a Arraylist with Coustom Objects");
				UtilPrintOutput.printOutput("5. Create a Arraylist with various types");
				UtilPrintOutput.printOutput("6. Find the Index of a string in the ArrayList");
				UtilPrintOutput.printOutput("7. Printing using Iterator method and Forloop");
				UtilPrintOutput.printOutput("8. Print the String at a given index in the ArrayList");
				UtilPrintOutput.printOutput("9. Find the first & last position of a duplicate string");
				UtilPrintOutput.printOutput("10. Insert String at a given index");
				UtilPrintOutput.printOutput("11. Create a SubArraylist with existing list");
				UtilPrintOutput.printOutput("12. Create a combined Arraylist");
				UtilPrintOutput.printOutput("13. Create a combined Arraylist in inverse order");
				UtilPrintOutput.printOutput("14. Create a Arraylist with Decimal entries");
				UtilPrintOutput.printOutput("15. Remove all from the Arraylist");
				UtilPrintOutput.printOutput("16. Retain all from the Arraylist");
				UtilPrintOutput.printOutput("17. Remove the all from Arraylist with long entries");
				UtilPrintOutput.printOutput("18. Check the presence of string in a ArrayList");
				UtilPrintOutput.printOutput("0. Terminate Program");
				enteredChoice = UtilGetInput.getIntInput("Enter the choice of operation: ");
				
				 if (enteredChoice < 0 || enteredChoice > 18) {
					 UtilPrintOutput.printOutput("Invalid Choice, Enter a choice from 0 to 18");
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
					UtilPrintOutput.printOutput("Terminated Successfully!");
					
					break;
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				/*UtilPrintOutput.printOutput("Exception: " + e.getMessage());
				UtilPrintOutput.printOutput("Cause: " + e.getCause());*/
			}
		}
		while (enteredChoice != 0);
	}
	
	public <T> void createArrayList() throws CustomException {
		List<?> arrayList1 = task.createList();
		printSizeAndList(arrayList1);
	}
	
	public void arrayListWithStrings() throws CustomException {
		List<String> arrayList1 = createArrayListWithStrings();
		printSizeAndList(arrayList1);
		UtilPrintInFile.printOutput("The list is " + arrayList1);
	}
	
	@SuppressWarnings("unchecked")
	public <T> void arrayListWithIntegers() throws CustomException {
		//List<T> arraylist1 = task.createList();
		List<T> arraylist1 = null;
		int intCount = util.UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] intArray = (T[]) getArray(intCount , Integer.class);
		task.addElementsToList(arraylist1, intArray);
		printSizeAndList(arraylist1);
	}
	
	@SuppressWarnings("unchecked")
	public <T> void arrayListWithCoustomObjects() throws CustomException { 
		List<T> arrayList1 = task.createList();
		int customobjCount = util.UtilGetInput.getIntInput("Enter the Number of objects to add: ");
		for (int i = 0 ; i < customobjCount ; i++) {
			String objName = util.UtilGetInput.getStringInput("Enter the " + (i+1) + " object name: ");
			int objValue = util.UtilGetInput.getIntInput("Enter the object " + (i+1) + " value: ");
			CustomObj object1 = new CustomObj(objName , objValue);
			task.addCustomObject(arrayList1 , (T) object1);
		}
		printSizeAndList(arrayList1);
	}
	
	@SuppressWarnings("unchecked")
	public <T> void arrayListOfDiffTypes() throws CustomException {
		List<T> arrayList1 = task.createList();
		int intCount = util.UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] intArray = (T[]) getArray(intCount , Integer.class);
		int stringCount = util.UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] stringArray = (T[]) getArray(stringCount , String.class);
		task.addElementsToList(arrayList1 , stringArray);
		task.addElementsToList(arrayList1 , intArray);
		int customobjcount = util.UtilGetInput.getIntInput("Enter the Number of objects to add: ");
		for (int i = 0 ; i < customobjcount ; i++) {
			String objName = util.UtilGetInput.getStringInput("Enter the " + (i+1) + " object name: ");
			int objValue = util.UtilGetInput.getIntInput("Enter the object " + (i+1) + " value: ");
			CustomObj object1 = new CustomObj(objName , objValue);
			task.addCustomObject(arrayList1 , (T) object1);
		}
		printSizeAndList(arrayList1);
	}
	
	public <T> void findIndex() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		String stringToFind = util.UtilGetInput.getStringInput("Enter the string to find its index: ");
		int stringIndex = task.lastOccurenceOfString(arrayList1, stringToFind);
		 if (stringIndex != -1) {
	            System.out.println("The index of " + stringToFind +" is: " + stringIndex);
	        } else {
	            System.out.println(stringToFind + " is not in the ArrayList.");
	        }
		printSizeAndList(arrayList1);
	}
	
	public <T> void printElementsInArrayList() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		printByIterator(arrayList1);
		printByForloop(arrayList1);
	}
	
	public <T> void getStringByIndex() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		int stringIndex = util.UtilGetInput.getIntInput("Enter the index of the string to retrieve: ");
		UtilPrintOutput.printOutput("String at index " + stringIndex + ": " + task.getByIndex(arrayList1 , stringIndex));
		printSizeAndList(arrayList1);
	}
	
	public <T> void findDuplicatesOfStrings() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		String stringToFind = util.UtilGetInput.getStringInput("Enter the string to find its index: ");
		int firstIndex = task.firstOccurenceOfString(arrayList1, stringToFind);
		int lastIndex = task.lastOccurenceOfString(arrayList1, stringToFind);
		if (firstIndex != -1) {
			UtilPrintOutput.printOutput("First occurrence of " + stringToFind + " is at index: " + firstIndex);
			UtilPrintOutput.printOutput("Last occurrence of " + stringToFind + " is at index: " + lastIndex);
        } else {
        	UtilPrintOutput.printOutput( stringToFind + " is not in the ArrayList.");
        }
		printSizeAndList(arrayList1);
	}
	
	@SuppressWarnings("unchecked")
	public <T> void addStringByIndex() throws CustomException {
		List<T> arrayList1 = task.createList();
		int stringCount1 = util.UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] stringArray1 = (T[]) getArray(stringCount1 , String.class);
		task.addElementsToList(arrayList1 , stringArray1);
		int addIndex = util.UtilGetInput.getIntInput("Enter the index to add the strings: ");
		String stringInput = util.UtilGetInput.getStringInput("Enter the string to add in the " + addIndex + " index of arraylist: ");
		task.addStringInIndex(arrayList1, stringInput, addIndex);
		printSizeAndList(arrayList1);
	}
	
	public <T> void createSublist() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		int startIndex = util.UtilGetInput.getIntInput("Enter the start index to create a subarraylist: ");
		int endIndex = util.UtilGetInput.getIntInput("Enter the end index to create a subarraylist: ");
		List<?> arrayList2 = task.createSubArrayList(arrayList1, startIndex, endIndex);
		printSizeAndList(arrayList1);
		printSizeAndList(arrayList2);
	}
	
	@SuppressWarnings("unchecked")
	public <T> void createCombinedSublist() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		List<T> arrayList2 = createArrayListWithStrings();
	
		CustomObj object1 = new CustomObj("asg" , 21);
		task.addCustomObject(arrayList1 ,(T) object1);
		
		CustomObj object2 = new CustomObj("js" , 19);
		task.addCustomObject(arrayList2 , (T) object2);
		
		printSizeAndList(arrayList1);
		printSizeAndList(arrayList2);
		
		List<?> arrayList3 = task.combinedList(arrayList1 , arrayList2);
		
		printSizeAndList(arrayList3);
		
		object2.setValue(44);
		
		printSizeAndList(arrayList3);
		printSizeAndList(arrayList1);
		printSizeAndList(arrayList2);
		task.deleteList(arrayList1);
		printSizeAndList(arrayList3);
		printSizeAndList(arrayList1);
		
	}
	
	public <T> void createCombinedSublistInverseOrder() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		List<T> arrayList2 = null; //createArrayListWithStrings();
		List<?> arrayList3 = task.combinedList(arrayList2 , arrayList1);
		printSizeAndList(arrayList3);
	}
	
	@SuppressWarnings("unchecked")
	public <T> void arrayListOfDecimal() throws CustomException {
		List<T> arrayList1 = task.createList();
		int decimalCount = util.UtilGetInput.getIntInput("Enter the No. of decimal values need to be added: ");
		T[] doubleArray1 = (T[]) getArray(decimalCount , Double.class);
		task.addElementsToList(arrayList1, doubleArray1);
		int doubleIndex = util.UtilGetInput.getIntInput("Enter the index of decimal value needs to be removed: ");
		task.deleteElementByIndex(arrayList1 , doubleIndex);
		printSizeAndList(arrayList1);
	}
	
	public <T> void removeAllFromLists() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		int endIndex = util.UtilGetInput.getIntInput("Enter the end index to create the second arraylist: ");
		List<?> arrayList2 = task.createSubArrayList(arrayList1, 0 , endIndex);
		task.deleteSubList(arrayList1, arrayList2);
		printSizeAndList(arrayList1);
		printSizeAndList(arrayList2);
	}
	
	public <T> void retainAllFromLists() throws CustomException {
		List<T> arrayList1 = createArrayListWithStrings();
		int endIndex = util.UtilGetInput.getIntInput("Enter the end index to create the second arraylist: ");
		List<?> arrayList2 = task.createSubArrayList(arrayList1, 0 , endIndex);
		task.retainSubList(arrayList1, arrayList2);
		printSizeAndList(arrayList1);
		printSizeAndList(arrayList2);
	}
	
	@SuppressWarnings("unchecked")
	public <T> void removeLongValues() throws CustomException {
		List<T> arrayList1 = task.createList();
		int longCount = util.UtilGetInput.getIntInput("Enter the Number of long values to add: ");
		T[] longArray = (T[]) getArray(longCount , Long.class);
		task.addElementsToList(arrayList1, longArray);
		printSizeAndList(arrayList1);
		task.deleteList(arrayList1);
		System.out.println(arrayList1);
		//printSizeAndList(arraylist1);
	}
	
	public void checkPresenceOfString() throws CustomException {
		List<?> arrayList1 = createArrayListWithStrings();
		String inputString = util.UtilGetInput.getStringInput("Enter the String to check availability in the list: ");
		Boolean availability = task.checkPresence(arrayList1 , inputString);
		if (availability == true) {
			util.UtilPrintOutput.printOutput("Yes, " + inputString + " is available in the created list");
		} else {
			util.UtilPrintOutput.printOutput("No, " + inputString + " is not available in the created list");
		}
	}
	
	public void printSizeAndList(List<?> list) throws CustomException {
		util.UtilPrintOutput.printOutput("The ArrayList is: " + list);
		util.UtilPrintOutput.printOutput("The size of the list is: " + task.getSize(list));
	}
	
	@SuppressWarnings("unchecked")
	private <T> void printByIterator(List<T> arraylist1) {
		util.UtilPrintOutput.printOutput("Using Iterator to print elements:");
		Iterator<String> iterator = (Iterator<String>) arraylist1.iterator();
		while (iterator.hasNext()) {
			util.UtilPrintOutput.printOutput(iterator.next());
		}
	}
	
	private <T> void printByForloop(List<T> arrayList1) {
		util.UtilPrintOutput.printOutput("Using for loop to print elements:");
	    for (T element : arrayList1) {
	    	util.UtilPrintOutput.printOutput((String) element);
	    }
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> createArrayListWithStrings() throws CustomException {
		List<T> arrayList1 = task.createList();
		int stringCount1 = util.UtilGetInput.getIntInput("Enter the Number of strings to add: ");
		T[] stringArray1 = (T[]) getArray(stringCount1 , String.class);
		task.addElementsToList(arrayList1 , stringArray1);
		return arrayList1;
	}
	
	 @SuppressWarnings("unchecked")
	private <T> T[] getArray(int count, Class<T> type) {
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

