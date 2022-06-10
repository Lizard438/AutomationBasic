import data.formuser.FormUser;
import data.formuser.FormUserDataFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.IOException;


public class FormTest extends BaseTest{
    FormPage form;

    @BeforeMethod
    public void init(){
        form = new FormPage(driver);
    }

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
    public void formTest() throws IOException {
        FormUser validUserData = FormUserDataFactory.createValidUser();
        fillForm(validUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form send with success");
    }

    @Test
    public void emptyFirstNameFormTest() throws IOException {
        FormUser emptyFirstNameUserData = FormUserDataFactory.createUserWithoutFirstName();
        fillForm(emptyFirstNameUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.firstNameIsMarkedInvalid());
    }

    @Test
    public void emptyProfessionFormTest() throws IOException {
        FormUser emptyProfessionUserData = FormUserDataFactory.createUserWithoutProfession();
        fillForm(emptyProfessionUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.professionIsMarkedInvalid());
    }

    @Test(enabled = false)
    public void ageBelowConstraintsFormTest() throws IOException {
        FormUser lowAgeUserData = FormUserDataFactory.createUserWithAgeBelow();
        fillForm(lowAgeUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.ageIsMarkedInvalid());
    }

    @Test
    public void invalidEmailFormTest() throws IOException {
        FormUser invalidEmailUserData = FormUserDataFactory.createUserWithInvalidEmail();
        fillForm(invalidEmailUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.emailIsMarkedInvalid());
    }

    @Test
    public void noFileFormTest(){
        FormUser noFileUserData = FormUserDataFactory.createUserWithoutFile();
        fillForm(noFileUserData)
                .submit();
        Assert.assertEquals(form.getResult(), "Form not send, please fill all missing form fields");
        Assert.assertTrue(form.fileInputIsMarkedInvalid());
    }

}
