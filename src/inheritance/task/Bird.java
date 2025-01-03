package inheritance.task;

import util.UtilPrintOutput;

public abstract class Bird {
	public abstract void fly();
	
	public void speak(){
		UtilPrintOutput.printOutput("The Bird is speaking");
	}
}