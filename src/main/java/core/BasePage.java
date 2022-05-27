package core;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import utils.ProjectConfig;

public class BasePage {

    protected WebDriver driver;
    protected ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class,System.getProperties());

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void open(String url){
        driver.get(url);
    }
}
