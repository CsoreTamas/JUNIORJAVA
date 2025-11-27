package validator;

import tables.Course;

public class CourseCodeValidator implements Validator<Course> {
    @Override
    public boolean isValid(Course course) {
        return course.getCourseCode().matches("[A-Z]{3}-\\d{3}");
    }
}
