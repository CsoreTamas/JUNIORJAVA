package pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;
}

