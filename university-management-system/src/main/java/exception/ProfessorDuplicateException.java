package exception;

import tables.Professor;

public class ProfessorDuplicateException extends RuntimeException {
    public ProfessorDuplicateException(Professor professor) {
        super("Professor already exists." + professor);
    }
}
