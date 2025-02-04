package threads.task.threadlocal;

import java.util.ArrayList;
import java.util.List;

public class ExampleA {
	
	public static ThreadLocal<ArrayList<Integer>> threadLocalList = ThreadLocal.withInitial(() -> new ArrayList<>());

    public void display() {
        List<Integer> list = threadLocalList.get();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Class A: ArrayList initialized.");

        ExampleB exampleB = new ExampleB();
        exampleB.display();
    }
}
