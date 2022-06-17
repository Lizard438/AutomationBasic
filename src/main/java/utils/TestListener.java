package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

import static utils.Screenshot.*;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        try{
            captureScreenshotToFile(result);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result){
        attachScreenshotToAllure(result);
    }

}
