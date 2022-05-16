package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TempMail extends BasePage {

    @FindBy(id = "mail_address")
    private WebElement nameField;

    private static final  String URL = "https://10minutemail.com/";

    public TempMail(WebDriver driver){
        super(driver);
    }

    public TempMail open(){
        open(URL);
        return this;
    }

    public String getTempMail() {
        return (String) new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.jsReturnsValue("return $( '#mail_address' ).val();"));
    }

}
