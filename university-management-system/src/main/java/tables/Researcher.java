package tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Setter
@ToString
public class Researcher implements Enrollable<Researcher> {
    private String name;
    private String researchArea;
    private int yearsOfResearchExperience;
}
