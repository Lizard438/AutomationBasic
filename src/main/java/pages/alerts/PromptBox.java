package pages.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PromptBox extends ConfirmBox{
    public PromptBox(WebDriver driver, Alert alert, By status){
        super(driver, alert, status);
    }

    public PromptBox type(String text){
        alert.sendKeys(text);
        return this;
    }
}
