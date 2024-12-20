package com.zoho.inheritance.task;

import com.zoho.util.printoutput.UtilPrintOutput;

public class Car {
	
	public Car(String message){
		UtilPrintOutput.printOutput(message);
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
		UtilPrintOutput.printOutput("Car under Maintenance");
	}
}





