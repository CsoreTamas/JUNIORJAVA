package org.example.validators;

public class CommentValidator implements Validator<String> {
    @Override
    public boolean isValid(String comment) {
        return comment != null && comment.matches("^[a-zA-Z-0-9 _\\-!?.$]*$");
    }
}
