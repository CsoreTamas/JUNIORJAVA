package interact;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import pojo.Employee;
import writer.CsvWriterStrategy;
import writer.JsonWriterStrategy;
import writer.Strategy;

import javax.naming.InvalidNameException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserInteract {

    public static void start() throws InvalidNameException, IOException {
        List<Employee> employeeList = new ArrayList<>();
        LineReader lineReader = LineReaderBuilder.builder().build();
        writeEmployees(lineReader, employeeList);
        selectAndWriteFile(lineReader, employeeList);
    }

    private static void writeEmployees(LineReader lineReader, List<Employee> employeeList) {
        boolean more = true;
        while (more) {
            String name = lineReader.readLine("Enter the Name: ");
            int age = Integer.parseInt(lineReader.readLine("Enter the Age: "));
            String department = lineReader.readLine("Enter the Department: ");
            int salary = Integer.parseInt(lineReader.readLine("Enter the Salary: "));

            Employee employee = Employee.builder().name(name).age(age).department(department).salary(salary).build();
            employeeList.add(employee);

            String another = lineReader.readLine("Do you want to add more employee? (yes/no): ");
            more = another.equalsIgnoreCase("yes");
        }
    }

    private static void selectAndWriteFile(LineReader lineReader, List<Employee> employeeList) throws IOException, InvalidNameException {
        String choice = lineReader.readLine("Choose a file format between csv or jason (csv/jason): ");
        Strategy strategy;
        if (choice.equalsIgnoreCase("csv")) {
            strategy = new CsvWriterStrategy();
            strategy.write(employeeList, "employee.csv");

        } else if (choice.equalsIgnoreCase("json")) {
            strategy = new JsonWriterStrategy();
            strategy.write(employeeList, "employee.json");
        } else {
            throw new InvalidNameException("Invalid name");
        }
    }
}
