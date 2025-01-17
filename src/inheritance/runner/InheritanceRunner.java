package inheritance.runner;

import java.util.logging.Logger;
import inheritance.task.Car;
import inheritance.task.Duck;
import inheritance.task.ParrotMod;
import inheritance.task.SCross;
import inheritance.task.Swift;
import inheritance.task.XUV;
import util.CustomException;
import util.UtilGetInput;

public class InheritanceRunner{
	
	private static final Logger logger = Logger.getLogger(InheritanceRunner.class.getName());
	
	public static void main(String[] args) throws CustomException {
		InheritanceRunner runner = new InheritanceRunner();
		runner.runOperations();
	}
	
	private void runOperations() throws CustomException  {
		
		int enteredchoice = 0;
		Boolean condition = true;
		
		do {
			
			logger.info("Select an operation to perform");
			logger.info("1. Call the methods in swift class");
			logger.info("2. Call the methods using scross object");
			logger.info("3. Run the test on car object test method");
			logger.info("4. Run the Swift object test methods");
			logger.info("5. Run the maintenance method");
			logger.info("6. Test on constructor overload");
			logger.info("7. Test on abstract class");
			logger.info("8. Test on bird and duck classes");
			logger.info("0. Terminate Program");
			enteredchoice = UtilGetInput.getIntInput("Enter your choice: ");
			
			if(enteredchoice < 0 || enteredchoice > 9){
				logger.info("Invalid Choice, Enter a choice from 0 to 10");
			}
			
			switch(enteredchoice){
			case 1:
				callSwiftClass();
				break;
				
			case 2:
				callingUsingScross();
				break;
				
			case 3:
				runTestMethod();
				break;
				
			case 4:
				swiftTestMethods();
				break;
				
			case 5:
				runMaintenance();
				break;
				
			case 6:
				constructorOverload();
				break;
				
			case 7:
				testOnBirdAbstract();
				break;
				
			case 8:
				testOnBirdDuck();
				break;
				
			case 0:
				logger.info("Terminated Successfully");
				condition = false;
				break;
			}
		
		}
		
		while(condition);
	
	}
	
	public void callSwiftClass() throws CustomException{
		Swift swift = new Swift();
		
		int noofseats = UtilGetInput.getIntInput("Enter no. of Seats: ");
		swift.setNoOfSeats(noofseats);
		logger.info("The no. of seats in the car is "  + swift.getNoOfSeats());
		
		int noofairbags = UtilGetInput.getIntInput("Enter no. of airbags: ");
		swift.setNoOfAirbags(noofairbags);
		logger.info("The no. of airbags in the car is "  + swift.getNoOfAirbags());
		
		String model = UtilGetInput.getStringInput("Enter the model of the car: ");
		swift.setCarModel(model);
		logger.info("The model of the car is "  + swift.getCarModel());
		
		String color = UtilGetInput.getStringInput("Enter the color of the car: ");
		swift.setCarColor(color);
		logger.info("The color of the car is "  + swift.getCarColor());
	}
	
	public void callingUsingScross() throws CustomException{
		SCross scross = new SCross();
		
		int noofseats = UtilGetInput.getIntInput("Enter no. of Seats: ");
		scross.setNoOfSeats(noofseats);
		logger.info("The no. of seats in the car is "  + scross.getNoOfSeats());
		
		int noofairbags = UtilGetInput.getIntInput("Enter no. of airbags: ");
		scross.setNoOfAirbags(noofairbags);
		logger.info("The no. of airbags in the car is "  + scross.getNoOfAirbags());
		
		String model = UtilGetInput.getStringInput("Enter the model of the car: ");
		scross.setCarModel(model);
		logger.info("The model of the car is "  + scross.getCarModel());
		
		String color = UtilGetInput.getStringInput("Enter the color of the car: ");
		scross.setCarColor(color);
		logger.info("The color of the car is "  + scross.getCarColor());
		
		int yearofmake = UtilGetInput.getIntInput("Enter the year of make of the car: ");
		scross.setYearOfMake(yearofmake);
		logger.info("The year of make of the car is "  + scross.getYearOfMake());
		
		String enginenumber = UtilGetInput.getStringInput("Enter the Engine number");
		scross.setEngineNumber(enginenumber);
		logger.info("The engine number of the car is "  + scross.getEngineNumber());
		
		String cartype = UtilGetInput.getStringInput("Enter the car type: ");
		scross.setType(cartype);
		logger.info("The type of car is "  + scross.getType());
	}
	
	public void runTestMethod() {
		Car car = new Car();
		Swift swift = new Swift();
		SCross scross = new SCross();
		XUV xuv = new XUV();
		testMethod(car);
		identifyObject(car);
		testMethod(swift);
		identifyObject(swift);
		testMethod(scross);
		identifyObject(scross);
		testMethod(xuv);
		identifyObject(xuv);
	}
	
	public void swiftTestMethods(){
		Swift swiftobj1 = new Swift();
		testMethodOfSwift(swiftobj1);
		Car swiftobj2 = new Swift();
		//testMethodOfSwift(swiftobj2);
		SCross scross = new SCross();
		XUV xuv = new XUV();
		//testMethodOfSwift(scross);
		//testMethodOfSwift(xuv);
	}
	
	public void runMaintenance(){
		SCross scross = new SCross();
		scross.maintenance();
		Car carscrossobj = new SCross();
		carscrossobj.maintenance();
		Car car = new Car();
		car.maintenance();
		Swift swift = new Swift();
		swift.maintenance();
	}
	
	public void constructorOverload(){
		XUV xuvobj1 = new XUV();
		//Car xuvobj2 = new XUV("instance of xuv using overloaded constructor");
	}
	
	public void testOnBirdAbstract(){
		ParrotMod birdobj = new ParrotMod();
		birdobj.fly();
		birdobj.speak();
	}
	
	public void testOnBirdDuck(){
		Duck duck = new Duck();
		duck.fly();
		duck.speak();
	}
	
	public void identifyObject (Car carobject) {
		if (carobject instanceof Swift) {
			logger.info("Its a Hatch");
		}
			
		else if (carobject instanceof SCross) {
			logger.info("Its a sedan");
		}
		
		else if (carobject instanceof XUV) {
			logger.info("Its a SUV");
		}
	
	}
	
	public void testMethodOfSwift(Swift swiftobject) {
		logger.info("Method Invoked");
	}
	
	public void testMethod(Car carobject){
		logger.info("Method Invoked");
	}
	
	
}