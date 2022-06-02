package utils;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.aeonbits.owner.Config;
import org.openqa.selenium.support.ui.WebDriverWait;

@Config.Sources({"file:src/main/resources/ProjectConfig.properties"})
public interface ProjectConfig extends Config {
    @Key("url.form")
    String urlForm();

    @Key("url.alerts")
    String urlAlerts();

    @Key("url.table")
    String urlTable();

    @Key("url.windows")
    String urlWindows();

    String browser();

    @Key("clear.cookies.and.storage")
    Boolean clearCookiesAndStorage();

    @Key("random.file.path")
    String randomFilePath();

    @Key("screenshot.dir")
    String screenshotDir();

    int seconds();
}
