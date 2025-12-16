import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.TaskService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskServiceTest {
    private TaskService service;
    private Task task1;
    private Task task2;

    @BeforeEach
    void setup() {
        service = new TaskService();
        task1 = service.addTask("First task", "This is the first");
        task2 = service.addTask("Second task", "This is the second");
    }

    @Test
    void shouldAddTasksWithIncreaseID() {
        assertEquals(1, task1.getId());
        assertEquals(2, task2.getId());
    }

    @Test
    void shouldListTasks() {
        List<Task> tasks = service.listTasks();
        assertEquals(2, tasks.size());
        assertEquals("First task", tasks.getFirst().getTitle());
        assertEquals("Second task", tasks.get(1).getTitle());
        assertEquals("This is the first", tasks.getFirst().getDescription());
        assertEquals("This is the second", tasks.get(1).getDescription());
    }

    @Test
    void shouldRemoveTaskByID() {
        boolean isRemoved = service.removeTask(1);
        assertTrue(isRemoved);
<<<<<<< Updated upstream
=======
        assertEquals(1, service.listTasks().size());
>>>>>>> Stashed changes
    }
}
