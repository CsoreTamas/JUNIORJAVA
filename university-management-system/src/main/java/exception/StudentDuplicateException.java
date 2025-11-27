package exception;

import tables.Enrollable;

public class StudentDuplicateException extends RuntimeException {
    public StudentDuplicateException(Enrollable enrollable) {
        super("Student already admitted" + enrollable);
    }
}
