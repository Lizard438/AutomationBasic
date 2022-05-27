package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver createDriver(String type){
        return WebDriverManager.getInstance(type).create();
    }
}
