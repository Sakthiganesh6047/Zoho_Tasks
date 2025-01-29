package basicprogramming.task;

import java.util.logging.Logger;

public class DoubleCheckSingleton {
	
	private static final Logger logger = Logger.getLogger(DoubleCheckSingleton.class.getName());
	
	private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
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
}
