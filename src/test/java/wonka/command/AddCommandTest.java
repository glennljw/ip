package wonka.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import wonka.task.TaskStub;
import wonka.util.Save;
import wonka.util.TaskList;

class AddCommandTest {

    @Test
    void execute() {
        Save saveFile = new Save();
        TaskList tasks = new TaskList(100);
        TaskStub task = new TaskStub("Hello");
        AddCommand command = new AddCommand(task);
        String expected = "Got it. I've added this task:\n"
                + "[ ][ ] Hello\n"
                + "Now you have 1 tasks in the list.";
        assertEquals(expected, command.execute(tasks, saveFile));
    }
}
