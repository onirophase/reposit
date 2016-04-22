package tutorial3_IgnoreTest;

import org.junit.*;

/**
 * JUnit Ignore Test
 * @author mkyong
 *
 */
public class JunitTest3 {
 
	@Ignore("Not Ready to Run")  
	@Test
	public void divisionWithException() {  
	  System.out.println("Method is not ready yet");
	}  
 
}