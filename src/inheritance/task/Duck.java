package inheritance.task;

import java.util.logging.Logger;

public class Duck extends Bird {
	
	private static final Logger logger = Logger.getLogger(Duck.class.getName());
	
	public void fly(){
		logger.info("The Bird is flying");
	}
}