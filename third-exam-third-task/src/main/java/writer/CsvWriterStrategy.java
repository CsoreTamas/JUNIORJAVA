package writer;

import com.opencsv.CSVWriter;
import pojo.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterStrategy implements Strategy {
    @Override
    public void write(List<Employee> employeeList, String fileName) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeNext(new String[]{"Name", "Age", "Department", "Salary"});
            for (Employee employee : employeeList) {
                writer.writeNext(new String[]{
                        employee.getName(),
                        String.valueOf(employee.getAge()),
                        employee.getDepartment(),
                        String.valueOf(employee.getSalary())});
            }
            System.out.println("Data written successfully to employees.csv");
        }
    }
}


