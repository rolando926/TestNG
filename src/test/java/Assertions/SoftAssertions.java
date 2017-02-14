package Assertions;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by RXC8414 on 2/14/2017.
 */
public class SoftAssertions {
    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void softAssertTest() throws Exception{
        String expectedInteger[] = {"Integer","String","Double","Boolean"};

        List<String> expectedDataList = Arrays.asList(expectedInteger);

        softAssert.assertEquals("String","String1", "Error found: String do not match.");
        System.out.println("\nVerifying assertEquals.");
        softAssert.assertTrue(expectedDataList.contains(getDataType()),"Error: Incorrect data type found.");
        System.out.println("Verifying assertTrue.\n");
    }

    @AfterClass
    public void displayAsserts(){
        softAssert.assertAll();
    }


    public String getDataType(){
        String dataType;
        switch((int) (Math.random()*9)+1){
            case 1:
                dataType = "String";
                break;
            case 2:
                dataType = "Integer";
                break;
            case 3:
                dataType = "Double";
                break;
            case 4:
                dataType = "Boolean";
                break;
            case 5:
                dataType = "Char";
                break;
            case 6:
                dataType = "Long";
                break;
            case 7:
                dataType = "Short";
                break;
            case 8:
                dataType = "Byte";
                break;
            default:
                dataType = "Other";
                break;
        }

        System.out.println("Data Type = "+dataType);
        return dataType;
    }

}
