package threads.task;

public class ThreadInRunnable implements Runnable{

	private int sleepTime = 4500;
	boolean runningCondition = false;
	
	public ThreadInRunnable() {
	}
	
	public ThreadInRunnable(int sleepTime) {
        this.sleepTime = sleepTime;
    }
	
	public synchronized void stopRunning() {
		runningCondition = false;
	}
	
	public synchronized void startRunning() {
		runningCondition = true;
	}
	
	
	@Override
    public void run() {
        System.out.println("[Inside run of Runnable] Thread Name: " + Thread.currentThread().getName());
        System.out.println("[Inside run of Runnable] Thread Priority: " + Thread.currentThread().getPriority());
        System.out.println("[Inside run of Runnable] Thread State: " + Thread.currentThread().getState());
        
        System.out.println("Going to Sleep: " + Thread.currentThread().getName());
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After sleeping: " + Thread.currentThread().getName());

        while(runningCondition) {
	        System.out.println("Going to Sleep in while condition: " + Thread.currentThread().getName());
	        try {
	            Thread.sleep(sleepTime);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("After sleeping in while condition: " + Thread.currentThread().getName());
        }
    }
}

