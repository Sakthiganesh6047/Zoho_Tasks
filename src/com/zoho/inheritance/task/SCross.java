package com.zoho.inheritance.task;

import com.zoho.util.printoutput.UtilPrintOutput;

public class SCross extends Car {
	
	private int noofseats;
	public void setNoOfSeats(int seats) {
		this.noofseats = seats;
	}
	public int getNoOfSeats() {
		return noofseats;
	}

	private int noofairbags;
	public void setNoOfAirbags(int airbags) {
		this.noofairbags = airbags;
	}
	public int getNoOfAirbags() {
		return noofairbags;
	}

	private String carmodel;
	public void setCarModel(String model) {
		this.carmodel = model;
	}
	public String getCarModel() {
		return carmodel;
	}
	
	private String carcolor;
	public void setCarColor(String color) {
		this.carcolor = color;
	}
	public String getCarColor() {
		return carcolor;
	}
	
	public void maintenance() {
		UtilPrintOutput.printOutput("Maruti SCross under Maintenance");
	}
	
}