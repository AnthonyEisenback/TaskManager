package com.company;

import javafx.concurrent.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd//yyyy");
    private Tasks tasks = new Tasks("", "", 0);
    private ArrayList<Tasks> tasks1 = new ArrayList<>();
    public final Menu menu;
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int completedBy;
    private String purpose;
    private ArrayList<Tasks> completed = new ArrayList<>();
    private ArrayList<Tasks> incomplete = new ArrayList<>();


    public Library(Menu menu) {
        this.menu = menu;
    }

    protected void viewTasks() {
        int index = 1;
        System.out.println("Here is all your tasks that have not been completed.\n");


        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ". Task Name, " + tasks.getTaskName() + ". Task's Details, " + tasks.getTastDetails() + ". Date To complete by, " + tasks.getDuedate() + ". ");
        }

        menu.Options();

    }

    protected void addTask() {

        try {
            System.out.println("Please enter the name of the task to be completed.");
            name = scanner.nextLine();
            System.out.println("Please enter the details of this task, ");
            purpose = scanner.nextLine();
            System.out.println("Please enter the goal of completion of this task, ");
            completedBy = scanner.nextInt();
            Tasks tasks = new Tasks(name, purpose, completedBy);
            incomplete.add(tasks);
            tasks1.add(tasks);


        } catch (InputMismatchException ime) {
            System.out.println("Please enter the Tasks Title");
        }

        menu.Options();


    }

    protected void removeTask(int gameIndex) {
        int index = 1;
        System.out.println("Input the number of the task to be removed!");

        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ". " + tasks.getTaskName());
        }
        gameIndex--;
        int qwerty = scanner.nextInt();
        tasks1.remove(qwerty - 1);
        System.out.println("Your task has been deleted !");
        menu.Options();

    }

    protected void exit() {
        System.out.println("Goodbye");
        System.exit(0);
    }

    protected void editTask(int gameIndex) {
        int index = 1;

        try {
            System.out.println("Welcome to task editor,\nplease choose your task to edit...");

            for (Tasks tasks : tasks1) {
                System.out.println(index++ + ". " + tasks.getTaskName());
            }
            gameIndex--;
            int qwerty = scanner.nextInt();
            tasks1.remove(qwerty - 1);
            System.out.println("Your task has been deleted !");
            menu.Options();


            System.out.println("please choose a part of the tasks to manage, \n1.) Change task name\n" +
                    "2.) Change a tasks detail\n" +
                    "3.) Change a tasks due date\n" +
                    "4.) Go back");


            switch (scanner.nextInt()) {

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4://recalls the options method to go back to the main menu.
                    menu.Options();
                    break;
                default:
                    System.out.println("Please enter a number");
                    editTask(0);
            }
        } catch (InputMismatchException ime) {

            editTask(0);
            System.out.println("Please input a number");
        }
        menu.Options();
    }

    protected void selectAndViewDetail() {


    }

    protected void completedTasks() {
        System.out.println("Here is your completed tasks");
        int index = 1;
        for (Tasks tasks : completed) {
            System.out.println(index++ + ". " + tasks.getTaskName());
        }
        menu.Options();
    }

    private void time() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("You created your Task on " +
                dateFormat.format(calendar.getTime()));


    }

    protected void incomplete() {

        System.out.println("Here is your uncompleted tasks!");
        int index = 1;
        for (Tasks tasks : incomplete) {
            System.out.println(index++ + ". " + tasks.getTaskName());
        }
        menu.Options();
    }

    protected void markcomplete(int gameIndex) {
        System.out.println("From here you can mark a task complete.\nPlease enter the number of the task you would like to mark complete.");
        int index = 1;
        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ". " + tasks.getTaskName());
            System.out.println("Please enter the tasks number to complete");
        }

        gameIndex--;
        int qwerty = scanner.nextInt();
//        completed.add();

        menu.Options();
    }
}
