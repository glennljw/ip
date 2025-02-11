package wonka.command;

import wonka.task.Task;
import wonka.util.Save;
import wonka.util.TaskList;

/**
 * This UnmarkCommand class will mark a task as undone when executed.
 */
public class UnmarkCommand extends Command {
    private final int taskNum;

    /**
     * Constructor for UnmarkCommand with a given task number to be marked as undone in the list.
     *
     * @param taskNum 0-based index task number to be marked.
     */
    public UnmarkCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Executes command by marking task as undone.
     *
     * @param tasks TaskList of tasks.
     * @param save  Saved history.
     */
    @Override
    public String execute(TaskList tasks, Save save) {
        String status = "";
        String response = "";
        try {
            Task task = tasks.getTask(taskNum);
            task.unmark();
            status = task.getStatus();
            response += "OK, I've marked this task as not done yet:\n";
            String unmarkString = tasks.getTask(taskNum).track() + tasks.getTask(taskNum).getStatus()
                    + " " + tasks.getTask(taskNum);
            response += unmarkString;
        } catch (IndexOutOfBoundsException e) {
            response = "Woof Woof!!! This task cannot be found!!!";
        }
        save.save();
        assert status.equals("[ ]");
        return response;
    }
}
