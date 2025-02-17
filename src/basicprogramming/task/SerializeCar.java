package basicprogramming.task;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeCar {
	
    public static void main(String[] args) throws IOException {
        CarSerialTest car = new CarSerialTest("Suv", 5 , 5);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("car.ser"));
        out.writeObject(car);
        out.close();
    }
}
