import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actions.DragAndDropPage;
import pages.actions.SelectPage;
import pages.actions.SortingPage;

import java.util.Arrays;

public class ActionsTests extends BaseTest{

    @Test
    public void dragAndDropTest(){
        DragAndDropPage task = new DragAndDropPage(driver)
                .open().dragAndDrop();
        Assert.assertEquals(task.getStatus(), "Dropped!");
    }

    @Test
    public void selectTest(){
        int[] items = {1, 3, 4};
        SelectPage task = new SelectPage(driver)
                .open()
                .select(items);
        Assert.assertEquals(task.getResult(), items);
    }

    @Test
    public void sortingTest(){
        int[] order = {3,4,1,5,7,2,6};
        SortingPage task = new SortingPage(driver)
                .open()
                .sort(order);
        Assert.assertEquals(task.getResult(), order);
    }

}
