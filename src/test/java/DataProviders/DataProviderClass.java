package DataProviders;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

/**
 * Created by RXC8414 on 2/14/2017.
 */
public class DataProviderClass {
    @DataProvider(name = "Iterator")
    public static Iterator<Object[]> getDataFromFileIterator() {
        return DPIterator.getFileData();

    }

    @DataProvider(name="multiData")
    public static Object[][] multiData(){
        return new Object[][] {
                {"Rolando","Rivera","rolando.rivera@weather.com"},
                {"Phillip","Whiters","phillip.whiters@weather.com"},
                {"Brian","Luksis","brian.luksis@weather.com"},
                {"Niki","Desur","niki.desur@weather.com"}
        };
    }
}
