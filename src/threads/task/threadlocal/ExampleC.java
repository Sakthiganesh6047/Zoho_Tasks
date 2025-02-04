package threads.task.threadlocal;

import java.util.List;

public class ExampleC {
	void display() {
        List<Integer> list = ExampleA.threadLocalList.get();
        System.out.println("Class C: Printing ArrayList from Class A " + list);
    }
}
