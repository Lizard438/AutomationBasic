package pages.widgets;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SliderPage extends BasePage {

    private By handler = By.id("custom-handle");

    public SliderPage(WebDriver driver){
        super(driver);
    }

    public SliderPage open(){
        open(cfg.urlSlider());
        return this;
    }

    public void move(int percent){
        WebElement handler = findElement(this.handler);
        int parentWidth = handler.findElement(By.xpath("./..")).getRect().getWidth();
        double start = Double.parseDouble(handler.getCssValue("left").replace("px",""));
        double end = (double) ((percent - 1) * parentWidth) / 100.0;
        int offset = (int)Math.round(end-start);
        new Actions(driver).dragAndDropBy(handler, offset, 0).perform();
    }

    public int getValue(){
        return Integer.parseInt(findElement(handler).getText());
    }


}
