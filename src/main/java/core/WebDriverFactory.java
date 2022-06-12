package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    @Step("Створити об'єкт веб-драйверу {type}")
    public static WebDriver createDriver(String type){
        return WebDriverManager.getInstance(type).create();
    }
}
