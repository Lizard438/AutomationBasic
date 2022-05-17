import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Form;
import pages.TempMail;

import static base.config.SOME_FILE_PATH;

public class FormTest extends BaseTest{

    @Test
    public void formPositive(){
        String mail = new TempMail(driver).open().getTempMail();
        openNewTab();
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
        Assert.assertTrue(form.isSuccess());

    }

}
