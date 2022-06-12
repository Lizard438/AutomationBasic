
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.widgets.ProgressBarPage;

public class ProgressbarTest extends BaseTest {
    @Test
    @Description("Тестування очікування progressbar")
    public void progressbarTest(){
        ProgressBarPage progressbar = new ProgressBarPage(driver).open()
                .waitLoadingComplete();
        Assert.assertEquals(progressbar.getResult(), "Complete!");
    }
}
