package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablePage extends BasePage {
    private final By headerText = By.cssSelector("header>h1");
    public TablePage(WebDriver driver){
        super(driver);
    }

    public TablePage open(){
        open(cfg.urlTable());
        return this;
    }

    public String getHeaderText(){
        return findElement(headerText).getText();
    }
    

}
