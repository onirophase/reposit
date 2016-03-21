package tutorial1_BasicTest;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/**
 * @author mkyong - petit test à ma façon
 * http://www.mkyong.com/unittest/junit-4-tutorial-1-basic-usage/
 */
public class JunitTest1 {
	@SuppressWarnings("unused")
	private void initializationError() {
		// TODO Auto-generated method stub

	}
	private Collection<String> collection;

	@BeforeClass
	public static void oneTimeSetUp() {
		// one-time initialization code   
		System.out.println("@BeforeClass - oneTimeSetUp");
	}

	@AfterClass
	public static void oneTimeTearDown() {
		// one-time cleanup code
		System.out.println("@AfterClass - oneTimeTearDown");
	}

	@Before
	public void setUp() {
		collection = new ArrayList<String>();
		System.out.println("@Before - setUp");
	}

	@After
	public void tearDown() {
		collection.clear();
		System.out.println("@After - tearDown");
	}

	@Test
	public void testEmptyCollection() {
		assertTrue(collection.isEmpty());
		System.out.println("@Test - testEmptyCollection");
	}

	@Test
	public void testOneItemCollection() {
		collection.add("itemA");
		assertEquals(1, collection.size());
		System.out.println("@Test - testOneItemCollection");
	}
}