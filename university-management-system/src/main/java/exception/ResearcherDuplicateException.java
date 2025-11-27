package exception;

import tables.Enrollable;

public class ResearcherDuplicateException extends RuntimeException {
    public ResearcherDuplicateException(Enrollable enrollable) {
        super("Researcher already admitted" + enrollable);
    }
}
