package basicprogramming.task;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeCar {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("car.ser"));
        CarSerialTest car = (CarSerialTest) in.readObject();
        in.close();
        car.display();
    }
}
