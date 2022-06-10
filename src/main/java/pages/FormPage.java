package pages;

import core.BasePage;
import data.formuser.FormUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class FormPage extends BasePage {

    private final By firstName = By.id("inputFirstName3");
    private final By lastName = By.id("inputLastName3");
    private final By email = By.id("inputEmail3");
    private final By gender = By.name("gridRadiosSex");
    private final By age = By.id("inputAge3");
    private final By experience = By.name("gridRadiosExperience");
    private final By profession = By.name("gridCheckboxProfession");
    private final By continents = By.id("selectContinents");
    private final By seleniumCommands = By.id("selectSeleniumCommands");
    private final By fileInput = By.id("chooseFile");
    private final By fileInputLabel = By.cssSelector("[for=chooseFile]");
    private final By additional = By.id("additionalInformations");
    private final By signInBtn = By.cssSelector(".btn-primary[type = \"submit\"]");
    private final By validatorMessage = By.cssSelector(".success#validator-message,.fail#validator-message");
    private final String invalidColor = cfg.formPageInvalidColor();


    public FormPage(WebDriver driver){
        super(driver);
    }

    public FormPage open(){
        open(cfg.urlForm());
        return this;
    }

    public FormPage fillFirstName(String firstName){
        findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public FormPage fillLastName(String lastName){
        findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public FormPage fillEmail(String email){
        findElement(this.email).sendKeys(email);
        return this;
    }

    public FormPage fillGender(FormUser.Gender gender){
        List<WebElement> checkboxes = findElements(this.gender);
        switch (gender){
            case MALE -> checkboxes.get(0).click();
            case FEMALE -> checkboxes.get(1).click();
            case OTHER -> checkboxes.get(2).click();
        }
        return this;
    }

    public FormPage fillAge(int age){
        findElement(this.age).sendKeys(Integer.toString(age));
        return this;
    }

    public FormPage fillExperience(int experience){
        findElements(this.experience).get(experience-1).click();
        return this;
    }

    public FormPage fillProfession(FormUser.Profession... professions){
        List<WebElement> checkboxes = findElements(this.profession);
        for(FormUser.Profession p : professions){
            switch (p){
                case MANUAL_TESTER -> checkboxes.get(0).click();
                case AUTOMATION_TESTER -> checkboxes.get(1).click();
                case OTHER -> checkboxes.get(2).click();
            }
        }
        return this;
    }

    public FormPage fillContinent(FormUser.Continent continent){
        Select continents = new Select(findElement(this.continents));
        continents.selectByVisibleText(continent.getValue());
        return this;
    }

    public FormPage fillCommands(FormUser.SeleniumCommands... seleniumCommands){
        Select commands = new Select(findElement(this.seleniumCommands));
        for(FormUser.SeleniumCommands c : seleniumCommands){
            commands.selectByValue(c.getValue());
        }
        return this;
    }

    public FormPage uploadFile(String path){
        if(!path.isEmpty()){
            findElement(fileInput).sendKeys(path);
        }
        return this;
    }

    public FormPage fillAdditionalInformation(String information){
        findElement(additional).sendKeys(information);
        return this;
    }

    public void submit(){
        findElement(signInBtn).click();
    }

    public String getResult(){
        return findElement(validatorMessage).getText();
    }

    public boolean firstNameIsMarkedInvalid(){
        return fieldMarkedInvalid(firstName);
    }

    public boolean lastNameIsMarkedInvalid(){
        return fieldMarkedInvalid(lastName);
    }

    public boolean emailIsMarkedInvalid(){
        return fieldMarkedInvalid(email);
    }

    public boolean genderIsMarkedInvalid(){
        return checkBoxesMarkedInvalid(findElements(gender));
    }

    public boolean ageIsMarkedInvalid(){
        return fieldMarkedInvalid(age);
    }

    public boolean experienceIsMarkedInvalid(){
        return checkBoxesMarkedInvalid(findElements(experience));
    }

    public boolean professionIsMarkedInvalid(){
        return checkBoxesMarkedInvalid(findElements(profession));
    }

    public boolean continentIsMarkedInvalid(){
        return fieldMarkedInvalid(continents);
    }

    public boolean commandsIsMarkedInvalid(){
        return fieldMarkedInvalid(seleniumCommands);
    }

    public boolean fileInputIsMarkedInvalid(){
        return fieldMarkedInvalid(fileInputLabel);
    }

    public boolean fieldMarkedInvalid(By selector){
        return wait.withTimeout(Duration.ofSeconds(2))
                .until(ExpectedConditions.attributeToBe(selector, "border-bottom-color", invalidColor ));
    }

    public boolean checkBoxesMarkedInvalid(List<WebElement> checkboxes){
        return checkboxes.stream().map(e ->
                e.findElement(By.xpath("./../label")).getCssValue("color").equals(invalidColor))
                .reduce((a,b)->a && b).orElseThrow();
    }

}
