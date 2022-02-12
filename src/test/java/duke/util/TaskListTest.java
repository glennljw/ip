package duke.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import duke.task.Task;
import duke.task.TaskStub;

class TaskListTest {
    private final ArrayList<Task> taskArrayList = new ArrayList<>(100);
    private final TaskList taskList = new TaskList(100);

    @Test
    void testTaskListSize_addOrDeleteTaskStub_sizeIncrease() {
        assertEquals(taskArrayList.size(), taskList.getCount());
        TaskStub taskStub = new TaskStub("TestTaskStub");
        taskArrayList.add(taskStub);
        taskList.add(taskStub);
        assertEquals(taskArrayList.size(), taskList.getCount());
        taskArrayList.remove(0);
        taskList.delete(0);
        assertEquals(taskArrayList.size(), taskList.getCount());
    }
}
