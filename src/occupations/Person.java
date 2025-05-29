package occupations;

public class Person {
    private int age;

    private String name;
    private Gender gender;

    public Person(int age, String name, Gender gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public Person() {
        this.age = 30;
        this.name = "János Pál";
        this.gender = Gender.MALE;
    }

    public void introduce() {
        System.out.printf("My name is %s. I am %d years old. I am a %s.", name, age, gender.name().toLowerCase());
    }

    public void printGoal() {
        System.out.println(" My goal is to be happy in the future.");
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}