import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actions.DragAndDropPage;
import pages.actions.SelectPage;
import pages.actions.SortingPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ActionsTests extends BaseTest{

    @Test
    @Description("Тестування можливості перетягування об'єкту у область")
    public void dragAndDropTest(){
        DragAndDropPage task = new DragAndDropPage(driver)
                .open().dragAndDrop();
        Assert.assertEquals(task.getStatus(), "Dropped!");
    }

    @Test
    @Description("Тестування багатоваріантного вибору")
    public void selectTest(){
        int[] items = {1, 3, 4};
        SelectPage task = new SelectPage(driver)
                .open()
                .select(items);
        Assert.assertEquals(task.getResult(), items);
    }

    @Test
    @Description("Тестування сортування інтерактивного списку")
    public void sortingTest(){
        int[] order = generateShuffledSequence(1, 7);
        SortingPage task = new SortingPage(driver)
                .open()
                .sort(order);
        Assert.assertEquals(task.getResult(), order);
    }

    @Step("Генерація послідовності від {start} до {end} включно, і випадкове перемішування послідовності")
    public int[] generateShuffledSequence(int start, int end){
        ArrayList<Integer> array = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(array);
        return array.stream().mapToInt(Integer::intValue).toArray();
    }

}
