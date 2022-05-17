import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Form;

import static utils.config.SOME_FILE_PATH;

public class FormTest extends BaseTest{

    @Test
    public void formPositive(){
//        String mail = new TempMail(driver).open().getTempMail();
//        openNewTab();
        String mail = "ghvuvuy@gyvy.ughbi";
        Form form = new Form(driver).open();
        form.fillFirstName("Jules");
        form.fillLastName("Doe");
        form.fillEmail(mail);
        form.selectRandomSex();
        form.fillRandomAge(18, 40);
        form.selectRandomExperience();
        form.selectRandomProfessions();
        form.selectRandomContinent();
        form.selectSeleniumCommands(new String[]{"Switch Commands", "Wait Commands"});
        form.uploadFile(System.getProperty("user.home")+SOME_FILE_PATH);
        form.signIn();
        //Assert.assertTrue(form.isSuccess());
        Assert.assertEquals(form.getResult(), "Form send with success");

    }

}
