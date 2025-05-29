package occupations;

public class Chef extends Person {
    private String food;

    public Chef(int age, String name, Gender gender, String food) {
        this.setAge(age);
        this.setName(name);
        this.setGender(gender);
        this.food = food;
    }

    public Chef() {
        this.setAge(30);
        this.setName("János Pál");
        this.setGender(Gender.MALE);
        this.setFood("Pasta");
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }

    public void cook() {
        System.out.printf("%s has cooked some %s", getName(), food);
    }

    @Override
    public void introduce() {
        System.out.printf("My name is %s. I am %d years old. I am %s and a Chef!", getName(), getAge(), getGender().name().toLowerCase());
    }
}
