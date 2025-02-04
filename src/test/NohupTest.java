package test;

import java.util.logging.Logger;
import util.LoggerUtility;

public class NohupTest {
	
	private static final Logger logger = LoggerUtility.getLogger(NohupTest.class , "/home/sakthi-pt7767/eclipse-workspace/Zoho_Tasks/LogFiles/Test"); 
	
    public static void main(String[] args) {
    	int i = 1;
        while (true) {
            try {
            	//System.out.println("The program is running...iteration " + i);
                logger.info("The program is running...iteration " + i);
                i++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            	//System.out.println("The program was interrupted!");
            	logger.info("The program was interrupted!");
                break;
            }
        }
    }
}

