package filehandling.runner;

import filehandling.task.AdditionalConstructorClass;
import filehandling.task.FileHandlingTask;
import filehandling.task.POJOClass1;
import filehandling.task.PropertiesHandler;
import filehandling.task.PropertiesReader;
import filehandling.task.Rainbow.RainbowColor;
import filehandling.task.Singleton;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.lang.reflect.Array;
import java.nio.file.Path;
import util.CustomException;
import util.TimeUtil;
import util.UtilGetInput;
import util.UtilPrintOutput;

public class FileHandlingRunner {
	
	private static final Logger logger = Logger.getLogger(FileHandlingRunner.class.getName()); 

	public static void main(String[] args) {
		FileHandlingRunner runner = new FileHandlingRunner();
		runner.runOperations();
	}
	
	private void runOperations() {
		int enteredChoice = 0;
		
		do {
			
			try {
				
				logger.info("1. Create a file Sample.txt");
				logger.info("2. Store values in myprops.txt");
				logger.info("3. Read the incoming file");
				logger.info("4. Create files in specified Directory");
				logger.info("5. Initiate additional constructor with a string.");
				logger.info("6. Invoking the POJO class by the constructor");
				logger.info("7. Invoking the POJO class by the getter and setter.");
				logger.info("8. Invoke the POJO class dynamically.");
				logger.info("9. Print the Enum Rainbow class");
				logger.info("10. Run the Singleton class");
				logger.info("11. Run the operation on Time");
				
				enteredChoice = UtilGetInput.getIntInput("Enter the choice of operation: ");
				
				 if (enteredChoice < 0 || enteredChoice > 12) {
					 logger.info("Invalid Choice, Enter a choice from 0 to 20");
				 }
				 
				 switch(enteredChoice) {
				 
				 case 1:
					 createTextFile();
					 break;
					 
				 case 2:
					 createPropertiesFile();
					 break;
					 
				 case 3:
					 readPropertiesFile();
					 break;
					 
				 case 4:
					 createFilesInDir();
					 break;
						 
				 case 5:
					 additionalCon();
					 break;
					 
				 case 6:
					 invokingPOJOByConstructor();
					 break;
					 
				 case 7:
					 invokingPOJOByMethods();
					 break;
					 
				 case 8:
					 invokingPOJODynamically();
					 break;
					 
				 case 9:
					 getRainbowColors();
					 break;
					 
				 case 10:
					 runSingleton();
					 break;
					 
				 case 11:
					 timeOperations();
					 break;
					
				 case 0:
					 logger.info("Terminated Successfully!");
					 break;
					 
				 }
				
			} catch(CustomException e) {
				logger.severe("An error occurred " + e.getMessage());
				logger.log(Level.SEVERE, "An exception occurred", e);
			}
		}
		while(enteredChoice!=0);
	}
	
	@SuppressWarnings("unchecked")
	private <T> void createTextFile() throws CustomException {
		int arrayCount = UtilGetInput.getIntInput("Enter the no.of Strings to add to the file: ");
		T[] inputArray = (T[]) getArray(arrayCount , String.class);
		FileHandlingTask fileHandlingTask = FileHandlingTask.getInstance();
		String fileName = UtilGetInput.getStringInput("Enter the file name to be created: ");
		Path filePath = fileHandlingTask.createFileInDir(fileName, "Generated files");
		logger.info(fileHandlingTask.writeToFile(filePath.toString() , inputArray));
	}
	
	private void createPropertiesFile() throws CustomException {
		PropertiesHandler propertiesHandler = PropertiesHandler.getInstance();
		int pairCount = UtilGetInput.getIntInput("Enter the No. of pair values to add in the Property: ");
		for (int i = 0 ; i < pairCount ; i++) {
			String key = UtilGetInput.getStringInput("Enter key " + (i + 1) + ": ");
	        String value = UtilGetInput.getStringInput("Enter value for key " + key + ": ");
	        propertiesHandler.addProperty(key , value);
		}
		String fileName = UtilGetInput.getStringInput("Enter the file name to be created: ");
		FileHandlingTask fileHandlingTask = FileHandlingTask.getInstance();
		Path filePath = fileHandlingTask.createFileInDir(fileName, "Generated files");
		logger.info(propertiesHandler.saveToFile(filePath));
	}
	
	private void readPropertiesFile() throws CustomException {
		PropertiesReader reader = PropertiesReader.getInstance();
		String fileName = UtilGetInput.getStringInput("Enter the File name to read: ");
		reader.readFile(fileName);
	}
	
	@SuppressWarnings("unchecked")
	private <T> void createFilesInDir() throws CustomException {
		PropertiesHandler propertiesHandler = PropertiesHandler.getInstance();
		
		UtilPrintOutput.printOutput(System.getProperty("user.dir"));
		System.clearProperty("user.dir");
		UtilPrintOutput.printOutput(System.getProperty("user.dir"));
		String homeDirValue = System.getProperty("user.home");
		System.setProperty("user.dir" , homeDirValue);
		UtilPrintOutput.printOutput("Current User directory is: " + System.getProperty("user.dir"));
		
		int arrayCount = UtilGetInput.getIntInput("Enter the no.of Strings to add to the file: ");
		T[] inputArray = (T[]) getArray(arrayCount , String.class);
		String filePath1 = getFilePath().toString();
		FileHandlingTask fileHandlingTask = FileHandlingTask.getInstance();
		logger.info(fileHandlingTask.writeToFile(filePath1 , inputArray));
		
		int pairCount = UtilGetInput.getIntInput("Enter the No. of pair values to add in the Property: ");
		for (int i = 0 ; i < pairCount ; i++) {
			String key = UtilGetInput.getStringInput("Enter key " + (i + 1) + ": ");
	        String value = UtilGetInput.getStringInput("Enter value for key " + key + ": ");
	        propertiesHandler.addProperty(key , value);
		}
		Path filePath2 = getFilePath();
		logger.info(propertiesHandler.saveToFile(filePath2));
		
		String fileName = UtilGetInput.getStringInput("Enter the File name to read: ");
		PropertiesReader reader = PropertiesReader.getInstance();
		reader.readFile(fileName);
	}
	
	private Path getFilePath() throws CustomException {
		//String baseDir = UtilGetInput.getStringInput("Enter the base directory name: ");
		String dirName = UtilGetInput.getStringInput("Enter the Directory Name: ");
		String fileName = UtilGetInput.getStringInput("Enter the file name to create: ");
		FileHandlingTask fileHandlingTask = FileHandlingTask.getInstance();
		return fileHandlingTask.createFileInDir(dirName, fileName);
	}
	
	private void additionalCon() {
		String input = UtilGetInput.getStringInput("Enter a string to load the constructor: ");
		AdditionalConstructorClass additionalConstructorClass = new AdditionalConstructorClass(input);
		logger.info(additionalConstructorClass.toString());
	}
	
	private void invokingPOJOByConstructor() throws CustomException {
		String name = UtilGetInput.getStringInput("Enter the person name: ");
		int age = UtilGetInput.getIntInput("Enter the age of the person: ");
		POJOClass1 person = new POJOClass1(name, age);
		logger.info(person.toString());
	}
	
	private void invokingPOJOByMethods() throws CustomException {
		POJOClass1 person = new POJOClass1();
		String name = UtilGetInput.getStringInput("Enter the person name: ");
		person.setName(name);
		int age = UtilGetInput.getIntInput("Enter the age of the person: ");
		person.setAge(age);
		logger.info(person.toString());
	}
	
	private void invokingPOJODynamically() throws CustomException {
		try {
		    Class<?> pojoClass = Class.forName("pojoclass.POJOClass");

		    Object pojoInstanceDefault = pojoClass.getDeclaredConstructor().newInstance();
		    logger.info("Default Constructor Invoked: " + pojoInstanceDefault);

		    String name = UtilGetInput.getStringInput("Enter the name of the person: ");
		    int age = UtilGetInput.getIntInput("Enter the age of the person: ");
		    
		    Object pojoInstanceOverloaded = pojoClass.getDeclaredConstructor(String.class, int.class).newInstance(name, age);
		    logger.info("Overloaded Constructor Invoked: " + pojoInstanceOverloaded);

		    String name1 = UtilGetInput.getStringInput("Enter the name of the person (Setter): ");
		    pojoClass.getMethod("setName", String.class).invoke(pojoInstanceDefault, name1);
		    logger.info("Setter Invoked: " + pojoInstanceDefault);

		    String name2 = (String) pojoClass.getMethod("getName").invoke(pojoInstanceDefault);
		    logger.info("Getter Invoked: Name = " + name2);
		} catch (Exception e) {
		    throw new CustomException("Error occurred", e);
		}
	}
	
	private void getRainbowColors() {
        for (RainbowColor color : RainbowColor.values()) {
        	logger.info("Color: " + color + ", Color code: " + color.getColorCode());
        }
        
        logger.info("Ordinal values of each color:");
        for (RainbowColor color : RainbowColor.values()) {
        	logger.info(color + " has ordinal " + color.ordinal());
        }
	}
	
	private void runSingleton() {
		Singleton singleton1 = Singleton.getSingletonInstance();
        Singleton singleton2 = Singleton.getSingletonInstance();

        logger.info("Are both instances the same? " + (singleton1 == singleton2));

        singleton1.showMessage();
	}
	
	private void timeOperations() throws CustomException {
		
		logger.info("Current Time with Date: " + TimeUtil.getCurrentTimeWithDate());

		logger.info("Current Time in Millis (Instant): " + TimeUtil.getCurrentTimeInMillis());
		logger.info("Current Time in Millis (System): " + TimeUtil.getCurrentTimeInMillisUsingSystem());

		logger.info("Time in New York" + TimeUtil.getCurrentTimeInNewYork());
		logger.info("Time in London" + TimeUtil.getCurrentTimeInLondon());

        long currentMillis = TimeUtil.getCurrentTimeInMillis();
        logger.info("Weekday: " + TimeUtil.getWeekdayFromMillis(currentMillis));

        logger.info("Month: " + TimeUtil.getMonthFromMillis(currentMillis));

        logger.info("Year: " + TimeUtil.getYearFromMillis(currentMillis));
	}
	
	
	@SuppressWarnings("unchecked")
	private <T> T[] getArray(int count, Class<T> type) throws CustomException {
		 T[] array = (T[]) Array.newInstance(type, count);
		 for (int i = 0; i < count; i++) {
           if (type == Long.class) {
               array[i] = type.cast(UtilGetInput.getLongInput("Enter the long value " + (i + 1) + " to add: "));
           } else if (type == Integer.class) {
               array[i] = type.cast(UtilGetInput.getIntInput("Enter the integer value " + (i + 1) + " to add: "));
           } else if (type == Double.class) {
               array[i] = type.cast(UtilGetInput.getDoubleInput("Enter the decimal value " + (i + 1) + " to add: "));
           } else if (type == String.class) {
               array[i] = type.cast(UtilGetInput.getStringInput("Enter the string value " + (i + 1) + " to add: "));
           }
       }
		 return array;
	 }
}
		  
