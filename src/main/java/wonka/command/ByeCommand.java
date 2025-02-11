package wonka.command;

import wonka.util.Save;
import wonka.util.TaskList;

/**
 * This ByeCommand class will print the exit message when executed.
 */
public class ByeCommand extends Command {

    /**
     * Executes command by printing exit message.
     *
     * @param tasks TaskList of tasks.
     * @param save  Saved history.
     */
    @Override
    public String execute(TaskList tasks, Save save) {
        save.save();
        return "Woof woof! Hope to see you again soon!";
    }
}
