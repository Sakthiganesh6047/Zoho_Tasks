package filehandling.task;

import java.util.logging.Logger;

public class Singleton {
	
	private static final Logger logger = Logger.getLogger(Singleton.class.getName());
	
    private Singleton() {
    }

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getSingletonInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void showMessage() {
        logger.info("This is a Singleton");
    }
}


