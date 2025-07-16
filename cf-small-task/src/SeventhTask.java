//write a program to manage an e-mail list.
//the users can do the following operations:
//add a new e-mail address
//get the list of the e-mail addresses
//update an e-mail address
//delete an existing e-mail address
//(specifying the address)
//Each e-mail address has to be unique.

import java.util.LinkedHashSet;
import java.util.Set;


public class SeventhTask {
    private final Set<String> emailList;

    public SeventhTask(Set<String> emailList) {
        this.emailList = new LinkedHashSet<>(emailList);
    }

    public Set<String> getEmailList() {
        return emailList;
    }

    public boolean addEmail(String email) {
        if (!emailList.contains(email)) {
            emailList.add(email);
            return true;
        } else {
            System.out.println("The email already exist.");
            return false;
        }
    }

    public boolean updateEmail(String modifierEmail, String newEmail) {
        if (!emailList.contains(modifierEmail)) {
            System.out.println("The email to modify does not exist");
            return false;
        } else if (emailList.contains(newEmail)) {
            System.out.println("The email already exist");
            return false;
        }
        emailList.remove(modifierEmail);
        emailList.add(newEmail);
        return true;
    }

    public boolean deleteEmail(String email) {
        if (emailList.contains(email)) {
            emailList.remove(email);
            return true;
        } else {
            System.out.println("Try again, cause the email does not exist.");
            return false;
        }
    }
}
