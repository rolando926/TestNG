package Selenium;

/**
 * Created by RXC8414 on 2/15/2017.
 */
public class MainPage extends SeleniumUtils{
    //static elements

    public boolean verifyCanSearchItems(String item, String searchBox, String button){
        if(addStringToTextBox(item,searchBox)){
            if(clickButton(button)){
                return true;
            }
        }
        return false;
    }
}
