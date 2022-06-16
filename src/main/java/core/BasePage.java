package core;

import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ProjectConfig;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class BasePage {

    protected WebDriver driver;
    protected ProjectConfig cfg;
    protected WebDriverWait wait;
    protected String url;
    protected String handle;
    protected String parentHandle;


    protected BasePage(WebDriver driver){
        this.driver = driver;
        cfg = ConfigFactory.create(ProjectConfig.class,System.getProperties());
        wait = new WebDriverWait(driver, Duration.ofSeconds(cfg.seconds()));
    }

    public String getHandle(){
        return handle;
    }

    public void setHandle(String handle){
        this.handle = handle;
    }

    @Step("Перейти за посиланням {url}")
    protected void open(String url){
        driver.get(url);
        String active = driver.getWindowHandle();
        setHandle(active);

    }

    public void setParentHandle(String handle){
        parentHandle = handle;
    }

    public void setHandles(String handle, String parentHandle){
        this.handle = handle;
        this.parentHandle = parentHandle;
    }

    public void makeActive(){
        driver.switchTo().window(handle);
    }

    @Step("Зачинити поточне вікно/вкладку")
    public boolean close(){
        driver.switchTo().window(handle);
        driver.close();
        if(!parentHandle.isEmpty()){
            driver.switchTo().window(parentHandle);
            return true;
        }
        return false;
    }

    protected void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    @Step("Дочекатися появи елементу за локатором {locator}")
    public WebElement findElement(By locator){
        return wait.until(driver -> driver.findElement(locator));
    }

    @Step("Дочекатися появи елементів за локатором {locator}")
    public List<WebElement> findElements(By locator){
        return wait.until(driver -> driver.findElements(locator));
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getNewWindowHandle(Set<String> oldHandles){
        Set<String> remaining = driver.getWindowHandles();
        remaining.removeAll(oldHandles);
        if(!remaining.isEmpty()){
            return (String) remaining.toArray()[0];
        }
        throw new NoSuchElementException("No new windows was opened.");
    }

    @Step("Перевірити, чи відкрилося нове вікно/вкладка")
    public ExpectedCondition<Boolean> newWindowIsOpened(int before){
        return ExpectedConditions.numberOfWindowsToBe(before+1);
    }

}
