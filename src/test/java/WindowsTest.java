import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TablePage;
import pages.windows.WindowPage;

public class WindowsTest extends BaseTest{
    private WindowPage baseWindowPage;

    @BeforeMethod
    public void init(){
        baseWindowPage = new WindowPage(driver);
    }

    @Test
    @Description("Натискання на кнопку, що відкриває нове вікно браузеру," +
            "перевірка відкриття нового вікна, закриття вікна, перевірка повернення на базову сторінку")
    public void newBrowserWindowTest() throws InstantiationException {
        TablePage newWindow = baseWindowPage
                .open()
                .clickNewBrowserWindow();
        Assert.assertEquals(newWindow.getHeaderText(), "Automation Pratice table");

        newWindow.close();
        Assert.assertEquals(baseWindowPage.getContentLabel(), "1) Browser Windows");
    }

    @Test
    @Description("Натискання на кнопку, що відкриває нове вікно з повідомленням," +
            "перевірка змісту повідомлення, закриття вікна, перевірка повернення на базову сторінку")
    public void newMessageWindowTest(){
        WindowPage.MessageWindow messageWindow = baseWindowPage
                .open()
                .clickNewMessageWindow();
        Assert.assertTrue(messageWindow.getText().contains("Knowledge"));

        messageWindow.close();
        Assert.assertEquals(baseWindowPage.getContentLabel(), "1) Browser Windows");
    }

    @Test
    @Description("Натискання на кнопку, що відкриває нову вкладку браузеру," +
            "перевірка відкриття нової вкладки, закриття вкладки, перевірка повернення на базову сторінку")
    public void newBrowserTabTest() throws InstantiationException {
        TablePage newTab = baseWindowPage
                .open()
                .clickNewBrowserTab();
        Assert.assertEquals(newTab.getHeaderText(), "Automation Pratice table");

        newTab.close();
        Assert.assertEquals(baseWindowPage.getContentLabel(), "1) Browser Windows");
    }

}
