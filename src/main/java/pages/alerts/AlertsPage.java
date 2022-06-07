package pages.alerts;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    private final By simple = By.id("simple-alert");
    private final By simpleStatus = By.id("simple-alert-label");
    private final By prompt = By.id("prompt-alert");
    private final By promptStatus = By.id("prompt-label");
    private final By confirm = By.id("confirm-alert");
    private final By confirmStatus = By.id("confirm-label");
    private final By delayed = By.id("delayed-alert");
    private final By delayedStatus = By.id("delayed-alert-label");


    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage open(){
        open(cfg.urlAlerts());
        return this;
    }

    public SimpleAlert clickSimpleAlert(){
        findElement(simple).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return new SimpleAlert(driver, alert, simpleStatus);
    }

    public PromptBox clickPromptBox(){
        findElement(prompt).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return new PromptBox(driver, alert, promptStatus);
    }

    public ConfirmBox clickConfirmBox(){
        findElement(confirm).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return new ConfirmBox(driver, alert, confirmStatus);
    }

    public SimpleAlert clickDelayedAlert(){
        findElement(delayed).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return new SimpleAlert(driver, alert, delayedStatus);
    }

}
