package inheritance.task;

import java.util.logging.Logger;

public class SCross extends Car {
	
	private static final Logger logger = Logger.getLogger(SCross.class.getName());
	
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
		logger.info("Maruti SCross under Maintenance");
	}
	
}