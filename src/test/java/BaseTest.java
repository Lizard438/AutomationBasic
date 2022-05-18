import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static base.WebDriverFactory.createDriver;
import static utils.config.BROWSER;
import static utils.config.CLEAR_COOKIES_AND_STORAGE;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext context){
        driver = createDriver(BROWSER);
        driver.manage().window().maximize();
        context.setAttribute("WebDriver", driver);
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(driver != null){
            if(CLEAR_COOKIES_AND_STORAGE){
                clearCookiesAndLocalStorage();
            }
            driver.quit();
        }
    }

    public void openNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void clearCookiesAndLocalStorage(){
        driver.manage().deleteAllCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.sessionStorage.clear()");
    }


}
