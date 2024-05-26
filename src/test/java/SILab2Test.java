import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertTrue(exception.getMessage().contains("allItems list can't be null!"));

        List<Item> items1 = new ArrayList<>();
        items1.add(new Item(null, "12345", 100, 0));
        boolean result1 = SILab2.checkCart(items1, 100);
        assertTrue(result1);

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("Item1", null, 100, 0));
        RuntimeException exception2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, 100));
        assertTrue(exception2.getMessage().contains("No barcode!"));

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("Item1", "12345", 100, 0));
        items3.add(new Item("Item2", "01234", 400, 0));
        boolean result3 = SILab2.checkCart(items3, 500);
        assertTrue(result3);

        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("Item1", "12345", 100, 0));
        items4.add(new Item("Item2", "01234", 400, 0.1f));
        boolean result4 = SILab2.checkCart(items4, 500);
        assertTrue(result4);

        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("Item1", "12345", 100, 0));
        items5.add(new Item("Item2", "12345", 400, 0.1f));
        boolean result5 = SILab2.checkCart(items5, 500);
        assertTrue(result5);

        List<Item> items6 = new ArrayList<>();
        items6.add(new Item("Item1", "12345", 100, 0));
        items6.add(new Item("Item2", "01234", 400, 0));
        boolean result6 = SILab2.checkCart(items6, 500);
        assertTrue(result6);


        List<Item> items7 = new ArrayList<>();
        items7.add(new Item("Item1", "12345", 100, 0));
        items7.add(new Item("Item2", "01234", 400, 0));
        boolean result7 = SILab2.checkCart(items7, 200);
        assertFalse(result7);
    }

    @Test
    void multipleConditionTest() {
        List<Item> items = new ArrayList<>();

        // Case 1: true, true, true
        items.add(new Item("Item1", "012345", 400, 0.1f));
        boolean result1 = SILab2.checkCart(items, 500);
        assertTrue(result1);

        // Case 2: true, true, false
        items.clear();
        items.add(new Item("Item1", "112345", 400, 0.1f));
        boolean result2 = SILab2.checkCart(items, 500);
        assertTrue(result2);

        // Case 3: true, false, true
        items.clear();
        items.add(new Item("Item1", "012345", 400, 0));
        boolean result3 = SILab2.checkCart(items, 500);
        assertTrue(result3);

        // Case 4: true, false, false
        items.clear();
        items.add(new Item("Item1", "112345", 400, 0));
        boolean result4 = SILab2.checkCart(items, 500);
        assertTrue(result4);

        // Case 5: false, true, true
        items.clear();
        items.add(new Item("Item1", "012345", 200, 0.1f));
        boolean result5 = SILab2.checkCart(items, 500);
        assertTrue(result5);

        // Case 6: false, true, false
        items.clear();
        items.add(new Item("Item1", "112345", 200, 0.1f));
        boolean result6 = SILab2.checkCart(items, 500);
        assertTrue(result6);

        // Case 7: false, false, true
        items.clear();
        items.add(new Item("Item1", "012345", 200, 0));
        boolean result7 = SILab2.checkCart(items, 500);
        assertTrue(result7);

        // Case 8: false, false, false
        items.clear();
        items.add(new Item("Item1", "112345", 200, 0));
        boolean result8 = SILab2.checkCart(items, 500);
        assertTrue(result8);
    }

}


