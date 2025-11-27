package exception;

import tables.Course;

public class CourseDuplicateException extends RuntimeException {
    public CourseDuplicateException(Course course) {
        super("Course already exists" + course);
    }
}
