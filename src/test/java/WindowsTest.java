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
    public void newBrowserWindowTest(){
        TablePage newWindow = baseWindowPage
                .open()
                .clickNewBrowserWindow();
        Assert.assertEquals(newWindow.getHeaderText(), "Automation Pratice table");

        newWindow.close();
        Assert.assertEquals(baseWindowPage.getContentLabel(), "1) Browser Windows");
    }

    @Test
    public void newMessageWindowTest(){
        WindowPage.MessageWindow messageWindow = baseWindowPage
                .open()
                .clickNewMessageWindow();
        Assert.assertTrue(messageWindow.getText().contains("Knowledge"));

        messageWindow.close();
        Assert.assertEquals(baseWindowPage.getContentLabel(), "1) Browser Windows");
    }

    @Test
    public void newBrowserTabTest(){
        TablePage newTab = baseWindowPage
                .open()
                .clickNewBrowserTab();
        Assert.assertEquals(newTab.getHeaderText(), "Automation Pratice table");

        newTab.close();
        Assert.assertEquals(baseWindowPage.getContentLabel(), "1) Browser Windows");
    }

}
