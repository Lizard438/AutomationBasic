package pages.widgets;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SliderPage extends BasePage {

    private final By handler = By.id("custom-handle");

    public SliderPage(WebDriver driver){
        super(driver);
    }

    @Step("Відкрити сторінку з віджетом Slider")
    public SliderPage open(){
        open(cfg.urlSlider());
        return this;
    }

    @Step("Перетягнути слайдер у позицію {percent} відсотків")
    public void move(int percent){
        WebElement handler = findElement(this.handler);
        int parentWidth = handler.findElement(By.xpath("./..")).getRect().getWidth();
        double start = Double.parseDouble(handler.getCssValue("left").replace("px",""));
        double end = (double) ((percent - 1) * parentWidth) / 100.0;
        int offset = (int)Math.round(end-start);
        new Actions(driver).dragAndDropBy(handler, offset, 0).perform();
    }

    @Step("Перевірити значення позиції, відображене на надписі")
    public int getValue(){
        return Integer.parseInt(findElement(handler).getText());
    }


}
