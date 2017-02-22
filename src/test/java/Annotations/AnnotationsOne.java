package Annotations;

import org.testng.annotations.*;

/**
 * Created by RXC8414 on 2/13/2017.
 */
public class AnnotationsOne {

    @BeforeSuite
    public void beforeSuite(){System.out.println("Before Suite Class One");}

    @BeforeTest
    public void beforeTest(){System.out.println("-Before Test Class One");}

    @BeforeClass
    public void beforeClass(){System.out.println("--Before Class Class One");}

    @BeforeMethod
    public void beforeMethod(){System.out.println("---Before Method Class One");}

    @Test
    public void test(){System.out.println("----Test Class One");}

    @AfterMethod
    public void afterMethod(){System.out.println("---After Method Class One");}
}
