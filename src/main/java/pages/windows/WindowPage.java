package pages.windows;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TablePage;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class WindowPage extends BasePage {
    private By newBrowserWindow = By.id("newBrowserWindow");
    private By newMessageWindow = By.id("newMessageWindow");
    private By newBrowserTab = By.id("newBrowserTab");



    public WindowPage(WebDriver driver){
        super(driver);
        setUrl(cfg.urlWindows());
    }

    public WindowPage open(){
        open(getUrl());
        return this;
    }

    public TablePage clickNewBrowserWindow(){
        windowBackUp();
        findElement(newBrowserWindow).click();
        String active = getActiveHandle();
        System.out.println(active + "active");
        System.out.println(handles.size() + "size when click new wind");
        driver.switchTo().window(active);
        return new TablePage(driver);
    }




}
