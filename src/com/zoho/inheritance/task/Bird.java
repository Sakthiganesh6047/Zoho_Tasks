package com.zoho.inheritance.task;

import com.zoho.util.printoutput.UtilPrintOutput;

public abstract class Bird {
	public abstract void fly();
	
	public void speak(){
		UtilPrintOutput.printOutput("The Bird is speaking");
	}
}