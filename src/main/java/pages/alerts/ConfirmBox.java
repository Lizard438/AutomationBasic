package pages.alerts;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmBox extends SimpleAlert{

    public ConfirmBox(WebDriver driver, Alert alert, By status){
        super(driver, alert, status);
    }

    @Step("Скасувати")
    public void dismiss(){
        alert.dismiss();
    }
}
