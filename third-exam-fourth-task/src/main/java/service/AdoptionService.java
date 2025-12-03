package service;

import dao.DAOInterface;
import model.Adoption;
import model.Animal;

import java.util.List;
import java.util.Optional;

public record AdoptionService(DAOInterface<Animal> animalDao, DAOInterface<Adoption> adoptionDao) {

    public void createAdoption(long animalId, String adopterName) {
        Optional<Animal> animal = animalDao.findById(animalId);
        if (animal.isEmpty()) {
            throw new RuntimeException("Cannot adopt non existing animal with ID" + animalId);
        }

        Adoption adoption = Adoption.builder()
                .adopterName(adopterName)
                .animal(animal.get())
                .build();

        adoptionDao.save(adoption);
    }

    public List<Adoption> listAllAdoptions() {
        return adoptionDao.findAll();
    }

    public Optional<Adoption> findAdoptionById(long id) {
        return adoptionDao.findById(id);
    }

    public void deleteAdoptionById(long id) {
        adoptionDao.deleteById(id);
    }
}
