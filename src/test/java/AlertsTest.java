import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.alerts.AlertsPage;
import pages.alerts.ConfirmBox;
import pages.alerts.PromptBox;
import pages.alerts.SimpleAlert;

public class AlertsTest extends BaseTest{

    private AlertsPage alertsPage;

    @BeforeMethod
    public void init(){
        alertsPage = new AlertsPage(driver);
    }

    @Test
    @Description("Підтвердження простого алерту")
    public void simpleAlertTest(){
        SimpleAlert alert = alertsPage
                            .open()
                            .clickSimpleAlert();
        alert.accept();
        Assert.assertEquals(alert.getStatus(), "OK button pressed");
    }

    @Test
    @Description("Підтвердження ConfirmBox")
    public void acceptConfirmBoxTest(){
        ConfirmBox alert = alertsPage
                            .open()
                            .clickConfirmBox();
        alert.accept();
        Assert.assertEquals(alert.getStatus(), "You pressed OK!");
    }

    @Test
    @Description("Скасування ConfirmBox")
    public void dismissConfirmBoxTest(){
        ConfirmBox alert = alertsPage
                            .open()
                            .clickConfirmBox();
        alert.dismiss();
        Assert.assertEquals(alert.getStatus(), "You pressed Cancel!");
    }

    @Test
    @Description("Ведення тексту у PromptBox")
    public void promptBoxTest(){
        PromptBox alert = alertsPage
                            .open()
                            .clickPromptBox();
        alert.type("Liza")
                        .accept();
        Assert.assertEquals(alert.getStatus(), "Hello Liza! How are you today?");
    }

    @Test
    @Description("Підтвердження алерту, що з'являється з затримкою")
    public void delayedAlertTest(){
        SimpleAlert alert = alertsPage
                            .open()
                            .clickDelayedAlert();
        alert.accept();
        Assert.assertEquals(alert.getStatus(), "OK button pressed");
    }
}
