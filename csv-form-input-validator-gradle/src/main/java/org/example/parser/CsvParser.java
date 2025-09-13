package org.example.parser;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.example.usercomment.UserComment;
import org.example.validators.Validator;
import org.example.validators.CommentValidator;
import org.example.validators.EmailValidator;
import org.example.validators.UsernameValidator;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public static List<UserComment> reader(String filePath) throws IOException, CsvValidationException {
        List<UserComment> comments = new ArrayList<>();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .build()) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length < 3) {
                    continue;
                }
                UserComment userComment = validateSanitizeUserInput(line);
                comments.add(userComment);
            }
        }
        return comments;
    }

    private static UserComment validateSanitizeUserInput(String[] line) {
        //HtmlPolicyBuilder().toFactory --> Removes everything, leaving only the plain, raw text.
        PolicyFactory policyFactory = new HtmlPolicyBuilder().toFactory();

        Validator<String> nameVal = new UsernameValidator();
        Validator<String> emailVal = new EmailValidator();
        Validator<String> commentVal = new CommentValidator();

        UserComment user = new UserComment();
        List<String> invalidDats = new ArrayList<>();
        if (nameVal.isValid(line[0])) {
            user.setName(policyFactory.sanitize(line[0]));
        } else {
            invalidDats.add(policyFactory.sanitize(line[0]));
            user.setName("Invalid name");
        }
        if (emailVal.isValid(line[1])) {
            user.setEmail(line[1]);
        } else {
            invalidDats.add(policyFactory.sanitize(line[1]));
            user.setEmail("Invalid email");
        }
        if (commentVal.isValid(line[2])) {
            user.setComment(policyFactory.sanitize(line[2]));
        } else {
            invalidDats.add(policyFactory.sanitize(line[2]));
            user.setComment("Invalid comment");
        }
        for (String s : invalidDats) {
            System.err.println(s);
        }

        return user;
    }
}
