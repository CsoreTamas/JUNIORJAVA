package cli;

import lombok.RequiredArgsConstructor;
import model.Task;
import picocli.CommandLine;
import service.TaskService;

@CommandLine.Command(name = "add")
@RequiredArgsConstructor
public class AddCommand implements Runnable {

    @CommandLine.Option(names = "--title", required = true)
    private String title;

    @CommandLine.Option(names = "--description")
    private String description;

    private final TaskService taskService;

    @Override
    public void run() {
        Task task = taskService.addTask(title, description);
        System.out.println("Task added successfully!! (ID: " + task.getId() + ")");
    }
}
