package basicprogramming.task;

import java.io.Serializable;
import java.util.logging.Logger;

public class BillPughSingleton implements Serializable, Cloneable {
	
	Object object;
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BillPughSingleton.class.getName());
	
    private BillPughSingleton() {
    	if (SingletonHelper.INSTANCE != null) {
            throw new IllegalStateException("Singleton instance already created");
        }
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getSingletonInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void showMessage() {
        logger.info("This is a BillPughSingleton");
    }
    
    protected Object readResolve() {
        return getSingletonInstance();
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not allowed for Singleton");
    }
}


