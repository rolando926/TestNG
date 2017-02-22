package Selenium;

import java.io.*;
import java.util.Properties;

/**
 * Created by rrolando on 2/1/17.
 */
public class PropertyHandler {
    private static PropertyHandler ourInstance = new PropertyHandler();
    Properties prop = new Properties();

    public static PropertyHandler getInstance() {
        return ourInstance;
    }

    private PropertyHandler() {
        readPropertiesFile();
    }

    private void readPropertiesFile(){
        try(InputStream in = PropertyHandler.class.getClassLoader().getResourceAsStream("elements.properties")){
            prop.load(in);
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public String getValue(String propKey){
        return this.prop.getProperty(propKey);
    }
}
