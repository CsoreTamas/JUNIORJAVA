package org.example.validators;

public class UsernameValidator implements Validator<String> {
    @Override
    public boolean isValid(String username) {
        return username != null && username.matches("^[a-zA-Z0-9]+$");
    }
}
