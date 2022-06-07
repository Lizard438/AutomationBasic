package pages.alerts;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleAlert extends BasePage {
    private final By status;

    protected Alert alert;

    public SimpleAlert(WebDriver driver, Alert alert, By status){
        super(driver);
        this.alert = alert;
        this.status = status;
    }

    public void accept(){
        alert.accept();
    }

    public String getStatus(){
        return findElement(status).getText();
    }


}
