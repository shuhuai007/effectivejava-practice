package chapter10.section66;

import java.util.concurrent.TimeUnit;

public class StopThreadTestWithSynchronizedFun {


	private static boolean stopFlag = false;
	private static synchronized void setFlag(){
		stopFlag = true;
	}
	private static synchronized boolean getFlag(){
		return stopFlag;
	}
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable(){

			@Override
			public void run() {

				int i = 0;
				while(!getFlag()){
					i++;

					System.out.println("stopFlag :" + getFlag());

				}
				System.out.println("stopFlag :" + getFlag());
			}
			
		});
//		backgroundThread.setDaemon(true);
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		setFlag();
		
	}

}
/*output:
stopFlag :false
stopFlag :false
stopFlag :false
stopFlag :false
stopFlag :false
stopFlag :false
stopFlag :false
stopFlag :false
stopFlag :false
stopFlag :false
...... 
...... 
...... 
stopFlag :true
 * 
 */
