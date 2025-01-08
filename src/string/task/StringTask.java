package string.task;

import java.util.*;
import util.UtilGetInput;
import util.UtilValidator;
import exception.CustomException;

public class StringTask {

    public int getLength(String inputString) throws CustomException {
        try {
            UtilValidator.isNull(inputString);
            return inputString.length();
        } catch (Exception e) {
            throw new CustomException("Failed to get string length", e);
        }
    }

    public char[] convertCharArray(String inputString) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
            return inputString.toCharArray();
        } catch (Exception e) {
            throw new CustomException("Failed to convert string to char array", e);
        }
    }

    public char getPenultimateChar(String inputString, int indexFromEnd) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
        	UtilValidator.emptyCheck(inputString);
            if (indexFromEnd <= 0 || inputString.length() < indexFromEnd) {
                throw new CustomException("Invalid index for penultimate character");
            }
            return inputString.charAt(inputString.length() - indexFromEnd);
        } catch (Exception e) {
            throw new CustomException("Failed to get penultimate character", e);
        }
    }

    public int getCharOccurrence(String inputString, char charInput) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
            int charCount = 0;
            for (int i = 0; i < inputString.length(); i++) {
                if (inputString.charAt(i) == charInput) {
                    charCount++;
                }
            }
            return charCount;
        } catch (Exception e) {
            throw new CustomException("Failed to count character occurrences", e);
        }
    }

    public int getGreatestPosition(String inputString, char charInput) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
            return inputString.lastIndexOf(charInput);
        } catch (Exception e) {
            throw new CustomException("Failed to get greatest position of character", e);
        }
    }

    public String getLastNChar(String inputString, int endCharLength) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
        	UtilValidator.emptyCheck(inputString);
			
            if (endCharLength <= 0 || inputString.length() < endCharLength) {
                throw new CustomException("Invalid length for substring");
            }
			
            return inputString.substring(inputString.length() - endCharLength);
        } catch (Exception e) {
            throw new CustomException("Failed to get last N characters", e);
        }
    }

    public String getFirstNChar(String inputString, int startCharLength) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
        	UtilValidator.emptyCheck(inputString);
			
            if (startCharLength <= 0 || inputString.length() < startCharLength) {
                throw new CustomException("Invalid length for substring");
            }
			
            return inputString.substring(0, startCharLength);
        } catch (Exception e) {
            throw new CustomException("Failed to get first N characters", e);
        }
    }

    public String replaceSubstring(String inputString, String replacement, int replaceLength) throws CustomException {
		try {
			UtilValidator.isNull(inputString);
			UtilValidator.isNull(replacement);
			UtilValidator.isNull(inputString);

			if (replaceLength < 0 || inputString.length() < replaceLength) {
				throw new CustomException("Invalid length to replace");
			}
			
			int position = UtilGetInput.getIntInput("Enter the position to replace the String: Enter 0 to replace from start / 1 from last / 2 for coustom index ");

			switch (position) {
				case 0:
					return replacement + inputString.substring(replaceLength);
				case 1:
					return inputString.substring(0, inputString.length() - replaceLength) + replacement;
				case 2:
					int charindex = UtilGetInput.getIntInput("Enter the starting index to replace: ");
					String firstPart = inputString.substring(0, charindex);
					String lastPart = inputString.substring(charindex + replaceLength , inputString.length());
					return firstPart + replacement + lastPart;
				default:
					throw new IllegalArgumentException("Invalid position. Use 0 for 'front', 1 for 'rear' and 2 for 'middle'.");
			}
			
		} catch (Exception e) {
			throw new CustomException("Failed to replace substring", e);
		}
	}

    public Boolean compareStartChars(String inputString, String startChars) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
        	UtilValidator.isNull(startChars);
            return inputString.startsWith(startChars);
        } catch (Exception e) {
            throw new CustomException("Failed to compare start characters", e);
        }
    }

    public Boolean compareEndChars(String inputString, String endChars) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
        	UtilValidator.isNull(endChars);
            return inputString.endsWith(endChars);
        } catch (Exception e) {
            throw new CustomException("Failed to compare end characters", e);
        }
    }

    public String convertingToUpperCase(String inputString) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
            return inputString.toUpperCase();
        } catch (Exception e) {
            throw new CustomException("Failed to convert to uppercase", e);
        }
    }

    public String convertingToLowerCase(String inputString) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
            return inputString.toLowerCase();
        } catch (Exception e) {
            throw new CustomException("Failed to convert to lowercase", e);
        }
    }

    public String reversingString(String inputString) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
            char[] reverseList = inputString.toCharArray();
            int left = 0, right = reverseList.length - 1;
            while (left < right) {
                char temp = reverseList[left];
                reverseList[left] = reverseList[right];
                reverseList[right] = temp;
                left++;
                right--;
            }
            return new String(reverseList);
        } catch (Exception e) {
            throw new CustomException("Failed to reverse string", e);
        }
    }

    public String concatenateMultipleStrings(String inputString, String splitChar) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
        	UtilValidator.isNull(splitChar);
            return inputString.replace(splitChar, "");
        } catch (Exception e) {
            throw new CustomException("Failed to concatenate strings", e);
        }
    }

    public String[] encloseInArray(String inputString, String splitChars) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
        	UtilValidator.isNull(splitChars);
            return inputString.split(splitChars);
        } catch (Exception e) {
            throw new CustomException("Failed to enclose in array", e);
        }
    }

    public String mergeStringWithSymbol(List<String> inputStrings, CharSequence joiningChar) throws CustomException {
    	try {
	    	UtilValidator.isNull(inputStrings);
			return String.join(joiningChar, inputStrings);
    	} catch (CustomException e) {
    		throw new CustomException("Failed to enclose in array", e);
    	}
    }

    public Boolean areStringsCaseEqual(String string1, String string2) throws CustomException {
        try {
        	UtilValidator.isNull(string1);
        	UtilValidator.isNull(string2);
            return string1.equals(string2);
        } catch (Exception e) {
            throw new CustomException("Failed to compare strings (case-sensitive)", e);
        }
    }

    public Boolean areStringsIgnoreCaseEqual(String string1, String string2) throws CustomException {
        try {
        	UtilValidator.isNull(string1);
        	UtilValidator.isNull(string2);
            return string1.equalsIgnoreCase(string2);
        } catch (Exception e) {
            throw new CustomException("Failed to compare strings (ignore case)", e);
        }
    }

    public String trimString(String inputString) throws CustomException {
        try {
        	UtilValidator.isNull(inputString);
            return inputString.trim();
        } catch (Exception e) {
            throw new CustomException("Failed to trim string", e);
        }
    }
}
