package stringbuilder.task;

import exception.CustomException;
import util.UtilValidator;

public class StringBuilderTask{
	public StringBuilder createStringBuilder(String[] inputstrings , String seperator) throws CustomException {
		try {
			
			UtilValidator.isNull(inputstrings);
			UtilValidator.isNull(seperator);
			StringBuilder stringbuilder = new StringBuilder();
			
			for (int i = 0; i < inputstrings.length; i++){
				stringbuilder.append(inputstrings[i]);
				if (i < (inputstrings.length - 1)) {
					stringbuilder.append(seperator);
				}
			}
				
			return stringbuilder;
			
		} catch (CustomException e) {
			throw new CustomException("Failed to create StringBuilder" , e);
		}
	}

	public int getLength(StringBuilder sb) throws CustomException {
		try {
			
			UtilValidator.isNull(sb);
	        return sb.length();
	        
		} catch (CustomException e) {
			throw new CustomException("Failed to get Length" , e);
		}
	}

	public String getFinalString(StringBuilder sb) throws CustomException {
		try {
			
			UtilValidator.isNull(sb);
	        return sb.toString();
	        
		} catch (CustomException e) {
			throw new CustomException("Failed to get the resultant string" , e);
		}
	}

	public StringBuilder addToStringBuilder(String[] tobeaddedstrings , StringBuilder inputsb , String seperator) throws CustomException {
		try {
			
			UtilValidator.isNull(tobeaddedstrings);
			UtilValidator.isNull(inputsb);
			UtilValidator.isNull(seperator);
			
			for (int i = 0; i < tobeaddedstrings.length; i++) {
				inputsb.append(tobeaddedstrings[i]);
				if  (i < (tobeaddedstrings.length - 1)) {
					inputsb.append(seperator);
				}
			}
			
			return inputsb;
			
		} catch (CustomException e) {
			throw new CustomException("Failed to add the contents in the StringBuilder" , e);
		}
	}
	
	public StringBuilder insertToStringBuilder(String[] insertstrings , String[] stringbuilderinput , StringBuilder inputsb , String seperator ,  int insertafterno) throws CustomException {
		try {
			
			UtilValidator.isNull(insertstrings);
			UtilValidator.isNull(stringbuilderinput);
			UtilValidator.isNull(inputsb);
			UtilValidator.isNull(seperator);
			
			int insertPosition = 0;
			
			for (int i = 0; i < insertafterno; i++) {
				insertPosition += stringbuilderinput[i].length() + (seperator.length());
			}
			
			for (int i = insertstrings.length - 1; i >= 0; i--) {
				String tempuse = insertstrings[i] + seperator;
				inputsb.insert(insertPosition , tempuse);
			}
			
			return inputsb;
			
		} catch (CustomException e) {
			throw new CustomException("Failed to insert string" , e);
		}
	}
	
	public String[] splitStringBuilder (StringBuilder inputsb , String seperator) throws CustomException {
		try {
			
			UtilValidator.isNull(inputsb);
			UtilValidator.isNull(seperator);
			String splitinputstring = getFinalString(inputsb);
			return splitinputstring.split(seperator);
			
		} catch (CustomException e) {
			throw new CustomException("Failed to split the StringBuilder");
		}
	}
	
	public StringBuilder deleteStringsInSB (StringBuilder inputsb , int deletestringindex , String seperator) throws CustomException {
		try {
			
			UtilValidator.isNull(inputsb);
			UtilValidator.isNull(deletestringindex);
			UtilValidator.isNull(seperator);
			String[] inputstringarray = splitStringBuilder(inputsb, seperator);
			
			if (deletestringindex < 0 || deletestringindex >= inputstringarray.length) {
				throw new CustomException ("Invalid index for deletion.");
			}
				
			String stringtodelete = inputstringarray[deletestringindex - 1];
			int currentindex = 0;
			
			for (int i = 0; i <= deletestringindex; i++) {
				currentindex = inputsb.indexOf(stringtodelete, currentindex);
				
				if (i < deletestringindex) {
					currentindex += stringtodelete.length() + seperator.length();
				}
				
			}
			
			int endCharIndex = currentindex + stringtodelete.length();
			
			if (deletestringindex < inputstringarray.length - 1) {
				endCharIndex += seperator.length();
			}
			
			inputsb.delete(currentindex, endCharIndex);
			return inputsb;
			
		} catch (CustomException e) {
			throw new CustomException("Failed to Delete Strings in StringBuilder" , e);
		}
	}
	
	public StringBuilder deleteCharsInSB(StringBuilder inputsb, int startcharindex, int endcharindex) throws CustomException {
		try {
		
			UtilValidator.isNull(inputsb);
			UtilValidator.isNull(startcharindex);
			UtilValidator.isNull(endcharindex);
			
			if (startcharindex < 0 || endcharindex > inputsb.length()) {
				throw new CustomException("Indices out of bounds. Valid range: 0 to " + inputsb.length());
			}
	
			if (startcharindex >= endcharindex) {
				throw new CustomException("Start index must be less than end index.");
			}
	
			return inputsb.delete(startcharindex, endcharindex);
			
		} catch (CustomException e) {
			throw new CustomException("Failed to Delete characters" , e);
		}
	}

	public StringBuilder replaceSeperator (StringBuilder inputsb , String seperator , String newseperator) throws CustomException {
		try {
			
			UtilValidator.isNull(inputsb);
			UtilValidator.isNull(seperator);
			UtilValidator.isNull(newseperator);
			int seperatorindex = inputsb.indexOf(seperator);
			int seperatorlength = seperator.length();
			
			while (seperatorindex != -1) {
				inputsb.replace(seperatorindex , seperatorindex + seperatorlength , newseperator);
				seperatorindex = inputsb.indexOf(seperator , seperatorindex + seperatorlength);
			}
			
			return inputsb;
			
		} catch (CustomException e) {
			throw new CustomException("Failed to replace the Separator" , e);
		}
	}
	
	public StringBuilder reversingString (StringBuilder inputsb) throws CustomException {
		try {
			
			UtilValidator.isNull(inputsb);
			return inputsb.reverse();
			
		} catch (CustomException e) {
			throw new CustomException("Failed to reverse StringBuilder");
		}
	}
	
	public StringBuilder replaceChars (StringBuilder inputsb , String replacingstring , int startcharindex , int endcharindex) throws CustomException {
		try {
			
			UtilValidator.isNull(inputsb);
			UtilValidator.isNull(replacingstring);
			UtilValidator.isNull(startcharindex);
			UtilValidator.isNull(endcharindex);
			
			if (startcharindex >= 0 || getLength(inputsb) >= endcharindex) {
				inputsb.replace(startcharindex , endcharindex , replacingstring);
			}
			
			return inputsb;
			
		} catch (CustomException e) {
			throw new CustomException("Failed to Replace characters" , e);
		}
	}
	
	public int minimumIndex (StringBuilder inputsb , String seperator) throws CustomException {
		try {
			
			UtilValidator.isNull(inputsb);
			int seperatorindex = inputsb.indexOf(seperator);
			return seperatorindex;
			
		} catch (CustomException e) {
			throw new CustomException("Failed to find the minimum index");
		}
	}
	
	public int maximumIndex (StringBuilder inputsb , String seperator) throws CustomException {
		try {
		
			UtilValidator.isNull(inputsb);
			UtilValidator.isNull(seperator);
			int seperatorindex = inputsb.lastIndexOf(seperator);
			return seperatorindex;
			
		} catch (CustomException e) {
			throw new CustomException("Failed to find the maximum index");
		}
	}
	
	public int coustomSeperatorIndex (StringBuilder inputsb , String seperator , int nthseperator) throws CustomException {
		try {
			
			UtilValidator.isNull(inputsb);
			UtilValidator.isNull(seperator);
			UtilValidator.isNull(nthseperator);
			int seperatorindex = -1;
			
			for (int i = 1; i <= nthseperator; i++){
				seperatorindex = inputsb.indexOf(seperator, seperatorindex + 1);
			}
			
			return seperatorindex;
			
		} catch (CustomException e) {
			throw new CustomException("Failed to get the separator index");
		}
	}
	
}