package inheritance.task;

import java.util.logging.Logger;

public abstract class Bird {
	
	private static final Logger logger = Logger.getLogger(Bird.class.getName());
	
	public abstract void fly();
	
	public void speak(){
		logger.info("The Bird is speaking");
	}
}