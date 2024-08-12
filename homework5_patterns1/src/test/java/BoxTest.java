import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoxTest {
    @Test
    public void testLists() {
        Box box = new Box();
        box.getList1().add("list1");
        box.getList2().add("list2");
        box.getList3().add("list3");
        box.getList4().add("list4");

        Iterator<String> iterator = box.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "list1");
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "list2");
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "list3");
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), "list4");
    }
}
