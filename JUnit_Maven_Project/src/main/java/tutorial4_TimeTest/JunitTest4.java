package tutorial4_TimeTest;

import org.junit.*;

/**
 * JUnit TimeOut Test
 * @author mkyong
 *
 */
public class JunitTest4 {
 
	@Test(timeout = 1000)  
	public void infinity() { 
		int i=1;
		while (i<10000) {
			System.out.printf("-%04d",i);
			if( i % 20 ==0) {
				System.out.println("");
			}
			i++;
		}
	}  
 
}