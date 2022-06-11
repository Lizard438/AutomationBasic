import data.formuser.FormUser;
import data.formuser.FormUserDataFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.TestListener;

import java.io.IOException;

@Listeners({TestListener.class})
public class FormTest extends BaseTest{
    FormPage form;

    @BeforeMethod
    public void init(){
        form = new FormPage(driver);
    }

    @Step("Заповнити форму")
    public FormPage fillForm(FormUser user){
        return form.open()
                .fillFirstName(user.getFirstName())
                .fillLastName(user.getLastName())
                .fillEmail(user.getEmail())
                .fillGender(user.getGender())
                .fillAge(user.getAge())
                .fillExperience(user.getExperience())
                .fillProfession(user.getProfession())
                .fillContinent(user.getContinent())
                .fillCommands(user.getCommands())
                .fillAdditionalInformation(user.getAdditional())
                .uploadFile(user.getFilePath());
    }

    @Test
    @Description("Відправка форми із заповненням валідними даними")
    public void formTest() throws IOException {
        FormUser validUserData = FormUserDataFactory.createValidUser();
        fillForm(validUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form send with success");
    }

    @Test
    @Description("Усі поля, окрім FirstName заповнені валідними даними, поле FirstName залишене пустим. " +
            "Статус відправки має бути 'Form not send', поле FirstName підсвіченим червоним")
    public void emptyFirstNameFormTest() throws IOException {
        FormUser emptyFirstNameUserData = FormUserDataFactory.createUserWithoutFirstName();
        fillForm(emptyFirstNameUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.firstNameIsMarkedInvalid());
    }

    @Test
    @Description("Усі поля, окрім Професії заповнені валідними даними, жодний з чекбоксів Profession не вибраний. " +
            "Статус відправки має бути 'Form not send', підписи чекбоксів підсвічені червоним")
    public void emptyProfessionFormTest() throws IOException {
        FormUser emptyProfessionUserData = FormUserDataFactory.createUserWithoutProfession();
        fillForm(emptyProfessionUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.professionIsMarkedInvalid());
    }

    @Test(enabled = false)
    @Description("Усі поля, окрім віку заповнені валідними даними, у поле вік введене значення менше 18. " +
            "Метод є прикладом падаючого тесту, оскільки обмеження на вік є штучним")
    public void ageBelowConstraintsFormTest() throws IOException {
        FormUser lowAgeUserData = FormUserDataFactory.createUserWithAgeBelow();
        fillForm(lowAgeUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.ageIsMarkedInvalid());
    }

    @Test
    @Description("Усі поля, окрім Email заповнені валідними даними, у поле Email введене значення без символу '@'. " +
            "Статус відправки має бути 'Form not send', поле Email підсвіченим червоним")
    public void invalidEmailFormTest() throws IOException {
        FormUser invalidEmailUserData = FormUserDataFactory.createUserWithInvalidEmail();
        fillForm(invalidEmailUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.emailIsMarkedInvalid());
    }

    @Test
    @Description("Усі поля, заповнені валідними даними, але файл не завантажений. " +
            "Статус відправки має бути 'Form not send', область для завантаження файлу підсвічена червоним")
    public void noFileFormTest(){
        FormUser noFileUserData = FormUserDataFactory.createUserWithoutFile();
        fillForm(noFileUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.fileInputIsMarkedInvalid());
    }

}
