package chapter10.section66;


class GenerateNumRunnable implements Runnable{

	@Override
	public void run() {
		
		System.out.println(VolatileTest.generateNum());
	}
	
}
public class VolatileTest {

	private static volatile int index = 0;  
	
	static int generateNum(){
		++index;
		return ++index;
	}

	public static void main(String[] args) {
		for(int i = 0; i < 100; i++){
			new Thread(new GenerateNumRunnable()).start();
		}
		
	}

}
