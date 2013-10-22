package chapter10.section66;

import java.util.concurrent.TimeUnit;

public class StopThreadTestWithVolatileVar {


	private static volatile boolean stopFlag = false;

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable(){

			@Override
			public void run() {

				int i = 0;
				while(!stopFlag){
					i++;

					System.out.println("stopFlag :" + stopFlag);

				}
				System.out.println("stopFlag :" + stopFlag);
			}
			
		});
//		backgroundThread.setDaemon(true);
		backgroundThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		stopFlag = true;
		
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
