package pages.actions;


import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

public class SelectPage extends BasePage {

    private final By itemsLocator = By.cssSelector("#selectable>li");
    private final By result = By.id("select-result");

    public SelectPage(WebDriver driver){
        super(driver);
    }

    @Step("Відкрити сторінку з елементом Select")
    public SelectPage open(){
        open(cfg.urlSelect());
        return this;
    }

    @Step("Обрати елементи {items} затиснувши клавішу CTRL")
    public SelectPage select(int... items){
        Actions commands = new Actions(driver);
        List<WebElement> list = findElements(itemsLocator);
        commands.keyDown(Keys.COMMAND);

        Arrays.stream(items).filter(i -> (i>0)&&(i<=6)).forEach(i-> commands.click(list.get(i-1)));
        commands.keyUp(Keys.COMMAND).perform();

        return this;
    }

    @Step("Перевірити повідомлення зі списком обраних елементів")
    public int[] getResult(){
        return Arrays.stream(findElement(result)
                .getText().split("#")).filter(s->!(s.isEmpty()))
                .mapToInt(s -> Integer.parseInt(s.trim())).toArray();
    }
}
