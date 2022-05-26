package utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.config.SCREENSHOTS_DIR;

public class Screenshot {
    public static void captureScreenshot(ITestResult result) throws IOException {
        WebDriver driver = (WebDriver)result.getTestContext().getAttribute("WebDriver");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String directoryName = result.getInstanceName();
        String testName = result.getName();
        Date time = new Date(result.getEndMillis());
        String destName = getScreenshotDestName(directoryName,testName,time);

        File targetFile = new File(System.getProperty("user.dir")+SCREENSHOTS_DIR, destName);
        FileUtils.copyFile(screenshotFile, targetFile);
        try (FileInputStream fis = new FileInputStream(targetFile)) {
            Allure.addAttachment("Screenshot", fis);
        }
    }

    public static String getScreenshotDestName(String directoryName, String testName, Date time){
        SimpleDateFormat formatter = new SimpleDateFormat("yy_MM_dd_HHmmss");
        String timePart = formatter.format(time);
        String systemSeparator = System.getProperty("file.separator");
        return directoryName+systemSeparator+testName+timePart+".png";
    }
}
