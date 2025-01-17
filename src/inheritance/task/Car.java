package inheritance.task;

import java.util.logging.Logger;

public class Car {
	
	private static final Logger logger = Logger.getLogger(Car.class.getName());
	
	public Car(String message){
		logger.info(message);
	}
	
	public Car(){
	}
	
	private int yearOfmake;
	public void setYearOfMake(int year) {
		this.yearOfmake = year;
	}
	public int getYearOfMake() {
		return yearOfmake;
	}
	
	private String engineNumber;
	public void setEngineNumber(String enginenum) {
		this.engineNumber = enginenum;
	}
	public String getEngineNumber() {
		return engineNumber;
	}
	
	private String type;
	public void setType(String typeofcar) {
		this.type = typeofcar;
	}
	public String getType() {
		return type;
	}
	
	public void maintenance() {
		logger.info("Car under Maintenance");
	}
}





