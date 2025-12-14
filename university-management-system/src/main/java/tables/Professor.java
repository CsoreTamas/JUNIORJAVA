package tables;

import lombok.*;

@Data
@AllArgsConstructor
public class Professor {
    private String name;
    private Faculty faculty;
    private int yearsOfExperience;
}
