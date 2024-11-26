package com.stringbuildertask;

public class StringBuilderTask{
	public StringBuilder createStringBuilder(String[] inputstrings , String seperator){
	StringBuilder stringbuilder = new StringBuilder();
	for (int i = 0; i < inputstrings.length; i++){
		stringbuilder.append(inputstrings[i]);
		if (i < (inputstrings.length - 1)){
			stringbuilder.append(seperator);
		}
	}
	return stringbuilder;
	}

	public int getLength(StringBuilder sb) {
        return sb.length();
	}

	public String getFinalString(StringBuilder sb) {
        return sb.toString();
	}

	public StringBuilder addToStringBuilder(String[] tobeaddedstrings , StringBuilder inputsb , String seperator) {
		for (int i = 0; i < tobeaddedstrings.length; i++) {
			inputsb.append(tobeaddedstrings[i]);
			if  (i < (tobeaddedstrings.length - 1)) {
				inputsb.append(seperator);
			}
		}
	return inputsb;
	}
	
	public StringBuilder insertToStringBuilder(String[] insertstrings , String[] stringbuilderinput , StringBuilder inputsb , String seperator ,  int insertafterno) {
		int insertPosition = 0;
		for (int i = 0; i < insertafterno; i++) {
        insertPosition += stringbuilderinput[i].length() + (seperator.length());
		}
		for (int i = insertstrings.length - 1; i >= 0; i--) {
			String tempuse = insertstrings[i] + seperator;
			inputsb.insert(insertPosition , tempuse);
		}
	return inputsb;
	}
	
	public String[] splitStringBuilder (StringBuilder inputsb , String seperator) {
		String splitinputstring = getFinalString(inputsb);
		return splitinputstring.split(seperator);
	}
	
	public StringBuilder deleteStringsInSB (StringBuilder inputsb , int deletestringindex , String seperator) {
		String[] inputstringarray = splitStringBuilder(inputsb, seperator);
		/*if (deletestringindex < 0 || deletestringindex >= inputstringarray.length) {
			throw new IllegalArgumentException("Invalid index for deletion.");*/
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
	}
	
	public StringBuilder deleteCharsInSB (StringBuilder inputsb , int startcharindex , int endcharindex) {
		return inputsb.delete(startcharindex , endcharindex);
	}
	
	public StringBuilder replaceSeperator (StringBuilder inputsb , String seperator , String newseperator) {
		int seperatorindex = inputsb.indexOf(seperator);
		int seperatorlength = seperator.length();
		while (seperatorindex != 1) {
			inputsb.replace(seperatorindex , seperatorindex + seperatorlength , newseperator);
			seperatorindex = inputsb.indexOf(seperator , seperatorindex + seperatorlength);
		}
		return inputsb;
	}
	
	public StringBuilder reversingString (StringBuilder inputsb) {
		return inputsb.reverse();
	}
	
	public StringBuilder replaceChars (StringBuilder inputsb , String replacingstring , int startcharindex , int endcharindex) {
		if (startcharindex >= 0 || getLength(inputsb) >= endcharindex) {
			inputsb.replace(startcharindex , endcharindex , replacingstring);
		}
		return inputsb;
	}
	
	/*public int minimumIndex (StringBuilder inputsb , String seperator) {
		int seperatorindex = inputsb.indexOf(seperator);
		return seperatorindex;
	}*/
	
	public int maximumIndex (StringBuilder inputsb , String seperator , int nthseperator) {
		int seperatorindex = -1;
		for (int i = 1; i <= nthseperator; i++){
			seperatorindex = inputsb.indexOf(seperator, seperatorindex + 1);
		}
		return seperatorindex;
	}
	
}