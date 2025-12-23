package validator;

import tables.Enrollable;
import tables.Student;

public class StudentIDValidator implements Validator<Enrollable> {
    @Override
    public boolean isValid(Enrollable enrollable) {
        return ((Student) enrollable).getStudentId().matches("\\d{8}");
    }
}
