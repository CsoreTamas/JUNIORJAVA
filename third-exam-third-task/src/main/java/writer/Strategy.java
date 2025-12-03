package writer;

import pojo.Employee;

import java.io.IOException;
import java.util.List;

public interface Strategy {
    void write(List<Employee> employeeList, String fileName) throws IOException;
}
