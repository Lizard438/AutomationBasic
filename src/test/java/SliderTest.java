import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.widgets.SliderPage;

public class SliderTest extends BaseTest{
    @Test
    @Description("Перетягування слайдеру і перевірка відображення позиції")
    public void sliderTest(){
        SoftAssert sa = new SoftAssert();
        int[] positions = new int[]{50, 80, 80, 20, 0};
        SliderPage slider = new SliderPage(driver).open();

        for (int pos : positions) {
            slider.move(pos);
            sa.assertEquals(slider.getValue(), pos);
        }
        sa.assertAll();
    }
}
