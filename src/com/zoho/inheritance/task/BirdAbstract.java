package com.zoho.inheritance.task;

import com.zoho.util.printoutput.UtilPrintOutput;

public abstract class BirdAbstract {

	public void fly(){
		UtilPrintOutput.printOutput("The Bird is Flying");
	}
	
	public void speak() {
		UtilPrintOutput.printOutput("The Bird is speaking");
	}
	
}
