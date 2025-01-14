package wonka.command;

import wonka.task.Task;
import wonka.util.Save;
import wonka.util.TaskList;

/**
 * This DeleteCommand class will delete a task provided with a 0-based index when executed.
 */
public class DeleteCommand extends Command {
    private final int taskNum;

    /**
     * Constructor for DeleteCommand which provides an index to delete.
     *
     * @param taskNum 0-based index.
     */
    public DeleteCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Executes command by deleting the given indexed task from TaskList.
     *
     * @param tasks TaskList of tasks.
     * @param save  Saved history.
     */
    @Override
    public String execute(TaskList tasks, Save save) {
        String response;
        int sizeOfTaskList = tasks.getCount();
        try {
            Task deleteTask = tasks.getTask(this.taskNum);
            tasks.delete(this.taskNum);
            assert (sizeOfTaskList - 1) == tasks.getCount();
            response = "Noted. I've removed this task:\n" + deleteTask.track() + deleteTask.getStatus() + " "
                    + deleteTask + "\nNow you have " + tasks.getCount() + " tasks in the list.";
        } catch (IndexOutOfBoundsException e) {
            response = "☹ Woof Woof!!! This task cannot be found!!!";
        }
        save.save();
        return response;
    }
}
