package Selenium;

/**
 * Created by RXC8414 on 2/15/2017.
 */
public class LandingPage extends MainPage{
    public boolean verifyCorrectLandingPage(String page){
        if(verifyLandingPage(page)){
            return true;
        }
        return false;
    }

    public String getLandingPageXPath(String item){
        switch (item.toLowerCase()){
            case "hammer":
                return "hammerLandingPage";
            case "nail":
                return "nailLandingPage";
            case "screwdriver":
                return "screwLandingPage";
            default:
                return "none";
        }
    }
}
