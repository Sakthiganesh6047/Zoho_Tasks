package RegEx.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.CustomException;
import util.UtilValidator;

public class RegExTask {
	
	private static String mobileNumberPattern = "^[6789]\\d{9}$";
    private static String alphaNumericPattern = "^[a-zA-Z0-9]+$";
    private static String emailPattern = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+$";
	private static String stringRegex = "^.{1,6}$";
	private static String htmlPattern= "</?[a-zA-Z]+(?:\\\\s[^>]*?)?>";
	
	private RegExTask() {
	}
	
	private static class SingletonHelper {
		private static final RegExTask INSTANCE = new RegExTask();
	}

	public static RegExTask getRegExTaskInstance() {
		return SingletonHelper.INSTANCE;
	}

    public boolean isValidMobileNumber(String mobileNumber) throws CustomException {
    	UtilValidator.isNull(mobileNumber);
        return Pattern.matches(mobileNumberPattern, mobileNumber);
    }

    public boolean isAlphaNumeric(String input) throws CustomException {
    	UtilValidator.isNull(input);
        return Pattern.matches(alphaNumericPattern, input);
    }
    
    public boolean checkStringStartsWith(String givenString, String matchingString) throws CustomException {
    	UtilValidator.isNull(givenString);
    	UtilValidator.isNull(matchingString);
    	String startsWithPattern = "^" + Pattern.quote(matchingString) + ".*";
    	return Pattern.matches(startsWithPattern, givenString);
    }
    
    public boolean checkStringContains(String givenString, String matchingString) throws CustomException {
    	UtilValidator.isNull(givenString);
    	UtilValidator.isNull(matchingString);
    	String containsPattern = ".*" + Pattern.quote(matchingString) + ".*";
    	return Pattern.matches(containsPattern, givenString);
    }
    
    public boolean checkStringEndsWith(String givenString, String matchingString) throws CustomException {
    	UtilValidator.isNull(givenString);
    	UtilValidator.isNull(matchingString);
    	String endsWithPattern = ".*" + Pattern.quote(matchingString) + "$";
    	return Pattern.matches(endsWithPattern, givenString);
    }
    
    public boolean checkStringExactMatch(String givenString, String matchingString) throws CustomException {
    	UtilValidator.isNull(givenString);
    	UtilValidator.isNull(matchingString);
    	String exactMatchPattern = "^" + Pattern.quote(matchingString) + "$";
    	return Pattern.matches(exactMatchPattern, givenString);
    }
    
    public List<String> findCaseInsensitiveMatches(List<String> inputList, String matchingString) throws CustomException {
    	UtilValidator.isNull(inputList);
    	UtilValidator.isNull(matchingString);
        Set<String> uniqueMatches = new LinkedHashSet<>();
        Pattern pattern = Pattern.compile("^" + Pattern.quote(matchingString) + "$", Pattern.CASE_INSENSITIVE);
        for (String str : inputList) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                uniqueMatches.add(str);
            }
        }
        return new ArrayList<>(uniqueMatches);
    }

    public boolean isValidEmail(String email) throws CustomException {
    	UtilValidator.isNull(email);
    	return Pattern.matches(emailPattern, email);
    }
      
    public List<String> checkLenghtOfStrings(List<String> inputList) throws CustomException {
    	UtilValidator.isNull(inputList);
    	Pattern pattern = Pattern.compile(stringRegex);
        List<String> validStrings = new ArrayList<>();
        for (String str : inputList) {
            if (pattern.matcher(str).matches()) {
                validStrings.add(str);
            }
        }
        return validStrings;
    }
    
    public Map<String, List<Integer>> findMatchingIndices(List<String> list1, List<String> list2) throws CustomException {
    	UtilValidator.isNull(list1);
    	UtilValidator.isNull(list2);
        Map<String, List<Integer>> resultMap = new HashMap<>();
        for (String matchStr : list2) {
            List<Integer> indices = new ArrayList<>();
            Pattern pattern = Pattern.compile("^" + Pattern.quote(matchStr) + "$", Pattern.CASE_INSENSITIVE);
            for (int i = 0; i < list1.size(); i++) {
                Matcher matcher = pattern.matcher(list1.get(i));
                if (matcher.matches()) {
                    indices.add(i);
                }
            }
            if (!indices.isEmpty()) {
                resultMap.put(matchStr, indices);
            }
        }
        return resultMap;
    }

    public List<String> extractTags(String html) throws CustomException {
    	UtilValidator.isNull(html);
        List<String> tags = new ArrayList<>();
        Pattern pattern = Pattern.compile(htmlPattern);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            tags.add(matcher.group());
        }
        return tags;
    }
}
