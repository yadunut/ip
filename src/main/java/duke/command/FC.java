package duke.command;

import java.util.List;
import java.util.stream.Collectors;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.TextUi;

public class FC extends Command {

    public final String d;

    public FC(String e) {
        this.d = e;
    }

    @Override
    public void execute(TaskList a, TextUi b, Storage c) {
        if (d == "") { b.foundTasks(a.getTasks()); return; }

        List<Task> ff = a.getTasks().stream()
                .filter(z -> z.getTask().contains(d))
                .collect(Collectors.toList());
        b.foundTasks(ff);
    }
}
