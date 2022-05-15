import base.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static base.config.BROWSER;
import static base.config.CLEAR_COOKIES_AND_STORAGE;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.createDriver(BROWSER);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        if(driver != null){
            if(CLEAR_COOKIES_AND_STORAGE){
                clearCookiesAndLocalStorage();
            }
            driver.quit();
        }
    }

    public void clearCookiesAndLocalStorage(){
        driver.manage().deleteAllCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.sessionStorage.clear()");
    }
}
