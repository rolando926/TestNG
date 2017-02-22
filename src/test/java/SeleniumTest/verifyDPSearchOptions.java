package SeleniumTest;

import Selenium.LandingPage;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by RXC8414 on 2/14/2017.
 */
public class verifyDPSearchOptions {

    LandingPage utils = new LandingPage();

    @BeforeClass
    public void setup(){
        //Navigate to THD
        Assert.assertTrue(utils.navigateURL("http://www.homedepot.com","searchBox"),"Error: Could not open THD home page.");

    }

    @Test(dataProvider = "multiData")
    public void verifyCanSearchItem(String item){

        //Enter strValue into search box and click search button
        Assert.assertTrue(utils.verifyCanSearchItems(item,"searchBox","headerSearchButton"),"Error: Could not find using search criteria successfully from Search Box.");
        //Wait until page displays strValue
        Assert.assertTrue(utils.verifyCorrectLandingPage(utils.getLandingPageXPath(item)),"Error: Could not verify landing page.");
    }

    @AfterMethod
    public void cleanUpTest(){
        //Return to Main Page
        Assert.assertTrue(utils.navigateURL("http://www.homedepot.com","searchBox"),"Error: Could not open THD home page.");
    }

    @DataProvider(name="multiData")
    public static Object[][] multiData(){
        return new Object[][] {
                {"hammer"},
                {"nail"},
                {"screwdriver"}
        };
    }

    @AfterClass
    public void cleanUp(){
        utils.closeDriver();
    }
}
