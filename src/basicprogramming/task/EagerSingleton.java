package basicprogramming.task;

import java.util.logging.Logger;

public class EagerSingleton {
	
	private static final Logger logger = Logger.getLogger(EagerSingleton.class.getName());
	
	private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
    
    public void showMessage() {
        logger.info("This is a EagerSingleton");
    }
}
