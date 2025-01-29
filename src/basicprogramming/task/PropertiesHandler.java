package basicprogramming.task;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.Properties;
import util.CustomException;
import util.UtilValidator;

public class PropertiesHandler {
	
	private Properties properties;
	
	private PropertiesHandler() {
		properties = new Properties();
	}

	private static class PropertiesHandlerHolder {
		private static final PropertiesHandler INSTANCE = new PropertiesHandler();
	}

	public static PropertiesHandler getInstance() {
		return PropertiesHandlerHolder.INSTANCE;
	}

    public void addProperty(String key, String value) throws CustomException {
    	try {
	    	UtilValidator.isNull(key);
	    	UtilValidator.isNull(value);
	        properties.setProperty(key, value);
    	} catch (Exception e) {
    		throw new CustomException("Failed to add value pairs to the Property" , e);
    	}
    }
    
    public Path saveToFile(Path filePath) throws CustomException {
    	UtilValidator.isNull(filePath);
    	try (FileOutputStream fileOut = new FileOutputStream(filePath.toFile())) {
    		properties.store(fileOut, "properties saved");
    		return filePath;
    	} catch (Exception e) {
    		throw new CustomException("An error occurred while saving properties to file" , e);
    	}
    }
}
