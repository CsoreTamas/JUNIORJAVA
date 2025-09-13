package org.example.validators;


public class EmailValidator implements Validator<String> {

    @Override
    public boolean isValid(String email) {
        return email != null && email.matches("^[a-zA-Z0-9.]+@[a-zA-Z]+\\.[a-z]{2,3}$");
    }
}
