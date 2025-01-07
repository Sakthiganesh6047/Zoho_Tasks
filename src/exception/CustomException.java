package exception;

public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private final StringBuilder additionalMessages = new StringBuilder();

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message , Throwable cause) {
		super(message , cause);
	}
	
	public void appendMessage(String message) {
        if (additionalMessages.length() > 0) {
            additionalMessages.append(" | ");
        }
        additionalMessages.append(message);
    }
	
	public String getMessage() {
	    if (additionalMessages.length() == 0) {
	        return super.getMessage();
	    } else {
	        return super.getMessage() + " | " + additionalMessages.toString();
	    }
	}
	
	/*public String getMessage() {
        StringBuilder message = new StringBuilder(super.getMessage());
        for (Throwable suppressed : getSuppressed()) {
            message.append(" | ").append(suppressed.getMessage());
        }
        return message.toString();
    }
	
	public String getMessage() {
        String combinedMessages = super.getMessage();
        for (String message : additionalMessages) {
            combinedMessages += " | " + message;
        }
        return combinedMessages;
    }
	
	public void addAdditionalMessage(String message) {
        additionalMessages.add(message);
    }*/
}
