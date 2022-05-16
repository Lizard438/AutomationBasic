package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.runtime.model.StackTraceId;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

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
    List<WebElement> experienceRadios;

    @FindBy(name = "gridCheckboxProfession")
    List<WebElement> professionCheckboxes;

    @FindBy(id = "selectContinents")
    WebElement continent;

    @FindBy(id = "selectSeleniumCommands")
    WebElement seleniumCommands;

    @FindBy(id = "chooseFile")
    WebElement fileInput;

    @FindBy(css = "[for = 'chooseFile']")
    WebElement fileInputLabel;

    @FindBy(css = ".btn-primary[type = \"submit\"]")
    WebElement signInBtn;

    @FindBy(id = "validator-message")
    WebElement validatorMessage;

    private static final String URL = "https://seleniumui.moderntester.pl/form.php";

    private Random rnd = new Random();

    public Form(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Form open(){
        open(URL);
        return this;
    }

    public void fillFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void fillLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void fillEmail(String email){
        this.email.sendKeys(email);
    }

    private void clickRandomCheckbox(List<WebElement> checkboxes){
        checkboxes.get(rnd.nextInt(checkboxes.size())).click();
    }

    public void selectRandomSex(){
        clickRandomCheckbox(sexRadios);
    }

    public void fillAge(Integer age){
        this.age.sendKeys(age.toString());
    }

    public void fillRandomAge(int min, int max){
        Integer age = min + rnd.nextInt(max - min);
        fillAge(age);
    }

    public void selectRandomExperience(){
        clickRandomCheckbox(experienceRadios);
    }

    public void selectProfessionByIndex(int index){
        if(index < 0){
            index = 0;
        }else if ( index >= professionCheckboxes.size()){
            index = professionCheckboxes.size() -1;
        }
        professionCheckboxes.get(index).click();
    }

    public void selectProfession(String text){
        Optional<WebElement> option = professionCheckboxes.stream().filter(el -> Objects.equals(el.getText(), text)).findAny();
        option.ifPresent(WebElement::click);
    }

    public void selectRandomProfessions(){
        int code = rnd.nextInt(1 << professionCheckboxes.size());   //positions code ex: 5(int) -> 101(bin) -> choose 0 and 2 checkboxes(because 0 and 2 digits = 1)
        String pos = Integer.toBinaryString(code);
        for(int i = 0; i < pos.length(); i++){
            if(pos.charAt(i) == '1'){
                professionCheckboxes.get(i).click();
            }
        }

    }

    public void selectContinent(int index){
        Select continents = new Select(continent);
        continents.selectByIndex(index);
    }

    public void selectContinent(String text){
        Select continents = new Select(continent);
        continents.selectByVisibleText(text);
    }

    public void selectRandomContinent(){
        Select continents = new Select(continent);
        selectContinent(rnd.nextInt(continents.getOptions().size()));
    }

    public void selectSeleniumCommands(String[] values){
        Select commands = new Select(seleniumCommands);
        for (String value : values) {
            commands.selectByVisibleText(value);
        }
    }

    public void uploadFile(String path){
        fileInput.sendKeys(path);
        waitFileUpload();

    }

    private void waitFileUpload(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementValue(fileInputLabel, "Choose file...")));
    }

    public void signIn(){
        signInBtn.click();
    }

    public boolean isSuccess(){
        return validatorMessage.getText().equalsIgnoreCase("Form send with success");
    }

    public String getResult(){
        return validatorMessage.getText();
    }






}
