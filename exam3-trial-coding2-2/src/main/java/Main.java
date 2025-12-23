import cli.AddCommand;
import cli.App;
import cli.DeleteCommand;
import cli.ListCommand;
import picocli.CommandLine;
import service.TaskService;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();

        App app = new App();
        CommandLine commandLine = new CommandLine(app);

        commandLine.addSubcommand("add", new AddCommand(taskService));
        commandLine.addSubcommand("list", new ListCommand(taskService));
        commandLine.addSubcommand("delete", new DeleteCommand(taskService));
        commandLine.execute(args);

        commandLine.execute("add", "--title", "First Task", "--description", "this is the first task");
        commandLine.execute("add", "--title", "second task", "--description", "this is the second task");
        commandLine.execute("list");
        commandLine.execute("delete", "--id", "1");
        commandLine.execute("list");

    }
}
