package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablePage extends BasePage {
    private final By headerText = By.cssSelector("header>h1");
    public TablePage(WebDriver driver){
        super(driver);
    }

    @Step("Відкрити сторінку з таблицею")
    public TablePage open(){
        open(cfg.urlTable());
        return this;
    }

    @Step("Отримати текст заголовку сторінки з таблицею")
    public String getHeaderText(){
        return findElement(headerText).getText();
    }
    

}
