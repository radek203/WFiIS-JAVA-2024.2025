package lab13;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToDo implements Serializable {

    public static class Task implements Serializable {

        String name;
        int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Serial
        private static final long serialVersionUID = 1L;

    }

    private final List<Task> tasks = new ArrayList<>();
    private final String name;

    public ToDo(String name) {
        this.name = name;
    }

    public void addTask(String name, int priority) {
        tasks.add(new Task(name, priority));
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i).name + " (" + tasks.get(i).priority + ")");
        }
    }

    public String getName() {
        return name;
    }

    @Serial
    private static final long serialVersionUID = 1L;

}
