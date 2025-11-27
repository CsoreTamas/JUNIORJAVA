package tables;

import exception.CourseDuplicateException;
import exception.ProfessorDuplicateException;
import exception.ResearcherDuplicateException;
import exception.StudentDuplicateException;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class University {
    private static University instance;

    public static University getInstance() {
        if (instance == null) {
            instance = new University();
        }
        return instance;
    }

    private final Set<Course> courses = new HashSet<>();
    private final Set<Professor> professors = new HashSet<>();
    private final Set<Enrollable> participants = new HashSet<>();

    public void offerCourse(Course course) {
        if (!courses.add(course)) {
            throw new CourseDuplicateException(course);
        }
    }

    public void hireProfessor(Professor professor) {
        if (!professors.add(professor)) {
            throw new ProfessorDuplicateException(professor);
        }
    }

    public void admitEnrollable(Enrollable enrollable) {
        if (participants.contains(enrollable)) {
            if (enrollable instanceof Student) {
                throw new StudentDuplicateException(enrollable);
            } else if (enrollable instanceof Researcher) {
                throw new ResearcherDuplicateException(enrollable);
            }
        } else {
            participants.add(enrollable);
        }
    }

    public List<Enrollable> getParticipantsOfCourse(Course course) {
        return new ArrayList<>(course.getEnrolledParticipants());
    }

    public List<Course> getCoursesByProfessor(Professor professor) {
        List<Course> resultList = new ArrayList<>();
        for (Course course : courses) {
            if (course.getProfessor().equals(professor)) {
                resultList.add(course);
            }
        }
        return resultList;
    }
}
