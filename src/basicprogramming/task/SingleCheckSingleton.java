package basicprogramming.task;

import java.io.Serializable;
import java.util.logging.Logger;

public class SingleCheckSingleton implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SingleCheckSingleton.class.getName());
	private static volatile SingleCheckSingleton instance;

	private SingleCheckSingleton() {
		if (instance != null) {
            throw new IllegalStateException("Singleton instance already created");
        }
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
	
	protected Object readResolve() {
        return getInstance();
    }
	
	protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not allowed for Singleton");
    }
}
