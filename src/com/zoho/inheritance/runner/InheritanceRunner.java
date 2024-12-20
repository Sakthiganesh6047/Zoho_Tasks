package com.zoho.inheritance.runner;

import com.zoho.inheritance.task.*;
import com.zoho.util.getinput.UtilGetInput;
import com.zoho.util.printoutput.UtilPrintOutput;

public class InheritanceRunner{
	
	public static void main(String[] args){
		InheritanceRunner runner = new InheritanceRunner();
		runner.runOperations();
	}
	
	private void runOperations(){
		
		int enteredchoice = 0;
		Boolean condition = true;
		
		do {
			
			UtilPrintOutput.printOutput("Select an operation to perform");
			UtilPrintOutput.printOutput("1. Call the methods in swift class");
			UtilPrintOutput.printOutput("2. Call the methods using scross object");
			UtilPrintOutput.printOutput("3. Run the test on car object test method");
			UtilPrintOutput.printOutput("4. Run the Swift object test methods");
			UtilPrintOutput.printOutput("5. Run the maintenance method");
			UtilPrintOutput.printOutput("6. Test on constructor overload");
			UtilPrintOutput.printOutput("7. Test on abstract class");
			UtilPrintOutput.printOutput("8. Test on bird and duck classes");
			UtilPrintOutput.printOutput("0. Terminate Program");
			enteredchoice = UtilGetInput.getIntInput("Enter your choice: ");
			
			if(enteredchoice < 0 || enteredchoice > 9){
				UtilPrintOutput.printOutput("Invalid Choice, Enter a choice from 0 to 10");
			}
			
			switch(enteredchoice){
			case 1:
				callSwiftClass();
				break;
				
			case 2:
				callingusingScross();
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
				testonBirdDuck();
				break;
				
			case 0:
				UtilPrintOutput.printOutput("Terminated Successfully");
				condition = false;
				break;
			}
		
		}
		
		while(condition);
	
	}
	
	public void callSwiftClass(){
		Swift swift = new Swift();
		
		int noofseats = UtilGetInput.getIntInput("Enter no. of Seats: ");
		swift.setNoOfSeats(noofseats);
		UtilPrintOutput.printOutput("The no. of seats in the car is "  + swift.getNoOfSeats());
		
		int noofairbags = UtilGetInput.getIntInput("Enter no. of airbags: ");
		swift.setNoOfAirbags(noofairbags);
		UtilPrintOutput.printOutput("The no. of airbags in the car is "  + swift.getNoOfAirbags());
		
		String model = UtilGetInput.getStringInput("Enter the model of the car: ");
		swift.setCarModel(model);
		UtilPrintOutput.printOutput("The model of the car is "  + swift.getCarModel());
		
		String color = UtilGetInput.getStringInput("Enter the color of the car: ");
		swift.setCarColor(color);
		UtilPrintOutput.printOutput("The color of the car is "  + swift.getCarColor());
	}
	
	public void callingusingScross(){
		SCross scross = new SCross();
		
		int noofseats = UtilGetInput.getIntInput("Enter no. of Seats: ");
		scross.setNoOfSeats(noofseats);
		UtilPrintOutput.printOutput("The no. of seats in the car is "  + scross.getNoOfSeats());
		
		int noofairbags = UtilGetInput.getIntInput("Enter no. of airbags: ");
		scross.setNoOfAirbags(noofairbags);
		UtilPrintOutput.printOutput("The no. of airbags in the car is "  + scross.getNoOfAirbags());
		
		String model = UtilGetInput.getStringInput("Enter the model of the car: ");
		scross.setCarModel(model);
		UtilPrintOutput.printOutput("The model of the car is "  + scross.getCarModel());
		
		String color = UtilGetInput.getStringInput("Enter the color of the car: ");
		scross.setCarColor(color);
		UtilPrintOutput.printOutput("The color of the car is "  + scross.getCarColor());
		
		int yearofmake = UtilGetInput.getIntInput("Enter the year of make of the car: ");
		scross.setYearOfMake(yearofmake);
		UtilPrintOutput.printOutput("The year of make of the car is "  + scross.getYearOfMake());
		
		String enginenumber = UtilGetInput.getStringInput("Enter the Engine number");
		scross.setEngineNumber(enginenumber);
		UtilPrintOutput.printOutput("The engine number of the car is "  + scross.getEngineNumber());
		
		String cartype = UtilGetInput.getStringInput("Enter the car type: ");
		scross.setType(cartype);
		UtilPrintOutput.printOutput("The type of car is "  + scross.getType());
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
	
	public void testonBirdDuck(){
		Duck duck = new Duck();
		duck.fly();
		duck.speak();
	}
	
	public void identifyObject (Car carobject) {
		if (carobject instanceof Swift) {
			UtilPrintOutput.printOutput("Its a Hatch");
		}
			
		else if (carobject instanceof SCross) {
			UtilPrintOutput.printOutput("Its a sedan");
		}
		
		else if (carobject instanceof XUV) {
			UtilPrintOutput.printOutput("Its a SUV");
		}
	
	}
	
	public void testMethodOfSwift(Swift swiftobject) {
		UtilPrintOutput.printOutput("Method Invoked");
	}
	
	public void testMethod(Car carobject){
		UtilPrintOutput.printOutput("Method Invoked");
	}
	
	
}