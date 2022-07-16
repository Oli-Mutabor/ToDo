package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {

    @Test
    public void addTaskTest() {
        Todos todoList = new Todos();
        todoList.addTask("Some task");

        Assertions.assertTrue(todoList.getAllTasks().contains("Some task"));
    }

    @Test
    public void removeTaskTest() {
        Todos todoList = new Todos();
        todoList.addTask("Some task");
        todoList.removeTask("Some task");

        Assertions.assertFalse(todoList.getAllTasks().contains("Some task"));
    }

    @Test
    public void testGetAllTask() {
        Todos todoList = new Todos();
        todoList.addTask("B task");
        todoList.addTask("A task");
        todoList.addTask("C task");

        String expected = "A task" + " " + "B task" + " " + "C task" + " ";

        Assertions.assertEquals(expected, todoList.getAllTasks());
    }
}
