package core;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ProjectConfig;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected ProjectConfig cfg;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        cfg = ConfigFactory.create(ProjectConfig.class,System.getProperties());
        wait = new WebDriverWait(driver, Duration.ofSeconds(cfg.seconds()));
    }

    protected void open(String url){
        driver.get(url);
    }

    public WebElement findElement(By element){
        return wait.until(driver -> driver.findElement(element));
    }

}
