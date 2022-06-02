import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TablePage;
import pages.alerts.AlertsPage;
import pages.windows.WindowPage;

public class WindowsTest extends BaseTest{
    WindowPage baseWindowPage;

    @BeforeMethod
    public void init(){
        baseWindowPage = new WindowPage(driver);
    }

    @Test
    public void windowsTest(){
        TablePage opened = baseWindowPage.open().clickNewBrowserWindow();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(opened.getHeaderText(), "Automation Pratice table");
        System.out.println(driver.getWindowHandles());
        System.out.println(opened.handles.size());
        opened.closeCurrentWindow();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), baseWindowPage.getUrl());
    }
}
