package occupations;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[10];
        for (int i = 0; i < 5; i++) {
            people[i] = new Person();
        }

        people[5] = new Person(30, "Péter", Gender.MALE);
        people[6] = new Person(40, "János", Gender.MALE);
        people[7] = new Person(50, "Rodrigo", Gender.UNDEFINED);
        people[8] = new Person(20, "Fruzsina", Gender.FEMALE);
        people[9] = new Person(42, "Hedvig", Gender.MALE);

        for (Person person : people) {
            person.introduce();
            person.printGoal();
            System.out.println();
        }

        Chef[] chefs = new Chef[10];
        for (int i = 0; i < 5; i++) {
            chefs[i] = new Chef();
        }
        chefs[5] = new Chef(10, "Tamás", Gender.MALE, "broccoli");
        chefs[6] = new Chef(45, "Gordon", Gender.MALE, "french fires");
        chefs[7] = new Chef(59, "Gusztó", Gender.UNDEFINED, "stake");
        chefs[8] = new Chef(100, "Fruzsina", Gender.FEMALE, "liver");
        chefs[9] = new Chef(49, "Mari", Gender.FEMALE, "fried meat");

        for (Chef chef : chefs) {
            chef.introduce();
            chef.printGoal();
            chef.cook();
            System.out.println();
        }
    }

}
