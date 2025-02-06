package basicprogramming.task;

import java.io.Serializable;
import java.util.logging.Logger;

public class EagerSingleton implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(EagerSingleton.class.getName());
	
	private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    	if (INSTANCE!= null) {
            throw new IllegalStateException("Singleton instance already created");
        }
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
    
    public void showMessage() {
        logger.info("This is a EagerSingleton");
    }
    
    protected Object readResolve() {
        return getInstance();
    }
    
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not allowed for Singleton");
    }
}
