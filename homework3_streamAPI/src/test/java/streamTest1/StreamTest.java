package streamTest1;


import org.junit.jupiter.api.Test;
import streem_api.StreamProcessor;
import streem_api.Tasks.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTest {


    @Test
    public void getListTasksTest() throws Exception {
        List<Task> list = StreamProcessor.getListTasks("Закрыта");
        assertEquals(2, list.size());
    }

    @Test
    public void getListTasksSortedTest() throws Exception {
        assertEquals("Открыта", StreamProcessor.getListTasksSorted().getFirst().getStatus());
    }

    @Test
    public void checkTaskTest() throws Exception {
        assertTrue(StreamProcessor.checkTask(6));
        assertFalse(StreamProcessor.checkTask(0));
    }

    @Test
    public void countNumberTasksTest() throws Exception {
        int quantity = StreamProcessor.countNumberTasks("Закрыта");
        assertEquals(2, quantity);
    }
}

