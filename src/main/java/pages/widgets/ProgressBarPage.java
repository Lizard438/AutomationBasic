package pages.widgets;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ProgressBarPage extends BasePage {
    private final By progressBar = By.id("progressbar");
    private final By label = By.className("progress-label");

    public ProgressBarPage(WebDriver driver){
        super(driver);
    }

    @Step("Відкрити сторінку з віджетом progressbar")
    public ProgressBarPage open(){
        open(cfg.urlProgressBar());
        return this;
    }

    @Step("Дочекатися завантаження progressbar до 100 відсотків")
    public ProgressBarPage waitLoadingComplete(){
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "100"));
        return this;
    }

    @Step("Перевірити надпис над progressbar")
    public String getResult(){
        return findElement(label).getText();
    }

}
