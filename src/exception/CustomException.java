package exception;

public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message , Throwable cause) {
		super(message , cause);
	}
	
	public String getMessage() {
        StringBuilder message = new StringBuilder(super.getMessage());
        for (Throwable suppressed : getSuppressed()) {
            message.append(" | ").append(suppressed.getMessage());
        }
        return message.toString();
    }
	
	/*public String getMessage() {
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
