package basicprogramming.task;

import java.io.Serializable;
import java.util.logging.Logger;

public class DoubleCheckSingleton implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DoubleCheckSingleton.class.getName());
	private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    	if (instance != null) {
            throw new IllegalStateException("Singleton instance already created");
        }
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
    
    public void showMessage() {
        logger.info("This is a DoubleCheckSingleton");
    }
    
    protected Object readResolve() {
        return getInstance();
    }
    
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not allowed for Singleton");
    }
}
