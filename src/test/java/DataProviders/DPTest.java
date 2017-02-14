package DataProviders;

import org.testng.annotations.Test;

/**
 * Created by RXC8414 on 2/14/2017.
 */
public class DPTest {
    int counter = 1;

    @Test(dataProvider = "multiData", dataProviderClass = DataProviderClass.class)
    public void verifyDataProviderObject(String strValue1, String strValue2, String strValue3) throws Exception {
        System.out.println("Test Execution"+counter+": "+strValue1+","+strValue2+","+strValue3);
        counter++;
    }

    @Test(dataProvider = "Iterator", dataProviderClass = DataProviderClass.class)
    public void verifyDataProviderIterator(String strValue){
        System.out.println("Test Execution"+counter+": "+strValue);
        counter++;
    }

}
