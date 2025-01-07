package exception;

import java.util.ArrayList;
import java.util.List;

public class CustomException extends Exception {
	private List<String> additionalMessages = new ArrayList<>();

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message , Throwable cause) {
		super(message , cause);
	}
	
	public void addAdditionalMessage(String message) {
        additionalMessages.add(message);
    }
	
	public String getMessage() {
        String combinedMessages = super.getMessage();
        for (String message : additionalMessages) {
            combinedMessages += " | " + message;
        }
        return combinedMessages;
    }

}
