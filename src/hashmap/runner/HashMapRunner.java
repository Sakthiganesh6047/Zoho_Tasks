package hashmap.runner;

import hashmap.task.HashMapTask;
import util.UtilPrintOutput;
import util.UtilGetInput;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import arraylist.customobj.CustomObj;
import exception.CustomException;

public class HashMapRunner {
	
	HashMapTask task = new HashMapTask();
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws CustomException {
		HashMapRunner runner = new HashMapRunner();
		runner.runOperations();
	}
	
	private void runOperations() {
		int enteredChoice = 0;
		
		do {
			
			try {
			
				UtilPrintOutput.printOutput("1. Create a HashMap");
				UtilPrintOutput.printOutput("2. Create a HashMap with Strings as keys and values");
				UtilPrintOutput.printOutput("3. Create a HashMap with integers as keys and values");
				UtilPrintOutput.printOutput("4. Create a HashMap with Strings and intgers as keys and values");
				UtilPrintOutput.printOutput("5. Create a HashMap with Strings and objects as keys and values");
				UtilPrintOutput.printOutput("6. Create a HashMap with Strings as keys and values including null");
				UtilPrintOutput.printOutput("7. Create a HashMap with null key and non null value");
				UtilPrintOutput.printOutput("8. Check the existence of key in HashMap");
				UtilPrintOutput.printOutput("9. Check the existence of value in HashMap");
				UtilPrintOutput.printOutput("10. Create a HashMap with Strings as keys and values and alter it totally");
				UtilPrintOutput.printOutput("11. Get a value of a existing key in a HashMap");
				UtilPrintOutput.printOutput("12. Get a value of a non existing key in a HashMap");
				UtilPrintOutput.printOutput("13. Return statement for a non existence key");
				UtilPrintOutput.printOutput("14. Remove an existing key in the HashMap");
				UtilPrintOutput.printOutput("15. Remove an existing key in the HashMap when value matches");
				UtilPrintOutput.printOutput("16. Replace the value of an existing key in the HashMap");
				UtilPrintOutput.printOutput("17. Replace the value of an existing key in the HashMap when value matches");
				UtilPrintOutput.printOutput("18. Transfer all the keys & values of a HashMap to another HashMap");
				UtilPrintOutput.printOutput("19. Iterate over a HashMap and print its keys and values");
				UtilPrintOutput.printOutput("20. Remove all the entries in a HashMap");
				UtilPrintOutput.printOutput("0. Terminate Program");
				enteredChoice = UtilGetInput.getIntInput("Enter the choice of operation: ");
				
				 if (enteredChoice < 0 || enteredChoice > 20) {
					 UtilPrintOutput.printOutput("Invalid Choice, Enter a choice from 0 to 20");
				 }
				
				switch(enteredChoice) {
				case 1:
					createEmptyHashMap();
					break;
					
				case 2:
					createHashMapWithStrings();
					break;
					
				case 3:
					createHashMapWithIntegers();
					break;
					
				case 4:
					createHashMapWithStringsAndIntegers();
					break;
					
				case 5:
					createHashMapWithStringsAndObjects();
					break;
					
				case 6:
					hashMapWithStringsIncludingNull();
					break;
					
				case 7:
					hashMapOfNullKey();
					break;
					
				case 8:
					checkExistenceOfKey();
					break;
					
				case 9:
					checkExistenceOfValue();
					break;
					
				case 10:
					totalAlterInHashMap();
					break;
						
				case 11:
					getValueOfExistingKey();
					break;
					
				
				case 12:
					getValueOfNonExistingKey();
					break;
					
				case 13:
					returnStatementForNonExistenceKey();
					break;
					
				case 14:
					removeExistingKeyHashMap();
					break;
					
				case 15:
					removeKeyWhenValueMatches();
					break;
					
				case 16:
					replaceKey();
					break;
					
				case 17:
					replaceKeyWhenValueMatches();
					break;
					
				case 18:	
					transferValuesToNewHashMap();
					break;
					
				case 19:
					iteratePrintKeysAndValues();
					break;
					
				case 20:
					removeAllEntries();
					break;
					
				case 0:
					UtilPrintOutput.printOutput("Terminated Successfully!");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		while (enteredChoice != 0);
	}
	
	public <K,V> void createEmptyHashMap() throws CustomException {
		Map<K,V> hashmap1 = task.createHashMap();
		printMapAndSize(hashmap1);
	}
	
	public <K,V> void createHashMapWithStrings() throws CustomException {
		Map<K,V> hashmap1 = completeHashMap();
		printMapAndSize(hashmap1);
	}
	
	public <K,V> void createHashMapWithIntegers() throws CustomException {
		Map<K,V> hashmap1 = completeHashMap();
		printMapAndSize(hashmap1);
	}
	
	public <K,V> void createHashMapWithStringsAndIntegers() throws CustomException {
		Map<K,V> hashmap1 = completeHashMap();
		printMapAndSize(hashmap1);
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void createHashMapWithStringsAndObjects() throws CustomException {
		Map<K,V> hashMap1 = task.createHashMap();
		int numberOfPairs = UtilGetInput.getIntInput("Enter the no. of pairs to add in HashMap: ");
		for (int i = 0 ; i < numberOfPairs ; i++) {
			K key = (K) UtilGetInput.getStringInput("Enter key " + (i+1) + " : ");
			String objName = UtilGetInput.getStringInput("Enter the " + (i+1) + " object name: ");
			int objValue = UtilGetInput.getIntInput("Enter the object " + (i+1) + " value: ");
			CustomObj object = new CustomObj(objName , objValue);
			task.addKeyValuePair(hashMap1 , key , (V) object);
		}
		printMapAndSize(hashMap1);
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void hashMapWithStringsIncludingNull() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		task.addKeyValuePair(hashMap1, (K) "Asg", (V) null );
		printMapAndSize(hashMap1);
		 
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void hashMapOfNullKey() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		task.addKeyValuePair(hashMap1, (K) null, (V) Integer.valueOf(22));
		printMapAndSize(hashMap1);
	}
	
	public <K,V> void checkExistenceOfValue() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		@SuppressWarnings("unchecked")
		V checkValue = (V) UtilGetInput.getStringInput("Enter the key to check in the hashmap: ");
		Boolean availability = task.checkValueExists(hashMap1 , checkValue);
		if (availability) {
			util.UtilPrintOutput.printOutput("Yes, " + checkValue + "exists in the HashMap.");
		} else {
			util.UtilPrintOutput.printOutput("No, " + checkValue + " not exists in the HashMap.");
		}
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void checkExistenceOfKey() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		K checkKey = (K) UtilGetInput.getStringInput("Enter the key to check in the hashmap: ");
		Boolean availability = task.checkKeyExists(hashMap1 , checkKey);
		if (availability) {
			util.UtilPrintOutput.printOutput("Yes, " + checkKey + "exists in the HashMap.");
		} else {
			util.UtilPrintOutput.printOutput("No, " + checkKey + " not exists in the HashMap.");
		}
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void totalAlterInHashMap() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		K[] keyarray = task.extractKeysToArray(hashMap1);
		for (int i=0 ; i < keyarray.length ; i++) {
			V newValue = (V) UtilGetInput.getStringInput("Enter the value to update in " + keyarray[i] + " : ");
			task.updateHashMap(hashMap1, keyarray[i], newValue);
		}
		printMapAndSize(hashMap1);
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void getValueOfExistingKey() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		K searchKey = (K) UtilGetInput.getStringInput("Enter the key to get the value: ");
		util.UtilPrintOutput.printOutput((String) task.getKeyValue(hashMap1, searchKey));
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void getValueOfNonExistingKey() throws CustomException, FileNotFoundException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		K searchKey = (K) UtilGetInput.getStringInput("Enter the key to get the value: ");
		V defaultValue = (V) UtilGetInput.getStringInput("Enter the Defdault value in case of Non Existence key: ");
		util.UtilPrintOutput.printOutput((String) task.getKeyValueOrDefault(hashMap1, searchKey, defaultValue));
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void returnStatementForNonExistenceKey() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		K searchKey = (K) UtilGetInput.getStringInput("Enter the key to get the value: ");
		util.UtilPrintOutput.printOutput((String) task.getKeyValueOrDefault(hashMap1, searchKey, (V) "Zoho"));
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void removeExistingKeyHashMap() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		K keyToRemove = (K) UtilGetInput.getStringInput("Enter the key to remove: ");
		task.removeKey(hashMap1, keyToRemove);
		printMapAndSize(hashMap1);
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void removeKeyWhenValueMatches() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		K keyToRemove = (K) UtilGetInput.getStringInput("Enter the key to remove: ");
		V checkValue = (V) UtilGetInput.getStringInput("Enter the corresponding value of the " + keyToRemove + " : ");
		task.removeKeyIfValueMatches(hashMap1, keyToRemove , checkValue);
		printMapAndSize(hashMap1);
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void replaceKey() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		K replaceKey = (K) UtilGetInput.getStringInput("Enter the key to replace: ");
		V replaceValue = (V) UtilGetInput.getStringInput("Enter the replacement value: ");
		task.replaceKey(hashMap1 , replaceKey ,  replaceValue);
		printMapAndSize(hashMap1);
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void replaceKeyWhenValueMatches() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		printMapAndSize(hashMap1);
		K replaceKey = (K) UtilGetInput.getStringInput("Enter the key to replace: ");
		V checkValue = (V) UtilGetInput.getStringInput("Enter the corresponding value of the " + replaceKey + " : ");
		V replaceValue = (V) UtilGetInput.getStringInput("Enter the replacement value: ");
		task.replaceKeyIfValueMatches(hashMap1 , replaceKey , checkValue , replaceValue);
		printMapAndSize(hashMap1);
	}
	
	public <K,V> void transferValuesToNewHashMap() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		Map<K,V> hashMap2 = completeHashMap();
		printMapAndSize(hashMap1);
		printMapAndSize(hashMap2);
		task.transferValues(hashMap1, hashMap2);
		printMapAndSize(hashMap1);
		printMapAndSize(hashMap2);
	}
	
	public <K,V> void iteratePrintKeysAndValues() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		iterateHashMap(hashMap1);
	}
	
	public <K,V> void removeAllEntries() throws CustomException {
		Map<K,V> hashMap1 = completeHashMap();
		task.removeEntries(hashMap1);
		printMapAndSize(hashMap1);
	}
	
	@SuppressWarnings("unchecked")
	public <K,V> void addValuesToMap(Map<K,V> inputHashMap , int numberOfPairs) throws CustomException {
		for (int i = 0; i < numberOfPairs; i++) {
            K key = (K) UtilGetInput.getStringInput("Enter key " + (i + 1) + " : ");
            V value = (V) UtilGetInput.getStringInput("Enter value for key " + key + " : ");
            task.addKeyValuePair(inputHashMap, key, value);
        }
	}
    
    private <K,V> void printMapAndSize(Map<K,V> inputhashmap) throws CustomException {
		UtilPrintOutput.printOutput("The Hashmap is " + inputhashmap);
		UtilPrintOutput.printOutput("The Size of the Hashmap is " + task.getSize(inputhashmap));
	}
    
    
    private <K,V> void iterateHashMap(Map<K,V> map) throws CustomException {
	    for (Map.Entry<K,V> entry : map.entrySet()) {
	       UtilPrintOutput.printOutput("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	    }
    }
    
    private <K,V> Map<K,V> completeHashMap() throws CustomException {
    	Map<K,V> hashMap1 = task.createHashMap();
		int numberOfPairs1 = UtilGetInput.getIntInput("Enter the no. of pairs to add in HashMap: ");
		addValuesToMap(hashMap1 , numberOfPairs1);
		return hashMap1;
    }
    
    /*public <K,V> void addValuesToMap(Map<K, V> inputHashMap, int numberOfPairs, Class<K> keyType, Class<V> valueType) {
    for (int i = 0; i < numberOfPairs; i++) {
        K key = getInput("Enter key " + (i + 1) + ": ", keyType);
        V value = getInput("Enter value for key " + key + ": ", valueType);
        task.addKeyValuePair(inputHashMap, key, value);
    }
}

private <T> T getInput(String prompt, Class<T> type) {

    if (type == String.class) {
        return type.cast(util.UtilGetInput.getStringInput(prompt));
    } else if (type == Integer.class) {
        return type.cast(util.UtilGetInput.getIntInput(prompt));
    } else if (type == Long.class) {
        return type.cast(util.UtilGetInput.getLongInput(prompt));
    } else if (type == Double.class) {
        return type.cast(util.UtilGetInput.getDoubleInput(prompt));
    }
	return null;
}*/


}
