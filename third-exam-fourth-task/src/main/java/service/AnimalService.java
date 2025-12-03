package service;

import dao.DAOInterface;
import model.Animal;

import java.util.List;
import java.util.Optional;

public record AnimalService(DAOInterface<Animal> animalDao) {

    public void addAnimal(String name, String species, int age) {
        Animal animal = Animal.builder()
                .name(name)
                .species(species)
                .age(age)
                .build();

        animalDao.save(animal);
    }

    public List<Animal> listAllAnimals() {
        return animalDao.findAll();
    }

    public Optional<Animal> findAnimalById(long id) {
        return animalDao.findById(id);
    }

    public void deleteAnimalById(long id) {
        animalDao.deleteById(id);
    }
}
