package basicprogramming.task;

import java.util.logging.Logger;

public class BillPughSingleton {
	
	private static final Logger logger = Logger.getLogger(BillPughSingleton.class.getName());
	
    private BillPughSingleton() {
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
}


