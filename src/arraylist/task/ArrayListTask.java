package arraylist.task;

import java.util.ArrayList;
import java.util.List;
import exception.CustomException;

public class ArrayListTask {
	//exception propagation without chaining	done
	//remove all values not working				done
	// println to file							done
	//null check for addElementsToList			done
	//addCustomObject							done

    public <T> List<T> createList() {
        return new ArrayList<>();
    }
	
	public <T> List<T> addElementsToList(List<T> list, T[] elements) throws CustomException {
		try {
			checkArrayValidity(elements);
			checkListValidity(list);
		    for (T element : elements) {
		        list.add(element);
		    }
		    return list;
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to add elements to the List"));
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> addStringInIndex(List<T> list , String inputString , int addIndex) throws CustomException {
		try {
			checkListValidity(list);
			if (addIndex < 0 || addIndex > list.size()) {
				throw new CustomException("Index to add is greater than the size of the list.");
				}
			list.add(addIndex , (T) inputString);
			return list;
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to add the value at the index in the List"));
			throw e;
		}
	}
	
	public <T> List<T> addCustomObject(List<T> list , T object) throws CustomException {
		try {
			checkListValidity(list);
			list.add(object);
			return list;	
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to add the object to the List"));
			throw e;
		}
	}
	
	public int firstOccurenceOfString(List<?> list , String stringToFind) throws CustomException {
		try {
			checkListValidity(list);
			return list.indexOf(stringToFind);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to get the first occurence of the List"));
			throw e;
		}
	}
	
	public int lastOccurenceOfString(List<?> list , String stringToFind) throws CustomException {
		try {
			checkListValidity(list);
			return list.lastIndexOf(stringToFind);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to get the last occurence of the List"));
			throw e;
		}
	}
	
	public <T> T getByIndex(List<T> list , int stringIndex) throws CustomException {
		try {
		checkListValidity(list);
		if (stringIndex < 0 || stringIndex >= list.size()) {
			throw new CustomException("Index is greater than the size of Arraylist.");
		}
		return (list.get(stringIndex));
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to get the value by index in the List"));
			throw e;
		}
	}
	
	public List<?> createSubArrayList(List<?> list , int startIndex , int endIndex) throws CustomException {
		try {
		checkListValidity(list);
		if (startIndex < 0 || endIndex < 0 || startIndex > endIndex || endIndex > list.size()) {
			throw new CustomException("startindex or endindex is greater than the size of Arraylist.");
		}
		return new ArrayList<>(list.subList(startIndex, endIndex));
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to create sub arrayList"));
			throw e;
		}
	}
	
	public <T> List<?> combinedList(List<T> list1, List<T> list2) throws CustomException {
		try {
			checkListValidity(list1);
			checkListValidity(list2);
			ArrayList<T> list3 = new ArrayList<>(list1);
			list3.addAll(list2);
			return list3;
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to combine List"));
			throw e;
		}
	}
	
	public List<?> deleteElementByIndex(List<?> list , int delIndex) throws CustomException {
		try {
			checkListValidity(list);
			if (delIndex < 0 || delIndex >= list.size()) {
				throw new CustomException("Delete index is greater than the size of the Arraylist.");
			}
			list.remove(delIndex);
			return list;
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to delete the element at the given index in the List"));
			throw e;
		}
	}
	
	public void deleteList(List<?> list) throws CustomException {
		try {
			checkListValidity(list);
			list.clear();
			//list = null; 	null not clearing the list
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to delete List"));
			throw e;
		}
	}
	
	public Boolean checkPresence(List<?> list , String searchString) throws CustomException {
		try {
			checkListValidity(list);
			return list.contains(searchString);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to check the presence of the string in the List"));
			throw e;
		}
	}
	
	public List<?> deleteSubList(List<?> list1 , List<?> list2) throws CustomException {
		try {
			checkListValidity(list1);
			checkListValidity(list2);
			list1.removeAll(list2);
			return list1;
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to delete the subList"));
			throw e;
		}
	}
	
	public List<?> retainSubList(List<?> list1 , List<?> list2) throws CustomException {
		try {
			checkListValidity(list1);
			checkListValidity(list2);
			list1.retainAll(list2);
			return list1;
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to retain List"));
			throw e;
		}
	}

	public int getSize(List<?> list) throws CustomException {
		try {
			checkListValidity(list);
			return list.size();
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to get size"));
			throw e;
		}
	}
	
	private void checkListValidity(List<?> list) throws CustomException {
		if (list == null) {
			throw new CustomException("List can't be null");
		}
	}
	
	private <T> void checkArrayValidity(T array) throws CustomException {
		if (array == null) {
			throw new CustomException("Array can't be null");
		}
	}
}
