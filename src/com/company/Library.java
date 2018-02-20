package com.company;

import javafx.concurrent.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd//yyyy");
    private Tasks tasks = new Tasks("");
    private ArrayList<Tasks> tasks1 = new ArrayList<>();
    public final Menu menu;
    private Scanner scanner = new Scanner(System.in);
    private String name;


    public Library(Menu menu) {
        this.menu = menu;
    }

    protected void viewTasks() {
        int index = 1;
        System.out.println("Here is all your tasks that have not been completed.\n");


        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ". " + tasks.getTaskName());
        }
        menu.Options();

    }

    protected void addTask() {

            try {
                System.out.println("Please enter the name of the game you are adding!");
                name = scanner.nextLine();
                Tasks tasks = new Tasks(name);
                tasks1.add(tasks);
                System.out.println("Your game has been saved!");


                menu.Options();

        } catch (InputMismatchException ime) {
            System.out.println("Please enter the Tasks Title");
        }

        menu.Options();


    }

    protected void removeTask() {

    }

    protected void exit() {
        System.out.println("Goodbye");
        System.exit(0);
    }

    protected void editTask() {

    }

    protected void selectAndViewDetail() {

    }

    protected void completedTasks() {

    }

    private void time() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("You created your Task on " +
                dateFormat.format(calendar.getTime()));


    }
}
