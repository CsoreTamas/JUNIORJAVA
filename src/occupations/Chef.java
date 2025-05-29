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
        System.out.printf(getName() + " has cooked some " + food);
    }

    @Override
    public void introduce() {
        System.out.printf("My name is " + getName() + ". I am " + getAge() + " old. I am a " + getGender() + " and a Chef. ");
    }
}
