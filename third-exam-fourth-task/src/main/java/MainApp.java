import app.UserInteract;
import dao.AdoptionDao;
import dao.AnimalDao;
import dao.DAOInterface;
import jakarta.persistence.EntityManager;
import model.Adoption;
import model.Animal;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import service.AdoptionService;
import service.AnimalService;
import util.EntityManagerUtil;

public class MainApp {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerUtil.createEntityManager();

        DAOInterface<Adoption> adoptionDAO = new AdoptionDao(entityManager);
        DAOInterface<Animal> animalDAO = new AnimalDao(entityManager);

        AnimalService animalService = new AnimalService(animalDAO);
        AdoptionService adoptionService = new AdoptionService(animalDAO, adoptionDAO);

        LineReader lineReader = LineReaderBuilder.builder().build();
        UserInteract userInteract = new UserInteract(adoptionService, animalService, lineReader);

        userInteract.start();
    }
}
