package exception;

public class CustomException extends Exception {
	private String additionalMessage;

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message , Throwable cause) {
		super(message , cause);
	}
	
	public void setAdditionalMessage(String additionalMessage) {
        this.additionalMessage = additionalMessage;
    }
	
	public String getMessage() {
	    if (additionalMessage == null) {
	        return super.getMessage();
	    }
	    return additionalMessage + " because " + super.getMessage();
	}

}
