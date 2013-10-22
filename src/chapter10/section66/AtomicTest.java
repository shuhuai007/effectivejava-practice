package chapter10.section66;

import java.util.concurrent.atomic.AtomicLong;


class GenerateNumRunnable1 implements Runnable{

	@Override
	public void run() {
		
		System.out.println(AtomicTest.generateNum());
	}
	
}
public class AtomicTest {

	private static final AtomicLong index = new AtomicLong();  
	
	static long generateNum(){
		return index.getAndIncrement();
	}

	public static void main(String[] args) {
		for(int i = 0; i < 100; i++){
			new Thread(new GenerateNumRunnable1()).start();
		}
		
	}

}
