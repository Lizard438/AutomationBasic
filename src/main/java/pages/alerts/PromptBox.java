package pages.alerts;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PromptBox extends ConfirmBox{
    public PromptBox(WebDriver driver, Alert alert, By status){
        super(driver, alert, status);
    }

    @Step("Ввести повідомлення {text}")
    public PromptBox type(String text){
        alert.sendKeys(text);
        return this;
    }
}
