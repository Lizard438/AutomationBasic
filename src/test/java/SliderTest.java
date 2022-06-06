import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.widgets.SliderPage;

public class SliderTest extends BaseTest{
    @Test
    public void sliderTest(){
        SoftAssert sa = new SoftAssert();
        SliderPage slider = new SliderPage(driver).open();
        slider.move(50);
        sa.assertEquals(slider.getValue(), 50);
        slider.move(80);
        sa.assertEquals(slider.getValue(), 80);
        slider.move(80);
        sa.assertEquals(slider.getValue(), 80);
        slider.move(20);
        sa.assertEquals(slider.getValue(), 20);
        slider.move(0);
        sa.assertEquals(slider.getValue(), 0);
        sa.assertAll();
    }
}
