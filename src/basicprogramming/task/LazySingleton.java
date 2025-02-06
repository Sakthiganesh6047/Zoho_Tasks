package basicprogramming.task;

import java.io.Serializable;
import java.util.logging.Logger;

public class LazySingleton implements Serializable, Cloneable {
	
	private static final long serialVersionUID = -1L;
	private static final Logger logger = Logger.getLogger(LazySingleton.class.getName());
	
	private static LazySingleton instance;

    private LazySingleton() {
    	if (instance != null) {
            throw new IllegalStateException("Singleton instance already created");
        }
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
    
    public void showMessage() {
        logger.info("This is a LazySingleton");
    }
    
    protected Object readResolve() {
        return getInstance();
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not allowed for Singleton");
    }
}
