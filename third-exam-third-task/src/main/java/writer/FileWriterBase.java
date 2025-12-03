package writer;

import lombok.AllArgsConstructor;
import pojo.Employee;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public abstract class FileWriterBase {
    final String fileName;

    public abstract void write(List<Employee> employeeList) throws IOException;

}
