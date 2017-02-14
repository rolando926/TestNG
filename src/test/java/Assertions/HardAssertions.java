package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by RXC8414 on 2/14/2017.
 */
public class HardAssertions {

    @Test
    public void verifyDataProvider() throws Exception {

        Assert.assertEquals(1,1);
        Assert.assertEquals(true,true);
        Assert.assertEquals("Test1","Test");
    }

}
