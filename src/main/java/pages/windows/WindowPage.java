package pages.windows;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Form;
import pages.TablePage;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;


public class WindowPage extends BasePage {
    private By newBrowserWindow = By.id("newBrowserWindow");
    private By newMessageWindow = By.id("newMessageWindow");
    private By newBrowserTab = By.id("newBrowserTab");
    private By contentLabel = By.cssSelector(".content>h3");



    public WindowPage(WebDriver driver){
        super(driver);
        setUrl(cfg.urlWindows());
    }

    public WindowPage open(){
        open(getUrl());
        return this;
    }

    public TablePage clickNewBrowserWindow(){
        String newHandle = clickWindowOpeningButton(newBrowserWindow);
        return (TablePage) getPageObject(newHandle,TablePage.class);
    }

    public MessageWindow clickNewMessageWindow(){
        String newHandle = clickWindowOpeningButton(newMessageWindow);
        driver.switchTo().window(newHandle);
        return new MessageWindow(newHandle);

    }

//    public TablePage clickNewBrowserTab(){
//        String newHandle = clickWindowOpeningButton(newBrowserTab);
//        getPageObject(newHandle, TablePage.class);
//        getPageObject(newHandle, Form.class);
//
//    }

    public String clickWindowOpeningButton(By button){
        Set<String> handles = driver.getWindowHandles();
        findElement(button).click();
        wait.until(newWindowIsOpened(handles.size()));
        return getNewWindowHandle(handles);
    }

    private BasePage getPageObject(String handle, Class<? extends BasePage> pageClass) {
        BasePage page = null;
        try {
            page = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            page = new TablePage(driver);
        }
        page.setHandles(handle, getHandle());
        page.makeActive();
        return page;
    }

    public String getContentLabel(){
        return findElement(contentLabel).getText();
    }

    public class MessageWindow{
        By bodyLocator = By.tagName("body");
        String handle;

        public MessageWindow(String handle){
            this.handle = handle;
        }

        public String getText(){
            WebElement body = findElement(bodyLocator);
            return body.getText();
        }

        public void close(){
            driver.switchTo().window(this.handle);
            driver.close();
            makeActive();
        }
    }




}
