package pages.actions;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage {

    private final By source = By.id("draggable");
    private final By target = By.id("droppable");

    public DragAndDropPage(WebDriver driver){
        super(driver);
    }

    @Step("Відкрити сторінку DragAndDrop")
    public DragAndDropPage open(){
        open(cfg.urlDragAndDrop());
        return this;
    }

    @Step("Захопити прямокутник та перетягти у область")
    public DragAndDropPage dragAndDrop(){
        WebElement source = findElement(this.source);
        WebElement target = findElement(this.target);
        new Actions(driver).dragAndDrop(source, target).perform();
        return this;
    }

    @Step("Отримати повідомлення статусу")
    public String getStatus(){
        return findElement(target).findElement(By.tagName("p")).getText();
    }

}
