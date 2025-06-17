import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class FileReader {
    public static ArrayList<Employee> reader(Path path) throws IOException {
        List<String> fileReader = Files.readAllLines(path);
        ArrayList<Employee> employees = new ArrayList<>();
        String[] headers = fileReader.get(0).split(",");

        for (int i = 1; i < fileReader.size(); i++) {

            if (fileReader.get(i).isEmpty()) {
                continue;
            }

            String[] data = fileReader.get(i).split(",");
            ArrayList<Integer> hours = new ArrayList<>();
            ArrayList<String> days = new ArrayList<>();

            for (int j = 2; j < data.length; j++) {
                days.add(headers[j]);
                hours.add(Integer.valueOf(data[j]));
            }
            Employee employee = new Employee(data[0], data[1], days, hours);
            employees.add(employee);
        }
        return employees;
    }
}
