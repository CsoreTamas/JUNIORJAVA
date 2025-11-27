package tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Setter
@ToString
public class Professor {
    private String name;
    private Faculty faculty;
    private int yearsOfExperience;
}
