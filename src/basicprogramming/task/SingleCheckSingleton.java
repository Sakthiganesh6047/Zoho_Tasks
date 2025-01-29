package basicprogramming.task;

import java.util.logging.Logger;

public class SingleCheckSingleton {
	
	private static final Logger logger = Logger.getLogger(SingleCheckSingleton.class.getName());
	
	private static SingleCheckSingleton instance;

	private SingleCheckSingleton() {
	}

	public static synchronized SingleCheckSingleton getInstance() {
		 if (instance == null) {
			 instance = new SingleCheckSingleton();
		 }
		 return instance;
	}
	 
	public void showMessage() {
		logger.info("This is a SingleCheckSingleton");
	}
}
