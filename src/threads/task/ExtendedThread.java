package threads.task;

public class ExtendedThread extends Thread {
	
	private int sleepTime = 6000;
	Boolean runningCondition = false;
	
	public ExtendedThread() {
	}
    
    public ExtendedThread(String name) {
        super(name);
    }
    
    public ExtendedThread(String name, int sleepTime) {
        super(name);
        this.sleepTime = sleepTime;
    }
    
    public synchronized void startRunning() {
    	runningCondition = true;
    }
    
    public synchronized void stopRunning() {
    	runningCondition = false;
    }
	
    @Override
    public void run() {
        System.out.println("[Inside run of Extended] Thread Name: " + Thread.currentThread().getName());
        System.out.println("[Inside run of Extended] Thread Priority: " + Thread.currentThread().getPriority());
        System.out.println("[Inside run of Extended] Thread State: " + Thread.currentThread().getState());
        
        System.out.println("Going to Sleep: " + this.getName());
	    try {
	        Thread.sleep(sleepTime);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    System.out.println("After sleeping: " + this.getName());
        
        while(runningCondition) {
		    System.out.println("Going to Sleep in while condition: " + this.getName());
		    try {
		        Thread.sleep(sleepTime);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		    System.out.println("After sleeping in while condition: " + this.getName());
        }
    }
}
