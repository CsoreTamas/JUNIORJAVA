package validators;

public class EmailValidator implements Validator<String> {

    @Override
    public boolean isValid(String input) {
        return input != null && input.matches("[a-zA-Z0-9.]+@[a-zA-Z]+\\.[a-z]{2,3}");
    }
}
