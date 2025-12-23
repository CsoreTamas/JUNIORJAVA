package cli;

import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "CLI APP")
public class App implements Runnable {
    @Override
    public void run() {
        System.out.println("Specify a subcommand (add, list, delete)");
    }
}
