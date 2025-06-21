package user;

import java.util.Objects;

public class UsersComment {
    private String name;
    private String email;
    private String comment;

    public UsersComment() {
    }

    public UsersComment(String name, String email, String comment) {
        this.name = name;
        this.email = email;
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %nEmail: %s %nComment: %s %n", this.name, this.email, this.comment);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsersComment that = (UsersComment) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, comment);
    }
}
