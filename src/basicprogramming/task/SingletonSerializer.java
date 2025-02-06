package basicprogramming.task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonSerializer {
	
    public static void main(String[] args) throws Exception {
    	SerializableSingleton instance1 = SerializableSingleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        oos.writeObject(instance1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
        SerializableSingleton instance2 = (SerializableSingleton) ois.readObject();
        ois.close();

        System.out.println("Instance 1 HashCode: " + instance1.hashCode());
        System.out.println("Instance 2 HashCode: " + instance2.hashCode());
        System.out.println("Are both instances the same? " + (instance1 == instance2));
    }
}
