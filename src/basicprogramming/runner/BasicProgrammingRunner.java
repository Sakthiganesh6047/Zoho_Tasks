package basicprogramming.runner;

import java.util.logging.Logger;
import basicprogramming.task.AdditionalConstructorClass;
import basicprogramming.task.BasicProgrammingTask;
import basicprogramming.task.Employee;
import basicprogramming.task.EnumSingleton;
import basicprogramming.task.LazySingleton;
import basicprogramming.task.PropertiesHandler;
import basicprogramming.task.PropertiesReader;
import basicprogramming.task.Rainbow;
import basicprogramming.task.SingleCheckSingleton;
import basicprogramming.task.BillPughSingleton;
import basicprogramming.task.DoubleCheckSingleton;
import basicprogramming.task.EagerSingleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.nio.file.Path;
import java.time.ZoneId;
import util.CustomException;
import util.LoggerUtility;
import util.TimeUtil;
import util.UtilGetInput;

public class BasicProgrammingRunner {
	
	private static final Logger logger = LoggerUtility.getLogger(BasicProgrammingRunner.class , "/home/sakthi-pt7767/eclipse-workspace/Zoho_Tasks/LogFiles/BPLogs"); 

	public static void main(String[] args) {
		BasicProgrammingRunner runner = new BasicProgrammingRunner();
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
				logger.info("10. Run the operations on Singleton classes");
				logger.info("11. Run the operation on Time");
				logger.info("0. Terminate Program.");
				
				enteredChoice = UtilGetInput.getIntInput("Enter the choice of operation: ");
				
				 if (enteredChoice < 0 || enteredChoice > 12) {
					 logger.info("Invalid Choice, Enter a choice from 0 to 11");
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
					 
				 case 12:
					 testOnOffsets();
					 break;
					
				 case 0:
					 logger.info("Terminated Successfully!");
					 break;
					 
				 }
				
			} catch(CustomException e) {
				e.printStackTrace();
				logger.severe("An error occurred " + e.getMessage());
				logger.log(Level.SEVERE, "An exception occurred", e);
			}
		
		}
		while(enteredChoice!=0);
	}
	
	private void createTextFile() throws CustomException {
		int arrayCount = UtilGetInput.getIntInput("Enter the no.of Strings to add to the file: ");
		String[] inputArray = getArray(arrayCount);
		BasicProgrammingTask basicProgrammingTask = BasicProgrammingTask.getInstance();
		String fileName = UtilGetInput.getStringInput("Enter the file name to be created: ");
		Path filePath = basicProgrammingTask.createFileInDir(System.getProperty("user.dir") , fileName);
		logger.info(basicProgrammingTask.writeToFile(filePath.toString() , inputArray));
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
		BasicProgrammingTask basicProgrammingTask = BasicProgrammingTask.getInstance();
		Path filePath = basicProgrammingTask.createFileInDir(fileName, "Generated files");
		logger.info("Properties saved in file: " + propertiesHandler.saveToFile(filePath));
	}
	
	private void readPropertiesFile() throws CustomException {
		PropertiesReader reader = PropertiesReader.getInstance();
		String fileName = UtilGetInput.getStringInput("Enter the File name to read: ");
		reader.readFile(fileName);
	}
	
	private <T> void createFilesInDir() throws CustomException {
		PropertiesHandler propertiesHandler = PropertiesHandler.getInstance();
		
		int arrayCount = UtilGetInput.getIntInput("Enter the no.of Strings to add to the file: ");
		String[] inputArray = getArray(arrayCount);
		String filePath1 = getFilePath().toString();
		BasicProgrammingTask basicProgrammingTask = BasicProgrammingTask.getInstance();
		logger.info(basicProgrammingTask.writeToFile(filePath1 , inputArray));
		
		int pairCount = UtilGetInput.getIntInput("Enter the No. of pair values to add in the Property: ");
		for (int i = 0 ; i < pairCount ; i++) {
			String key = UtilGetInput.getStringInput("Enter key " + (i + 1) + ": ");
	        String value = UtilGetInput.getStringInput("Enter value for key " + key + ": ");
	        propertiesHandler.addProperty(key , value);
		}
		Path filePath2 = getFilePath();
		logger.info("Properties saved in file: " + propertiesHandler.saveToFile(filePath2));
		
		String fileName = UtilGetInput.getStringInput("Enter the File name to read: ");
		PropertiesReader reader = PropertiesReader.getInstance();
		reader.readFile(fileName);
	}
	
	private Path getFilePath() throws CustomException {
		logger.info(System.getProperty("user.home"));
		String dirName = UtilGetInput.getStringInput("Enter the Directory Name: ");
		String fileName = UtilGetInput.getStringInput("Enter the file name to create: ");
		BasicProgrammingTask basicProgrammingTask = BasicProgrammingTask.getInstance();
		return basicProgrammingTask.createFileInDir(dirName, fileName);
	}
	
	private void additionalCon() {
		String input = UtilGetInput.getStringInput("Enter a string to load the constructor: ");
		AdditionalConstructorClass additionalConstructorClass = new AdditionalConstructorClass(input);
		logger.info(additionalConstructorClass.toString());
	}
	
	private void invokingPOJOByConstructor() throws CustomException {
		String name = UtilGetInput.getStringInput("Enter the person name: ");
		int age = UtilGetInput.getIntInput("Enter the age of the person: ");
		Employee person = new Employee(name, age);
		logger.info(person.toString());
	}
	
	private void invokingPOJOByMethods() throws CustomException {
		Employee person = new Employee();
		String name = UtilGetInput.getStringInput("Enter the person name: ");
		person.setName(name);
		int age = UtilGetInput.getIntInput("Enter the age of the person: ");
		person.setAge(age);
		logger.info(person.toString());
	}
	
	private void invokingPOJODynamically() throws CustomException {
		try {
		    Class<?> pojoClass = Class.forName("pojoclass.Person");

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
		for (Rainbow color : Rainbow.values()) {
        	logger.info("Color: " + color + ", Color code: " + color.getColorCode());
        }
        
        logger.info("Ordinal values of each color:");
        for (Rainbow color : Rainbow.values()) {
        	logger.info(color + " has ordinal " + color.ordinal());
        }
	}
	
	private void runSingleton() {
		
		BillPughSingleton billPughSingleton1 = BillPughSingleton.getSingletonInstance();
        BillPughSingleton billPughSingleton2 = BillPughSingleton.getSingletonInstance();
        logger.info("Are both instances the same? " + (billPughSingleton1 == billPughSingleton2));
        billPughSingleton2.showMessage();
        
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        logger.info("Are both instances the same? " + (eagerSingleton1 == eagerSingleton2));
        eagerSingleton2.showMessage();
        
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        logger.info("Are both instances the same? " + (lazySingleton1 == lazySingleton2));
        eagerSingleton2.showMessage();
        
        SingleCheckSingleton singleCheckSingleton1 = SingleCheckSingleton.getInstance();
        SingleCheckSingleton singleCheckSingleton2 = SingleCheckSingleton.getInstance();
        logger.info("Are both instances the same? " + (singleCheckSingleton1 == singleCheckSingleton2));
        eagerSingleton2.showMessage();
        
        DoubleCheckSingleton doubleCheckSingleton1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton2 = DoubleCheckSingleton.getInstance();
        logger.info("Are both instances the same? " + (doubleCheckSingleton1 == doubleCheckSingleton2));
        eagerSingleton2.showMessage();
        
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        logger.info("Are both instances the same? " + (enumSingleton1 == enumSingleton2));
        eagerSingleton2.showMessage();
        
	}
	
	private void timeOperations() throws CustomException {
		
		String format = getTimeFormat();
		logger.info("Current Time with Date: " + TimeUtil.getCurrentTimeWithDate(format));

		logger.info("Current Time in Millis (Instant): " + TimeUtil.getCurrentTimeInMillis());
		logger.info("Current Time in Millis (System): " + TimeUtil.getCurrentTimeInMillisUsingSystem());

		String zoneId = getZoneID();
		String format1 = getTimeFormat();
		logger.info("Time in "+ zoneId + TimeUtil.getCurrentTimeInZone(zoneId , format1));
		

        long currentMillis = TimeUtil.getCurrentTimeInMillis();
        String zone = getZoneID(); 
        logger.info("Weekday: " + TimeUtil.getWeekdayFromMillis(currentMillis , zone));

        logger.info("Month: " + TimeUtil.getMonthFromMillis(currentMillis , zone));

        logger.info("Year: " + TimeUtil.getYearFromMillis(currentMillis , zone));
	}
	
	private void testOnOffsets() throws CustomException {
		String zoneId = getZoneID();
        String dateInput = UtilGetInput.getStringInput("Enter the date (yyyy-MM-dd): ");
        String offset = TimeUtil.getOffsetForZoneID(zoneId, dateInput);
        System.out.println("Time Zone: " + zoneId);
        System.out.println("UTC Offset: " + offset);
	}

	private String getZoneID() throws CustomException {
        List<String> availableZones = new ArrayList<>(ZoneId.getAvailableZoneIds());
        Collections.sort(availableZones);

        logger.info("The Available Time Zones are: ");
        for (int i = 0; i < availableZones.size(); i++) {
            System.out.printf("%3d. %s%n" , i + 1 , availableZones.get(i));
        }
        
        int choice = UtilGetInput.getIntInput("Enter the number corresponding to the desired time zone:\"");

        if (choice < 1 || choice > availableZones.size()) {
            throw new CustomException("Invalid choice.");
        } else {
            return availableZones.get(choice - 1);
        }
	}
	
	private String getTimeFormat() throws CustomException {
		List<String> formats = new ArrayList<>();
		formats.add("yyyy-MM-dd HH:mm:ss"); 
		formats.add("MM/dd/yyyy HH:mm:ss"); 
		formats.add("dd MMM yyyy HH:mm:ss"); 
		formats.add("yyyy-MM-dd HH:mm"); 
		
		System.out.println("Available Date-Time Formats:");
		for (int i = 0; i < formats.size(); i++) {
		    System.out.printf("%d. %s%n", i + 1, formats.get(i));
		}
		
		int choice = UtilGetInput.getIntInput("Enter the number corresponding to the desired date-time format: ");
		
		if (choice < 1 || choice > formats.size()) {
		    throw new CustomException("Invalid choice. Please run the program again with a valid number.");
		}
		return formats.get(choice - 1);
	}
	
	private String[] getArray(int count) {
		String[] array = new String[count];
		for (int i=0 ; i<count; i++) {
			array[i] = UtilGetInput.getStringInput("Enter the string value " + (i + 1) + " to add: ");
		}
		return array;
	}
}
		  
