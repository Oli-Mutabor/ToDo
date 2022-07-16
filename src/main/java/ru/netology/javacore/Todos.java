package ru.netology.javacore;

import java.util.*;

public class Todos {
    protected List<String> todoList = new ArrayList<>();



    public void addTask(String task) {
        todoList.add(task);
    }

    public void removeTask(String task) {
        todoList.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(todoList);
        StringBuilder list = new StringBuilder();
        for (String task : todoList) {
            list.append(task).append(" ");
        }
        return list.toString();
    }
}

