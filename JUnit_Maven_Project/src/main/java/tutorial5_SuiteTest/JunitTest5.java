package tutorial5_SuiteTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tutorial1_BasicTest.JunitTest1;
import tutorial2_ExpectedExceptionTest.JunitTest2;
import tutorial3_IgnoreTest.JunitTest3;
import tutorial4_TimeTest.JunitTest4;
 
/**
 * JUnit Suite Test
 * @author mkyong
 *
 */
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
        JunitTest1.class,
        JunitTest2.class,
        JunitTest3.class,
        JunitTest4.class
})
public class JunitTest5 {
}
