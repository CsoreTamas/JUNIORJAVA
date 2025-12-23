package tables;

import lombok.*;

@Data
@AllArgsConstructor
public class Researcher implements Enrollable {
    private String name;
    private String researchArea;
    private int yearsOfResearchExperience;
}
