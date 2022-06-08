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

    public void fillAndSubmit(FormUser user){
        form.open()
                .fillFirstName(user.getFirstName())
                .fillLastName(user.getLastName())
                .fillEmail(user.getEmail())
                .fillGender(user.getGender())
                .fillAge(user.getAge())
                .fillExperience(user.getExperience())
                .fillProfession(user.getProfession())
                .fillContinent(user.getContinent())
                .fillCommands(user.getCommands())
                .uploadFile(user.getFilePath())
                .submit();
    }

    @Test
    public void formTest(){
        try {
            FormUser validUser = FormUserDataFactory.createValidUser();
            fillAndSubmit(validUser);
            Assert.assertEquals(form.getResult(), "Form send with success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
