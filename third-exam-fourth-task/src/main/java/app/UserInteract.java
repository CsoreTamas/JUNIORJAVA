package app;

import model.Adoption;
import model.Animal;
import org.jline.reader.LineReader;
import service.AdoptionService;
import service.AnimalService;

import java.util.List;
import java.util.Optional;

public record UserInteract(AdoptionService adoptionService, AnimalService animalService, LineReader lineReader) {
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("App: ");
            System.out.println("1. Add animal");
            System.out.println("2. List animals");
            System.out.println("3. Find animal by id");
            System.out.println("4. Delete animal by id");
            System.out.println("5. Create adoption");
            System.out.println("6. List adoption");
            System.out.println("7. Find adoption by id");
            System.out.println("8. Delete adoption");
            System.out.println("0. Exit");

            int input = Integer.parseInt(lineReader.readLine("Choose an option: "));

            switch (input) {
                case 1 -> addAnimal();
                case 2 -> listAnimal();
                case 3 -> findAnimalByID();
                case 4 -> deleteAnimalById();
                case 5 -> createAdoption();
                case 6 -> listAdoption();
                case 7 -> findAdoptionById();
                case 8 -> deleteAdoptionById();
                case 0 -> running = false;
                default -> System.out.println("Invalid input");
            }
        }
    }

    private void addAnimal() {
        String name = lineReader.readLine("Enter the name: ");
        String species = lineReader.readLine("Enter the species: ");
        int age = Integer.parseInt(lineReader.readLine("Enter the age: "));
        animalService.addAnimal(name, species, age);
        System.out.println("Animal added successfully");
    }

    private void listAnimal() {
        List<Animal> animals = animalService.listAllAnimals();
        if (animals.isEmpty()) {
            System.out.println("No animal found");
        } else {
            animals.forEach(System.out::println);
        }
    }

    private void findAnimalByID() {
        long id = Long.parseLong(lineReader.readLine("Enter the animal's ID: "));
        Optional<Animal> animal = animalService.findAnimalById(id);
        System.out.println(animal);
    }

    private void deleteAnimalById() {
        long id = Long.parseLong(lineReader.readLine("Enter the animal's ID: "));
        animalService.deleteAnimalById(id);
        System.out.println("Animal successfully deleted!");
    }

    private void createAdoption() {
        long animalID = Long.parseLong(lineReader.readLine("Enter the Animal's ID: "));
        String adopterName = lineReader.readLine("Enter the adopter's name: ");
        adoptionService.createAdoption(animalID, adopterName);
        System.out.println("Adoption successfully created!");
    }

    private void listAdoption() {
        List<Adoption> adoptions = adoptionService.listAllAdoptions();
        if (adoptions.isEmpty()) {
            System.out.println("No adoption found");
        } else {
            adoptions.forEach(System.out::println);
        }
    }

    private void findAdoptionById() {
        long id = Long.parseLong(lineReader.readLine("Enter the id "));
        Optional<Adoption> adoption = adoptionService.findAdoptionById(id);
        System.out.println(adoption);
    }

    private void deleteAdoptionById() {
        long id = Long.parseLong(lineReader.readLine("Enter the id: "));
        adoptionService.deleteAdoptionById(id);
        System.out.println("Adoption successfully deleted!");
    }
}
