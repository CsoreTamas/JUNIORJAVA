package cli;

import model.Task;
import picocli.CommandLine;
import service.TaskService;

import java.util.List;

@CommandLine.Command(name = "list")
public record ListCommand(TaskService taskService) implements Runnable {

    @Override
    public void run() {
        List<Task> list = taskService.listTasks();
        list.forEach(System.out::println);
    }
}
