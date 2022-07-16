package ru.netology.javacore;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            while (true) {
                try (Socket socket = serverSocket.accept(); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    String inTask = in.readLine();
                    JsonObject jsonObject = JsonParser.parseString(inTask).getAsJsonObject();
                    String type = jsonObject.get("type").getAsString();
                    String task = jsonObject.get("task").getAsString();
                    switch (type) {
                        case "ADD":
                            todos.addTask(task);
                            break;
                        case "REMOVE":
                            todos.removeTask(task);
                            break;
                    }
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


