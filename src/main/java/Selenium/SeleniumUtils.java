package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by rrolando on 2/1/17.
 */
public class SeleniumUtils{
    public static WebDriver driver;

    public SeleniumUtils(){
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver";
        System.setProperty("webdriver.chrome.driver", "C:\\testng\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public boolean waitUntilElementDisplayed(String expression){
        int counter = 0;
        do {
            if (verifyDisplayed(expression)){
                return true;
            }
            else if (counter > 3){
                if(verifyEnabled(expression)){
                    return true;
                }

                else if (verifyLocation(expression)){
                    return true;
                }
            }

            counter++;
            try {
                TimeUnit.MILLISECONDS.sleep(950);
            }catch(Exception e){
                return false;
            }
        } while (counter < 10);

        return false;
    }

    public boolean verifyDisplayed(String expression){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            if (driver.findElement(By.xpath(expression)).isDisplayed()) {
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifyEnabled(String expression){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            if (driver.findElement(By.xpath(expression)).isEnabled()) {
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean verifyLocation(String expression){
        try{
            TimeUnit.MILLISECONDS.sleep(50);
            if(driver.findElement(By.xpath(expression)).getLocation().x < 0 ||
                    driver.findElement(By.xpath(expression)).getLocation().y < 0){
                return true;
            }
        }catch(Exception ne){
            return false;
        }
        return false;
    }

    public boolean navigateURL(String url, String element){
        driver.get(url);
        if(waitUntilElementDisplayed(PropertyHandler.getInstance().getValue(element))){
            return true;
        }
        return false;
    }

    public boolean addStringToTextBox(String strText, String element){
        try {
            if (waitUntilElementDisplayed(PropertyHandler.getInstance().getValue(element))) {
                driver.findElement(By.xpath(PropertyHandler.getInstance().getValue(element))).clear();
                driver.findElement(By.xpath(PropertyHandler.getInstance().getValue(element))).sendKeys(strText);
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean clickButton(String element){
        try{
            if(waitUntilElementDisplayed(PropertyHandler.getInstance().getValue(element))){
                driver.findElement(By.xpath(PropertyHandler.getInstance().getValue(element))).click();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean verifyLandingPage(String landingPage){
        try{
            if(waitUntilElementDisplayed(PropertyHandler.getInstance().getValue(landingPage))){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public String getPageText(String element){
        if(waitUntilElementDisplayed(PropertyHandler.getInstance().getValue(element))){
            return driver.findElement(By.xpath(PropertyHandler.getInstance().getValue(element))).getText();
        }
        return null;
    }

    public boolean closeWindows(String elementWin, String element, String landingPage){
        if(waitUntilElementDisplayed(PropertyHandler.getInstance().getValue(elementWin))){
            if(waitUntilElementDisplayed(PropertyHandler.getInstance().getValue(element))){
                driver.findElement(By.xpath(PropertyHandler.getInstance().getValue(element))).click();
                if(waitUntilElementDisplayed(PropertyHandler.getInstance().getValue(landingPage))){
                    return true;
                }
            }
        }
        return false;
    }

    public List<WebElement> getElements(String wrapper){
        try{
        List<WebElement> list = driver.findElements(By.xpath(PropertyHandler.getInstance().getValue(wrapper)));
        return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void waitSeconds(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public void clearField(WebElement element, String field){
        try{
            element.findElement(By.xpath(PropertyHandler.getInstance().getValue(field))).clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeDriver(){
        try{
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
