
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.widgets.ProgressBarPage;

public class ProgressbarTest extends BaseTest {
    @Test
    public void progressbarTest(){
        ProgressBarPage progressbar = new ProgressBarPage(driver).open()
                .waitLoadingComplete();
        Assert.assertEquals(progressbar.getResult(), "Complete!");
    }
}
