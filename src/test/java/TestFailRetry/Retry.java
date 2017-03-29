package TestFailRetry;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by RXC8414 on 3/29/2017.
 */
public class Retry implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = 3;

    public boolean retry(ITestResult result){
        if(retryCount < maxRetryCount){
            retryCount++;
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public boolean blnPass(){
        int i = (Math.random() < 0.5)? 1:2;
        if(i == 1) return true;
        return false;
    }

    @Test(retryAnalyzer = Retry.class)
    public void testOne(){
        if(blnPass()){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    @Test(retryAnalyzer = Retry.class)
    public void testTwo(){
        if(blnPass()){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    @Test(retryAnalyzer = Retry.class)
    public void testThree(){
        if(blnPass()){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }
}
