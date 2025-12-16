package service;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private long ID = 1;

    public Task addTask(String title, String description) {
        Task task = Task.builder()
                .id(ID++)
                .title(title)
                .description(description)
                .build();
        tasks.add(task);
        return task;
    }

    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }

    public boolean removeTask(long id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }
}
