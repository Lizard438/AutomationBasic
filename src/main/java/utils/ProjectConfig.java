package utils;

import org.aeonbits.owner.Config;

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

    @Key("url.dragAndDrop")
    String urlDragAndDrop();

    @Key("url.select")
    String urlSelect();

    @Key("url.sorting")
    String urlSorting();

    @Key("url.slider")
    String urlSlider();

    @Key("url.progressbar")
    String urlProgressBar();

    @Key("colors.formpage.invalid")
    String formPageInvalidColor();

    String browser();

    @Key("clear.cookies.and.storage")
    Boolean clearCookiesAndStorage();

    @Key("screenshot.dir")
    String screenshotDir();

    int seconds();
}
