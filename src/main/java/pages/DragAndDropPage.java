package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class DragAndDropPage extends BasePage {

    private By source = By.id("draggable");
    private By target = By.id("droppable");

    public DragAndDropPage(WebDriver driver){
        super(driver);
    }

    public DragAndDropPage open(){
        open(cfg.urlDragAndDrop());
        return this;
    }

    public DragAndDropPage dragAndDrop(){
        WebElement source = findElement(this.source);
        WebElement target = findElement(this.target);
        new Actions(driver).dragAndDrop(source, target).perform();
        return this;
    }

    public String getStatus(){
        return findElement(target).findElement(By.tagName("p")).getText();
    }

}
