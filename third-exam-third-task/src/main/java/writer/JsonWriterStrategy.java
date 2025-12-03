package writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class JsonWriterStrategy implements Strategy {
    @Override
    public void write(List<Employee> employeeList, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName), employeeList);
            System.out.println("Data written successfully to employees.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
