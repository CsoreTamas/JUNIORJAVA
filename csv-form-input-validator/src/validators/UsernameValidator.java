package validators;

public class UsernameValidator implements Validator<String> {

    @Override
    public boolean isValid(String input) {
        return input != null && input.matches("[a-zA-Z0-9]+");
    }
}
