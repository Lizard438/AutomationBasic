package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Form extends BasePage {

    @FindBy(id = "inputFirstName3")
    WebElement firstName;

    @FindBy(id = "inputLastName3")
    WebElement lastName;

    @FindBy(id = "inputEmail3")
    WebElement email;

    @FindBy(name = "gridRadiosSex")
    List<WebElement> sexRadios;

    @FindBy(id = "inputAge3")
    WebElement age;

    @FindBy(name = "gridRadiosExperience")
    List<WebElement> expertiseRadios;

    @FindBy(name = "gridCheckboxProfession")
    List<WebElement> professionCheckboxes;

    @FindBy(id = "selectContinents")
    WebElement continent;

    @FindBy(id = "selectSeleniumCommands")
    WebElement seleniumCommands;

    @FindBy(id = "chooseFile")
    WebElement fileInput;

    private static final String URL = "https://seleniumui.moderntester.pl/form.php";

    public Form(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(){
        open(URL);
    }


}
