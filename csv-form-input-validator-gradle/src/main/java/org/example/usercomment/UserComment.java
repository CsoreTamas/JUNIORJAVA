package org.example.usercomment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {
    private String name;
    private String email;
    private String comment;

    @Override
    public String toString() {
        return String.format("Name: %s %nEmail: %s %nComment: %s %n", name, email, comment);
    }
}
