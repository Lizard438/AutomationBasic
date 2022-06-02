package core;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ProjectConfig;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;

public class BasePage {

    protected WebDriver driver;
    protected ProjectConfig cfg;
    protected WebDriverWait wait;
    protected String url;

    public LinkedHashSet<String> handles;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        cfg = ConfigFactory.create(ProjectConfig.class,System.getProperties());
        wait = new WebDriverWait(driver, Duration.ofSeconds(cfg.seconds()));
        handles = new LinkedHashSet<>();
    }

    protected void open(String url){
        driver.get(url);
    }

    protected void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public WebElement findElement(By element){
        return wait.until(driver -> driver.findElement(element));
    }

    public String getTitle(){
        return driver.getTitle();
    }

    protected String getActiveHandle(){
        Set<String> current = driver.getWindowHandles();
        current.removeAll(handles);
        return current.iterator().next();
    }

    protected void windowBackUp(){
        String handle = driver.getWindowHandle();
        handles.add(handle);
    }

    public void closeCurrentWindow(){
        if (handles.isEmpty()){
            return;
        }
        String[] list = (String[]) handles.toArray();
        String previous = list[list.length-1];
        handles.remove(previous);
        driver.close();
        driver.switchTo().window(previous);
    }
}
