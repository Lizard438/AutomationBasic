import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ProjectConfig;

import static core.WebDriverFactory.createDriver;

public class BaseTest {

    protected WebDriver driver;
    protected ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    @BeforeMethod
    public void setUp(ITestContext context){
        driver = createDriver(cfg.browser());
        driver.manage().window().maximize();
        context.setAttribute("WebDriver", driver);
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(driver != null){
            if(cfg.clearCookiesAndStorage()){
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
