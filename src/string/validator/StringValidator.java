package string.validator;

import exception.*;

public class StringValidator{
	public static void checkNullOrEmpty(String inputString) throws CustomException {
        if (inputString == null || inputString.isEmpty()) {
            throw new CustomException("Input string cannot be null or empty");
        }
    }
}