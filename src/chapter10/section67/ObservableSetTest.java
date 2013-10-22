package chapter10.section67;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableSetTest {

	public static void main(String[] args) {
		ObservableSet<Integer> set = new ObservableSet<Integer>(new HashSet<Integer>());
		
		
		/*
		 * version 1
		 
		set.addObserver(new SetObserver<Integer>(){

			@Override
			public void added(ObservableSet<Integer> set, Integer element) {
				System.out.println(element);
			}
			
		});
		*/
		
		
		/*
		 *  version 2===造成异常
		set.addObserver(new SetObserver<Integer>(){

			@Override
			public void added(ObservableSet<Integer> set, Integer element) {
				System.out.println(element);
				if (element == 23){
					set.removeObserver(this);
				}
			}
			
		});
		 */

		//version 3  ===造成死锁
		set.addObserver(new SetObserver<Integer>(){

			@Override
			public void added(final ObservableSet<Integer> set, Integer element) {
				System.out.println(element);
				if (element == 23){
//					set.removeObserver(this);
					ExecutorService executor = Executors.newCachedThreadPool();
					
					final SetObserver<Integer> observer = this;
					try {
						executor.submit(new Runnable(){

							@Override
							public void run() {
								set.removeObserver(observer);							
							}
						
						}).get();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally{
						executor.shutdown();
					}
				}
			}
			
		});
		
		for(int i = 0; i < 100; i++){
			set.add(i);
			System.out.println("now the i :" + i);
			
		}
		System.out.println("in the last of main()");
	}

}
