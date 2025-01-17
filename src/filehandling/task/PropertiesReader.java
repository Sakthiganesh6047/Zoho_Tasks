package filehandling.task;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;
import util.CustomException;
import util.UtilValidator;

public class PropertiesReader {
	
	private PropertiesReader() {
    }

    private static class PropertiesReaderHelper {
        private static final PropertiesReader INSTANCE = new PropertiesReader();
    }

    public static PropertiesReader getInstance() {
        return PropertiesReaderHelper.INSTANCE;
    }
	
	Properties properties = new Properties();
	private static final Logger logger = Logger.getLogger(PropertiesReader.class.getName());
	
	public void readFile(String fileName) throws CustomException {
		UtilValidator.isNull(fileName);
		try {
            
            FileInputStream fileInputStream = new FileInputStream(fileName);
            properties.load(fileInputStream);
            fileInputStream.close();
            
            logger.info("Properties loaded from file:");
            properties.list(System.out);

        } catch (Exception e) {
           throw new CustomException("Failed to load the File " , e);
            }
        }
	}
        

        

