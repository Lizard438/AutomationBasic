package pages.actions;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.LinkedList;

public class SortingPage extends BasePage {

    private final By itemsLocator = By.cssSelector("#sortable>li");

    public SortingPage(WebDriver driver){
        super(driver);
    }

    public SortingPage open(){
        open(cfg.urlSorting());
        return this;
    }

    public SortingPage sort(int[] order){
        LinkedList<WebElement> items = new LinkedList<>(findElements(itemsLocator));
        int[] positions = items.stream().mapToInt(i->i.getLocation().getY()).toArray();
        HashMap<Integer,WebElement> orderMap = new HashMap<>();
        for(int i = 0; i<order.length; i++){
            orderMap.put(i, items.get(i));
        }

        Actions commands = new Actions(driver);
        for(int i = 0; i<order.length-1; i++){
            int pos = items.indexOf(orderMap.get(order[i] - 1));
            int offset = positions[i] - positions[pos] - 2;
            WebElement element = orderMap.get(order[i] - 1);
            commands.dragAndDropBy(element, 0,offset);
            items.remove(element);
            items.add(i, element);
        }

        commands.perform();
        return this;
    }

    public int[] getResult(){
        return findElements(itemsLocator).stream().mapToInt(e ->
            Integer.parseInt(e.getText().replace("Item ", ""))
        ).toArray();
    }
}
