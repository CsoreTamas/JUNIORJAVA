package tables;

import exception.ResearcherDuplicateException;
import exception.StudentDuplicateException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@Setter
@ToString
public class Course {
    private String courseCode;
    private String courseName;
    private Professor professor;
    private Set<Enrollable> enrolledParticipants = new HashSet<>();

    public void enrollParticipant(Enrollable enrollable) {
        if (!enrolledParticipants.add(enrollable)) {
            if (enrollable instanceof Student) {
                throw new StudentDuplicateException(enrollable);
            } else if (enrollable instanceof Researcher) {
                throw new ResearcherDuplicateException(enrollable);
            }
        } else {
            enrolledParticipants.add(enrollable);
        }
    }
}
