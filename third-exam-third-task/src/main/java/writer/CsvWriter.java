package writer;

import com.opencsv.CSVWriter;
import pojo.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter extends FileWriterBase {
    public CsvWriter(String fileName) {
        super(fileName);
    }

    @Override
    public void write(List<Employee> employeeList) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeNext(new String[]{"Name", "Age", "Department", "Salary"});
            for (Employee employee : employeeList) {
                writer.writeNext(new String[]{
                        employee.getName(),
                        String.valueOf(employee.getAge()),
                        employee.getDepartment(),
                        String.valueOf(employee.getSalary())
                });
            }
            System.out.println("Data written successfully to employees.csv");
        }
    }
}

