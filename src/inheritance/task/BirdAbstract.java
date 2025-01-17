package inheritance.task;

import java.util.logging.Logger;

public abstract class BirdAbstract {
	
	private static final Logger logger = Logger.getLogger(BirdAbstract.class.getName());

	public void fly(){
		logger.info("The Bird is Flying");
	}
	
	public void speak() {
		logger.info("The Bird is speaking");
	}
	
}
