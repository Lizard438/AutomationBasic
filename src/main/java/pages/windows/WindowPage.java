package pages.windows;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TablePage;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;


public class WindowPage extends BasePage {
    private final By newBrowserWindow = By.id("newBrowserWindow");
    private final By newMessageWindow = By.id("newMessageWindow");
    private final By newBrowserTab = By.id("newBrowserTab");
    private final By contentLabel = By.cssSelector(".content>h3");



    public WindowPage(WebDriver driver){
        super(driver);
        setUrl(cfg.urlWindows());
    }

    @Step("Відкрити сторінку з кнопками, що відкривають віконця")
    public WindowPage open(){
        open(getUrl());
        return this;
    }

    @Step("Натиснути на кнопку, що відкриває нове вікно браузеру")
    public TablePage clickNewBrowserWindow() throws InstantiationException {
        String newHandle = clickWindowOpeningButton(newBrowserWindow);
        return (TablePage) getPageObject(newHandle,TablePage.class);
    }

    @Step("Натиснути на кнопку, що відкриває нове вікно з повідомленням")
    public MessageWindow clickNewMessageWindow(){
        String newHandle = clickWindowOpeningButton(newMessageWindow);
        driver.switchTo().window(newHandle);
        return new MessageWindow(newHandle);

    }

    @Step("Натиснути на кнопку, що відкриває нову вкладку браузеру")
    public TablePage clickNewBrowserTab() throws InstantiationException {
        String newHandle = clickWindowOpeningButton(newBrowserTab);
        return (TablePage) getPageObject(newHandle,TablePage.class);
    }

    @Step("Натиснути на кнопку із селектором {button} і дочекатися відкриття віконця")
    private String clickWindowOpeningButton(By button){
        Set<String> handles = driver.getWindowHandles();
        findElement(button).click();
        wait.until(newWindowIsOpened(handles.size()));
        return getNewWindowHandle(handles);
    }

    @Step("Вказівка веб-драйверу вважати відкрите вікно активним і генерація об'єкту сторінки, що є інтерфейсом відкритого вікна")
    private BasePage getPageObject(String handle, Class<? extends BasePage> pageClass) throws InstantiationException {
        BasePage page = null;
        try {
            page = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new InstantiationException("Page object Instantiation error, please check page class constructor." +
                    " Original exception message: "+e.getMessage());
        }
        page.setHandles(handle, getHandle());
        page.makeActive();
        return page;
    }

    @Step("Отримати заголовок сторінки, відкритої у новому вікні/вкладці")
    public String getContentLabel(){
        return findElement(contentLabel).getText();
    }

    public class MessageWindow{
        By bodyLocator = By.tagName("body");
        String handle;

        public MessageWindow(String handle){
            this.handle = handle;
        }

        @Step("Отримати текст вікна-повідомлення")
        public String getText(){
            WebElement body = findElement(bodyLocator);
            return body.getText();
        }

        @Step("Закрити повідомлення")
        public void close(){
            driver.switchTo().window(this.handle);
            driver.close();
            makeActive();
        }
    }




}
