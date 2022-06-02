package pages.alerts;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    private By simple = By.id("simple-alert");
    private By simpleStatus = By.id("simple-alert-label");
    private By prompt = By.id("prompt-alert");
    private By promptStatus = By.id("prompt-label");
    private By confirm = By.id("confirm-alert");
    private By confirmStatus = By.id("confirm-label");
    private By delayed = By.id("delayed-alert");
    private By delayedStatus = By.id("delayed-alert-label");


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
