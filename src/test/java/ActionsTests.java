import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actions.DragAndDropPage;
import pages.actions.SelectPage;

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


}
