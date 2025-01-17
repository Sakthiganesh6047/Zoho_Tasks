package filehandling.task;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.Properties;
import util.CustomException;
import util.UtilValidator;

public class PropertiesHandler {
	
	private PropertiesHandler() {
	}

	private static class PropertiesHandlerHolder {
		private static final PropertiesHandler INSTANCE = new PropertiesHandler();
	}

	public static PropertiesHandler getInstance() {
		return PropertiesHandlerHolder.INSTANCE;
	}
	
	private Properties properties;

    public void addProperty(String key, String value) throws CustomException {
    	try {
	    	UtilValidator.isNull(key);
	    	UtilValidator.isNull(value);
	        properties.setProperty(key, value);
    	} catch (Exception e) {
    		throw new CustomException("Failed to add value pairs to the Property" , e);
    	}
    }
    
    public String saveToFile(Path filePath) throws CustomException {
    	UtilValidator.isNull(filePath);
    	try (FileOutputStream fileOut = new FileOutputStream(filePath.toFile())) {
    		properties.store(fileOut, "properties saved");
    		return ("Properties saved to file: " + filePath);
    	} catch (Exception e) {
    		throw new CustomException("An error occurred while saving properties to file" , e);
    	}
    }
    
    /*public String saveToFile(String fileName) throws CustomException {
    	UtilValidator.isNull(fileName);
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            properties.store(fileOut, "Properties File");
            return ("Properties saved to file: " + fileName);
        } catch (IOException e) {
            throw new CustomException("An error occurred while saving properties to file." , e);
        }
    }*/
    
    
}
