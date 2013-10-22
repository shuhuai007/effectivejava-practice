package chapter10.section67;

import java.util.ArrayList;

public class ConcurrentModificationExceptionTest {


	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>(10);
		for(int i = 0; i < 10; i++){
			al.add(i);
		}
		for(Integer i : al){
			System.out.println(i);
			al.remove(i);
		}
	}

}

/*
0
Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.AbstractList$Itr.checkForComodification(Unknown Source)
	at java.util.AbstractList$Itr.next(Unknown Source)
	at chapter10.section67.ConcurrentModificationExceptionTest.main(ConcurrentModificationExceptionTest.java:14)

 * 
 */
