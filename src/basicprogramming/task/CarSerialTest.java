package basicprogramming.task;

import java.io.Serializable;

public class CarSerialTest implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
//    private String model;
//    private int seats;
//
//    public CarSerialTest(String model, int seats) {
//        this.model = model;
//        this.seats = seats;
//    }
//    
//    public void display() {
//    	System.out.print("Car: " + model + seats);
//    }
    
    private String model;
    private int seats;
    private int doors;

    public CarSerialTest(String model, int seats , int doors) {
        this.model = model;
        this.seats = seats;
        this.doors = doors;
    }
    
    public void display() {
    	System.out.print("Car: " + "Model: " + model + "Seats: " + seats + "Doors: " + doors);
    }
}

