package Annotations;

import org.junit.AfterClass;
import org.testng.annotations.*;

/**
 * Created by RXC8414 on 2/13/2017.
 */
public class AnnotationTwo {
    @BeforeTest
    public void beforeTest(){System.out.println("-Before Test Class Two");}

    @AfterClass
    public void afterClass(){System.out.println("--After Class");}

    @AfterMethod
    public void afterMethod(){System.out.println("---After Method");}

    @AfterTest
    public void afterTest(){System.out.println("-After Test");}

    @AfterSuite
    public void afterSuite(){System.out.println("After Suite");}

    @Test
    public void test(){System.out.println("----Test Class Two");}
}
