package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class TablePage extends BasePage {
    public TablePage(WebDriver driver){
        super(driver);
    }

    public TablePage open(){
        open(cfg.urlTable());
        return this;
    }

    

}
