package tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Setter
@ToString
public class Student implements Enrollable<Student> {
    private String name;
    private String studentId;
    private String major;
}
