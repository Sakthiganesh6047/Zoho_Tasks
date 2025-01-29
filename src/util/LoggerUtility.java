package util;

import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtility {

    private LoggerUtility() {
    }
    
    public static Logger getLogger(Class<?> className , String logDirectory) {
        Logger logger = Logger.getLogger(className.getName());
        configureLogger(logger , logDirectory);
        return logger;
    }

    private static void configureLogger(Logger logger , String logDirectory) {
        try {
            FileHandler infoHandler = new FileHandler(logDirectory + "/info.log", true);
            infoHandler.setLevel(Level.INFO);
            infoHandler.setFormatter(new SimpleFormatter());
            //infoHandler.setFilter(record -> record.getLevel().equals(Level.INFO));

            FileHandler severeHandler = new FileHandler(logDirectory + "/severe.log", true);
            severeHandler.setLevel(Level.SEVERE);
            severeHandler.setFormatter(new SimpleFormatter());
            severeHandler.setFilter(record -> record.getLevel().equals(Level.SEVERE));
            
            FileHandler finestHandler = new FileHandler(logDirectory + "/total.log" , true);
            finestHandler.setLevel(Level.FINEST);
            finestHandler.setFormatter(new SimpleFormatter());
           
            logger.addHandler(finestHandler);
            logger.addHandler(infoHandler);
            logger.addHandler(severeHandler);
            logger.setLevel(Level.ALL);

            Logger rootLogger = Logger.getLogger("");
            for (Handler handler : rootLogger.getHandlers()) {
                rootLogger.removeHandler(handler);
            }

        } catch (Exception e) {
            System.err.println("Failed to set up logger handlers: " + e.getMessage());
        }
    }
}


