package lab13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab13 {

    public static void main(String[] args) {
        final List<ToDo> todos = new ArrayList<>();
        try {
            FileInputStream in = new FileInputStream("dane.obj");
            ObjectInputStream ois = new ObjectInputStream(in);

            List<ToDo> todo = (List<ToDo>) ois.readObject();
            todos.addAll(todo);

            in.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("MENU:");
                System.out.println("a : Add new list");
                System.out.println("b : Edit list");
                System.out.println("c : Exit");
                String line = scanner.nextLine().trim();
                if (line.equals("a")) {
                    System.out.println("Enter task list name:");
                    String name = scanner.nextLine();
                    ToDo todo = new ToDo(name);
                    todos.add(todo);
                }
                if (line.equals("b")) {
                    for (int i = 0; i < todos.size(); i++) {
                        System.out.println(i + ": " + todos.get(i).getName());
                    }
                    System.out.println("Enter list number:");
                    int index = Integer.parseInt(scanner.nextLine());
                    ToDo todo = todos.get(index);

                    System.out.println("MENU:");
                    System.out.println("a : Add new task");
                    System.out.println("b : Remove task");
                    System.out.println("c : Print tasks");
                    System.out.println("d : Exit");

                    String subline = scanner.nextLine().trim();
                    if (subline.equals("a")) {
                        System.out.println("Enter task name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter task priority:");
                        int priority = Integer.parseInt(scanner.nextLine());
                        todo.addTask(name, priority);
                    }
                    if (subline.equals("b")) {
                        todo.printTasks();
                        System.out.println("Enter task number:");
                        int taskIndex = Integer.parseInt(scanner.nextLine());
                        todo.removeTask(taskIndex);
                    }
                    if (subline.equals("c")) {
                        todo.printTasks();
                    }
                }
                if (line.equals("c")) {
                    break;
                }
            }
        }

        try {
            FileOutputStream out = new FileOutputStream("dane.obj");
            ObjectOutputStream oos = new ObjectOutputStream(out);

            oos.writeObject(todos);

            out.close();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
