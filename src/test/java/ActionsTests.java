import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class ActionsTests extends BaseTest{

    @Test
    public void dragAndDropTest(){
        DragAndDropPage task = new DragAndDropPage(driver)
                .open().dragAndDrop();
        Assert.assertEquals(task.getStatus(), "Dropped!");
    }
}
