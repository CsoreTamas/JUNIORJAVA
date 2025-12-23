package tables;

import lombok.*;

@Data
@AllArgsConstructor
public class Student implements Enrollable {
    private String name;
    private String studentId;
    private String major;
}
