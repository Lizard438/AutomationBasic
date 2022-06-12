package pages.alerts;

import core.BasePage;
import io.qameta.allure.Step;
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

    @Step("Погодитися")
    public void accept(){
        alert.accept();
    }

    @Step("Перевірити статус")
    public String getStatus(){
        return findElement(status).getText();
    }


}
