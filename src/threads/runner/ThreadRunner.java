package threads.runner;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;

//import java.util.logging.Level;
//import java.util.logging.Logger;
import threads.task.ExtendedThread;
import threads.task.ThreadInRunnable;
import threads.task.threadlocal.ExampleA;
import util.CustomException;
//import util.LoggerUtility;
import util.UtilGetInput;

public class ThreadRunner {
	
	//private static final Logger logger = LoggerUtility.getLogger(ThreadRunner.class , "/home/sakthi-pt7767/eclipse-workspace/Zoho_Tasks/LogFiles/ThreadLogs");

	public static void main(String[] args) {
		 ThreadRunner runner = new ThreadRunner();
		 runner.runOperations();
    }
	
	private void runOperations() {
		int enteredChoice = 0;
		
		do {
			
			try {
				
				System.out.println("1. State of new Thread from Extended Thread class");
				System.out.println("2. State of new Thread from Runnable Thread class");
				System.out.println("3. Spawning Extended and Runnable Thread");
				System.out.println("4. Put in sleep for specified Time");
				System.out.println("5. Put in sleep each for entered Time");
				System.out.println("6. Taking 3 Thread Dumps");
				System.out.println("7. Taking 10 Thread Dumps.");
				System.out.println("8. Test on Thread Local.");
				System.out.println("0. Terminate Program.");
				
				enteredChoice = UtilGetInput.getIntInput("Enter the choice of operation: ");
				
				 if (enteredChoice < 0 || enteredChoice > 8) {
					 System.out.println("Invalid Choice, Enter a choice from 0 to 8");
				 }
				 
				 switch(enteredChoice) {
				 
				 case 1:
					 exercise1();
					 break;
					 
				 case 2:
					 exercise2();
					 break;
					 
				 case 3:
					 exercise3();
					 break;
					 
				 case 4:
					 exercise4();
					 break;
						 
				 case 5:
					 exercise5();
					 break;
					 
				 case 6:
					 exercise6();
					 break;
					 
				 case 7:
					 exercise7();
					 break;
					 
				 case 8:
					 threadLocalAdditional();
					 break;
					
				 case 0:
					 System.out.println("Terminated Successfully!");
					 break;
					 
				 }
				
			} catch(CustomException e) {
				System.out.println("An error occurred " + e.getMessage());
			}
		
		}
		while(enteredChoice!=0);
	}
	
	private void exercise1() {
		
		ExtendedThread extendedThread = new ExtendedThread();
		
		System.out.println("[Before start] Thread Name: " + extendedThread.getName());
        System.out.println("[Before start] Thread Priority: " + extendedThread.getPriority());
        System.out.println("[Before start] Thread State: " + extendedThread.getState());
        
        extendedThread.start();
        
        System.out.println("[After start] Thread Name: " + extendedThread.getName());
        System.out.println("[After start] Thread Priority: " + extendedThread.getPriority());
        System.out.println("[After start] Thread State: " + extendedThread.getState());
	}
	
	private void exercise2() {
		
		Thread runnableThread = new Thread(new ThreadInRunnable());
		
		System.out.println("[Before start] Thread Name: " + runnableThread.getName());
        System.out.println("[Before start] Thread Priority: " + runnableThread.getPriority());
        System.out.println("[Before start] Thread State: " + runnableThread.getState());
        
        runnableThread.start();
        
        System.out.println("[After start] Thread Name: " + runnableThread.getName());
        System.out.println("[After start] Thread Priority: " + runnableThread.getPriority());
        System.out.println("[After start] Thread State: " + runnableThread.getState());
		
	}
	
	
	private void exercise3() {
		
		//String extendedThreadName = UtilGetInput.getStringInput("Enter the name for Extended Thread: ");
		ExtendedThread extendedThread = new ExtendedThread("Extended Thread");
		//String runnableThreadName = UtilGetInput.getStringInput("Enter the name for Extended Thread: ");
		Thread runnableThread = new Thread(new ThreadInRunnable() , "Runnable Thread");
        
        System.out.println("[Before start] Thread Name: " + extendedThread.getName());
        System.out.println("[Before start] Thread Priority: " + extendedThread.getPriority());
        System.out.println("[Before start] Thread State: " + extendedThread.getState());
        
        extendedThread.start();
        
        System.out.println("[After start] Thread Name: " + extendedThread.getName());
        System.out.println("[After start] Thread Priority: " + extendedThread.getPriority());
        System.out.println("[After start] Thread State: " + extendedThread.getState());
        
        System.out.println("[Before start] Thread Name: " + runnableThread.getName());
        System.out.println("[Before start] Thread Priority: " + runnableThread.getPriority());
        System.out.println("[Before start] Thread State: " + runnableThread.getState());
        
        runnableThread.start();
        
        System.out.println("[After start] Thread Name: " + runnableThread.getName());
        System.out.println("[After start] Thread Priority: " + runnableThread.getPriority());
        System.out.println("[After start] Thread State: " + runnableThread.getState());
		
	}
	
	private void exercise4() throws CustomException {
		int extendedThreadCount = UtilGetInput.getIntInput("Enter the no. of threads to spawn: ");
		for ( int i=0 ; i < extendedThreadCount ; i++) {
			String extThreadName = UtilGetInput.getStringInput("Enter the Name of Thread-" + (i+1) );
			ExtendedThread extendedThread = new ExtendedThread(extThreadName);
			extendedThread.start();
		}
		
		int runnableThreadCount = UtilGetInput.getIntInput("Enter the no. of threads to spawn: ");
		for ( int i=0 ; i < runnableThreadCount ; i++) {
			String runnableThreadName = UtilGetInput.getStringInput("Enter the Name of Thread-" + i+1);
			Thread runnableThread = new Thread(new ThreadInRunnable() , runnableThreadName);
	        runnableThread.start();
		}
		
	}
	
	private void exercise5() throws CustomException {
		int extendedThreadCount = UtilGetInput.getIntInput("Enter the no. of threads to spawn: ");
		for ( int i=0 ; i < extendedThreadCount ; i++) {
			String extThreadName = UtilGetInput.getStringInput("Enter the Name of Thread-" + (i+1) + " :");
			int sleepTime = UtilGetInput.getIntInput("Enter the sleep time of the thread (in millis) : ");
			ExtendedThread extendedThread = new ExtendedThread(extThreadName , sleepTime);
			extendedThread.start();
		}
		
		int runnableThreadCount = UtilGetInput.getIntInput("Enter the no. of threads to spawn: ");
		for ( int i=0 ; i < runnableThreadCount ; i++) {
			String runnableThreadName = UtilGetInput.getStringInput("Enter the Name of Thread-" + (i+1) + " :");
			int sleepTime = UtilGetInput.getIntInput("Enter the sleep time (in millis) of the thread-" + (i+1) + " :");
			Thread runnableThread = new Thread(new ThreadInRunnable(sleepTime) , runnableThreadName);
	        runnableThread.start();
		}
	}
	
	private void exercise6() throws CustomException {
		try {
			
			//int threadCount = UtilGetInput.getIntInput("Enter the Count of the threads to spawn: ");
			ExtendedThread[] extendedThreads = new ExtendedThread[5];
	        ThreadInRunnable[] runnableThreads = new ThreadInRunnable[5];
	        Thread[] runnableThreadWrappers = new Thread[5];
	        
	        for (int i = 0; i < 5; i++) {
	        	//String runnableThreadName = UtilGetInput.getStringInput("Enter the Name of Thread-" + (i+1) + " :");
				//int sleepTime = UtilGetInput.getIntInput("Enter the sleep time (in mills) of the thread-" + (i+1) + " :");
				int sleepTime = 5000 * (i + 1);
	            extendedThreads[i] = new ExtendedThread("ExtendedThread-" + (i + 1), sleepTime);
	            extendedThreads[i].startRunning();;
	            extendedThreads[i].start();
	        }
	        
	        for (int i = 0; i < 5; i++) {
	        	//String runnableThreadName = UtilGetInput.getStringInput("Enter the Name of Thread-" + (i+1) + " :");
				//int sleepTime = UtilGetInput.getIntInput("Enter the sleep time (in mills) of the thread-" + (i+1) + " :");
	            int sleepTime = 5000 * (i + 1);
	            runnableThreads[i] = new ThreadInRunnable(sleepTime);
	            runnableThreadWrappers[i] = new Thread(runnableThreads[i] , "RunnableThread-" + (i + 1));
	            runnableThreads[i].startRunning();
	            runnableThreadWrappers[i].start();
	        }
	        
	        Thread.sleep(12000); // waiting time reduced to 12 sec
	        
	        for (int i = 0; i < 3; i++) {
	            System.out.println("\n===== THREAD DUMP " + (i + 1) + " =====");
	            threadDumpUsingMXBean();
	            System.out.println("=========================================");
	            Thread.sleep(10000);
	        }
	        
	        for (ExtendedThread et : extendedThreads) {
	            et.stopRunning();
	        }
	        for (ThreadInRunnable rt : runnableThreads) {
	            rt.stopRunning();
	        }
		} catch (InterruptedException e) {
			throw new CustomException("Error occured while executing Exercise 6!" , e);
		}
    }
	
	private void exercise7() throws CustomException {
		try {
			
			//int threadCount = UtilGetInput.getIntInput("Enter the Count of the threads to spawn: ");
			ExtendedThread[] extendedThreads = new ExtendedThread[5];
	        ThreadInRunnable[] runnableThreads = new ThreadInRunnable[5];
	        Thread[] runnableThreadWrappers = new Thread[5];
	        
	        for (int i = 0; i < 5; i++) {
	            int sleepTime = 5000 * (i + 1);
	            extendedThreads[i] = new ExtendedThread("ExtendedThread-" + (i + 1), sleepTime);
	            extendedThreads[i].startRunning();
	            extendedThreads[i].start();
	        }
	        
	        for (int i = 0; i < 5; i++) {
	            int sleepTime = 5000 * (i + 1);
	            runnableThreads[i] = new ThreadInRunnable(sleepTime);
	            runnableThreadWrappers[i] = new Thread(runnableThreads[i] , "ThreadInRunnable-" + (i + 1));
	            runnableThreads[i].startRunning();
	            runnableThreadWrappers[i].start();
	        }
	        
	        Thread.sleep(12000); //reducede
	        
	        for (int i = 0; i < 10; i++) {
	            System.out.println("\n===== THREAD DUMP " + (i + 1) + " using AllStackTraces =====");
	            getAllStackTracesThreadDump();
	            System.out.println("=========================================");
	            
	            System.out.println("\n===== THREAD DUMP " + (i + 1) + " using Group =====");
	            threadGroupDump();
	            System.out.println("=========================================");
	            
	            System.out.println("\n===== THREAD DUMP " + (i + 1) + " using MXBean =====");
	            threadDumpUsingMXBean();
	            System.out.println("=========================================");
	            
	            Thread.sleep(4500);
	        }
	        
	        for (int i = 0; i < 5; i++) {
	            extendedThreads[i].stopRunning();
	            System.out.println("Stopped: " + extendedThreads[i].getName());
	            Thread.sleep(6000);
	        }
	        for (int i = 0; i < 5; i++) {
	            runnableThreads[i].stopRunning();
	            System.out.println("Stopped: ThreadInRunnable-" + (i + 1));
	            Thread.sleep(6000);
	        }
	        
	        Thread.sleep(25000);
	        
	        boolean allStopped = true;
	        for (ExtendedThread et : extendedThreads) {
	            if (et.isAlive()) {
	                allStopped = false;
	                break;
	            }
	        }
	        for (Thread rt : runnableThreadWrappers) {
	            if (rt.isAlive()) {
	                allStopped = false;
	                break;
	            }
	        }
	        
	        if (allStopped) {
	            System.out.println("All threads exited. Tasks completed.");
	        }
	        
	        System.out.println("\n===== FINAL THREAD DUMP using AllStackTraces =====");
	        getAllStackTracesThreadDump();
            System.out.println("=========================================");
            
            System.out.println("\n===== FINAL THREAD DUMP using Group =====");
            threadGroupDump();
            System.out.println("=========================================");
            
            System.out.println("\n===== FINAL THREAD DUMP using MXBean =====");
            threadDumpUsingMXBean();
            System.out.println("=========================================");
	        
		} catch(InterruptedException e){
			throw new CustomException("Error occured while executing Exercise 7" , e);
		}
	}
	
	private void threadLocalAdditional() {
		ExampleA exampleA = new ExampleA();
		exampleA.display();
	}
	
	private void getAllStackTracesThreadDump() {
		Map<Thread, StackTraceElement[]> threadDump = Thread.getAllStackTraces();
        
        for (Map.Entry<Thread, StackTraceElement[]> entry : threadDump.entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] stackTrace = entry.getValue();
            
            System.out.println("Thread: " + thread.getName() + " | Thread State: " + thread.getState());
            for (StackTraceElement element : stackTrace) {
                System.out.println("\t" + element);
            }
        }
	}
	
	private void threadDumpUsingMXBean() {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		long[] threadIds = threadMXBean.getAllThreadIds();
		
		ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds, Integer.MAX_VALUE);
        
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("Thread ID: " + threadInfo.getThreadId() + " - " + threadInfo.getThreadName()+ " | Thread State: " + threadInfo.getThreadState());
            StackTraceElement[] stackTrace = threadInfo.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                System.out.println("\t" + element);
            }
        }
	}
	
	private void threadGroupDump() {
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		int activeThreadCount = group.activeCount();
	    Thread[] threads = new Thread[activeThreadCount];
	    group.enumerate(threads);
	    for (Thread thread : threads) {
	    	System.out.println("Thread: " + thread.getName()+ " | Thread State: " + thread.getState());
            for (StackTraceElement element : thread.getStackTrace()) {
            	System.out.println("\t" + element);
            }
        }
	}
}
















