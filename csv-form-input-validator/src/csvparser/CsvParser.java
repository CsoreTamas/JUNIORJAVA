package csvparser;

import inputsanitization.InputSanitization;
import user.UsersComment;
import validators.CommentValidator;
import validators.EmailValidator;
import validators.UsernameValidator;
import validators.Validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public static List<UsersComment> reader(Path path) throws IOException {
        List<String> fileReader = Files.readAllLines(path);
        List<UsersComment> usersComment = new ArrayList<>();

        for (int i = 1; i < fileReader.size(); i++) {
            String[] lines = fileReader.get(i).split(",");
            UsersComment user = sanitizeAndValidateUserInput(lines);
            usersComment.add(user);
        }
        return usersComment;
    }

    public static UsersComment sanitizeAndValidateUserInput(String[] lines) {
        Validator<String> usernameValidator = new UsernameValidator();
        Validator<String> emailValidator = new EmailValidator();
        Validator<String> commentValidator = new CommentValidator();

        String name = InputSanitization.sanitize(lines[0]);
        String email = InputSanitization.sanitize(lines[1]);
        String comment = InputSanitization.sanitize(lines[2]);

        UsersComment user = new UsersComment();

        if (usernameValidator.isValid(lines[0])) {
            user.setName(name);
        } else {
            System.err.println("Invalid name " + name);
            user.setName("Invalid name");
        }
        if (emailValidator.isValid(lines[1])) {
            user.setEmail(email);
        } else {
            System.err.println("Invalid email: " + email);
            user.setEmail("Invalid e-mail");
        }

        if (commentValidator.isValid(lines[2])) {
            user.setComment(comment);
        } else {
            System.err.println("Invalid comment: " + comment);
            user.setComment("Invalid comment");
        }
        return user;
    }
}
