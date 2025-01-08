package util;

import exception.CustomException;

public class UtilValidator {

	public static <T> void isNull(T Object) throws CustomException {
		if (Object == null) {
			throw new CustomException("Input can't be null");
		}
	}
	
	public static <T> void emptyCheck(String inputString) throws CustomException {
		if (inputString.isEmpty()) {
			throw new CustomException("String can't be empty");
		}
	}
}
