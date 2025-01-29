package basicprogramming.task;

import java.util.logging.Logger;

public class LazySingleton {
	
	private static final Logger logger = Logger.getLogger(LazySingleton.class.getName());
	
	private static LazySingleton instance;

    private LazySingleton() {
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
}
