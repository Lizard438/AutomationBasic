package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

import static utils.Screenshot.captureScreenshot;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        try{
            captureScreenshot(result);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
