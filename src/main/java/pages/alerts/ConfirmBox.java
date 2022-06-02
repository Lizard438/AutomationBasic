package pages.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmBox extends SimpleAlert{

    public ConfirmBox(WebDriver driver, Alert alert, By status){
        super(driver, alert, status);
    }

    public void dismiss(){
        alert.dismiss();
    }
}
