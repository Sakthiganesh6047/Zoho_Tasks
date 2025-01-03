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
		checkListValidity(elements);
		checkListValidity(list);
	    for (T element : elements) {
	        list.add(element);
	    }
	    return list;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> addStringInIndex(List<T> list , String inputString , int addIndex) throws CustomException {
		checkListValidity(list);
		if (addIndex < 0 || addIndex > list.size()) {
			CustomException customException = new CustomException("Operation cannot be performed.");
			customException.initCause(new CustomException("Index to add is greater than the size of the list."));
			throw customException;
		}
			list.add(addIndex , (T) inputString);
			return list;
	}
	
	public <T> List<T> addCustomObject(List<T> list , T object) throws CustomException {
		checkListValidity(list);
		list.add(object);
		return list;	
	}
	
	public int firstOccurenceOfString(List<?> list , String stringToFind) throws CustomException {
		checkListValidity(list);
		return list.indexOf(stringToFind);
	}
	
	public int lastOccurenceOfString(List<?> list , String stringToFind) throws CustomException {
		checkListValidity(list);
		return list.lastIndexOf(stringToFind);
	}
	
	public <T> T getByIndex(List<T> list , int stringIndex) throws CustomException {
		checkListValidity(list);
		if (stringIndex < 0 || stringIndex >= list.size()) {
			CustomException customException = new CustomException("Operation cannot be performed.");
			customException.initCause(new CustomException("Index is greater than the size of Arraylist."));
			throw customException;
		}
		return (list.get(stringIndex));
	}
	
	public List<?> createSubArrayList(List<?> list , int startIndex , int endIndex) throws CustomException {
		checkListValidity(list);
		if (startIndex < 0 || endIndex < 0 || startIndex > endIndex || endIndex > list.size()) {
			CustomException customException = new CustomException("Operation cannot be performed.");
			customException.initCause(new CustomException("startindex or endindex is greater than the size of Arraylist."));
			throw customException;
		}
		return new ArrayList<>(list.subList(startIndex, endIndex));
	}
	
	public <T> List<?> combinedList(List<T> list1, List<T> list2) throws CustomException {
		checkListValidity(list1);
		checkListValidity(list2);
	    ArrayList<T> list3 = new ArrayList<>(list1);
	    list3.addAll(list2);
	    return list3;
	}
	
	public List<?> deleteElementByIndex(List<?> list , int delIndex) throws CustomException {
		checkListValidity(list);
		if (delIndex < 0 || delIndex >= list.size()) {
			CustomException customException = new CustomException("Operation cannot be performed.");
			customException.initCause(new CustomException("Delete index is greater than the size of the Arraylist."));
			throw customException;
		}
		list.remove(delIndex);
		return list;
	}
	
	public void deleteList(List<?> list) throws CustomException {
		checkListValidity(list);
		list.clear();
		//list = null; 	null not clearing the list
	}
	
	public Boolean checkPresence(List<?> list , String searchString) throws CustomException {
		checkListValidity(list);
		return list.contains(searchString);
	}
	
	public List<?> deleteSubList(List<?> list1 , List<?> list2) throws CustomException {
		checkListValidity(list1);
		checkListValidity(list2);
		list1.removeAll(list2);
		return list1;
	}
	
	public List<?> retainSubList(List<?> list1 , List<?> list2) throws CustomException {
		checkListValidity(list1);
		checkListValidity(list2);
		list1.retainAll(list2);
		return list1;
	}

	public int getSize(List<?> list) throws CustomException {
		checkListValidity(list);
		return list.size();
	}
	
	private void checkListValidity(List<?> list) throws CustomException {
		if (list == null) {
			 CustomException customException = new CustomException("Operation cannot be performed.");
			 customException.initCause(new CustomException("Null value detected, List can't be null."));
			 throw customException;
		}
	}
	
	private <T> void checkListValidity(T array) throws CustomException {
		if (array == null) {
			CustomException customException = new CustomException("Operation cannot be performed.");
			customException.initCause(new CustomException("Null value detected, Array can't be null."));
			throw customException;
		}
	}
}
