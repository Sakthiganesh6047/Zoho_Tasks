package arraylist.task;

import java.util.ArrayList;
import java.util.List;

import util.CustomException;
import util.UtilValidator;

public class ArrayListTask {

    public <T> List<T> createList() {
        return new ArrayList<>();
    }
	
	public <T> List<T> addElementsToList(List<T> list, T[] elements) throws CustomException {
		try {
			UtilValidator.isNull(elements);
			UtilValidator.isNull(list);
		    for (T element : elements) {
		        list.add(element);
		    }
		    return list;
		} catch (CustomException e) {
			e.appendMessage("Failed to add elements to the List");
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> addStringInIndex(List<T> list , String inputString , int addIndex) throws CustomException {
		try {
			UtilValidator.isNull(list);
			if (addIndex < 0 || addIndex > list.size()) {
				throw new CustomException("Index to add is greater than the size of the list.");
				}
			list.add(addIndex , (T) inputString);
			return list;
		} catch (CustomException e) {
			e.appendMessage("Failed to add the value at the index in the List");
			throw e;
		}
	}
	
	public <T> List<T> addCustomObject(List<T> list , T object) throws CustomException {
		try {
			UtilValidator.isNull(list);
			list.add(object);
			return list;	
		} catch (CustomException e) {
			e.appendMessage("Failed to add the object to the List");
			throw e;
		}
	}
	
	public int firstOccurenceOfString(List<?> list , String stringToFind) throws CustomException {
		try {
			UtilValidator.isNull(list);
			return list.indexOf(stringToFind);
		} catch (CustomException e) {
			e.appendMessage("Failed to get the first occurence of the List");
			throw e;
		}
	}
	
	public int lastOccurenceOfString(List<?> list , String stringToFind) throws CustomException {
		try {
			UtilValidator.isNull(list);
			return list.lastIndexOf(stringToFind);
		} catch (CustomException e) {
			e.appendMessage("Failed to get the last occurence of the List");
			throw e;
		}
	}
	
	public <T> T getByIndex(List<T> list , int stringIndex) throws CustomException {
		try {
			UtilValidator.isNull(list);
		if (stringIndex < 0 || stringIndex >= list.size()) {
			throw new CustomException("Index is greater than the size of Arraylist.");
		}
		return (list.get(stringIndex));
		} catch (CustomException e) {
			e.appendMessage("Failed to get the value by index in the List");
			throw e;
		}
	}
	
	public List<?> createSubArrayList(List<?> list , int startIndex , int endIndex) throws CustomException {
		try {
			UtilValidator.isNull(list);
		if (startIndex < 0 || endIndex < 0 || startIndex > endIndex || endIndex > list.size()) {
			throw new CustomException("startindex or endindex is greater than the size of Arraylist.");
		}
			return new ArrayList<>(list.subList(startIndex, endIndex));
		} catch (CustomException e) {
			e.appendMessage("Failed to create sub arrayList");
			throw e;
		}
	}
	
	public <T> List<?> combinedList(List<T> list1, List<T> list2) throws CustomException {
		try {
			UtilValidator.isNull(list1);
			UtilValidator.isNull(list2);
			ArrayList<T> list3 = new ArrayList<>(list1);
			list3.addAll(list2);
			return list3;
		} catch (CustomException e) {
			e.appendMessage("Failed to combine List");
			throw e;
		}
	}
	
	public List<?> deleteElementByIndex(List<?> list , int delIndex) throws CustomException {
		try {
			UtilValidator.isNull(list);
			if (delIndex < 0 || delIndex >= list.size()) {
				throw new CustomException("Delete index is greater than the size of the Arraylist.");
			}
			list.remove(delIndex);
			return list;
		} catch (CustomException e) {
			e.appendMessage("Failed to delete the element at the given index in the List");
			throw e;
		}
	}
	
	public void deleteList(List<?> list) throws CustomException {
		try {
			UtilValidator.isNull(list);
			list.clear();
			//list = null; 	null not clearing the list
		} catch (CustomException e) {
			e.appendMessage("Failed to delete List");
			throw e;
		}
	}
	
	public Boolean checkPresence(List<?> list , String searchString) throws CustomException {
		try {
			UtilValidator.isNull(list);
			return list.contains(searchString);
		} catch (CustomException e) {
			e.appendMessage("Failed to check the presence of the string in the List");
			throw e;
		}
	}
	
	public List<?> deleteSubList(List<?> list1 , List<?> list2) throws CustomException {
		try {
			UtilValidator.isNull(list1);
			UtilValidator.isNull(list2);
			list1.removeAll(list2);
			return list1;
		} catch (CustomException e) {
			e.appendMessage("Failed to delete the subList");
			throw e;
		}
	}
	
	public List<?> retainSubList(List<?> list1 , List<?> list2) throws CustomException {
		try {
			UtilValidator.isNull(list1);
			UtilValidator.isNull(list2);
			list1.retainAll(list2);
			return list1;
		} catch (CustomException e) {
			e.appendMessage("Failed to retain List");
			throw e;
		}
	}

	public int getSize(List<?> list) throws CustomException {
		try {
			UtilValidator.isNull(list);
			return list.size();
		} catch (CustomException e) {
			e.appendMessage("Failed to get size");
			throw e;
		}
	}
}
