package basicprogramming.task;

import java.util.logging.Logger;

public enum EnumSingleton {
	
    INSTANCE;
	
	private static final Logger logger = Logger.getLogger(EnumSingleton.class.getName());

	public void showMessage() {
        logger.info("This is a EnumSingleton");
    }
}
