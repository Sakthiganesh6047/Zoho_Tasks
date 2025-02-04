package threads.task.threadlocal;

public class ExampleB {
	void display() {
        System.out.println("Class B: Calling Class C’s method...");
        ExampleC exampleC = new ExampleC();
        exampleC.display();
    }
}
