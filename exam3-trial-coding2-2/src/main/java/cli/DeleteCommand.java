package cli;

import lombok.RequiredArgsConstructor;
import picocli.CommandLine;
import service.TaskService;

@CommandLine.Command(name = "delete")
@RequiredArgsConstructor
public class DeleteCommand implements Runnable {
    @CommandLine.Option(names = "--id", required = true, description = "Enter the task's ID what you want to delete.")
    private long id;

    private final TaskService taskService;

    @Override
    public void run() {
        boolean isDeleted = taskService.removeTask(id);
        if (isDeleted) {
            System.out.println("Task with " + id + " successfully deleted!");
        } else {
            System.out.println("Task with " + id + " not found");
        }
    }
}
