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
    private ArrayList<Tasks> dates = new ArrayList<>();
    private ArrayList<Tasks> detail = new ArrayList<>();
    public final Menu menu;
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String completedBy;
    private String purpose;


    public Library(Menu menu) {
        this.menu = menu;
    }

    protected void viewTasks() {
        int index = 1;
        System.out.println("Here is all your tasks that have not been completed.\n");


        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ". " + tasks.getTaskName());
        }

        for (Tasks taskDate : dates) {
            System.out.println("|| " + taskDate.getDuedate());
        }


    }

    protected void addTask() {

        try {
            System.out.println("Please enter the name of the task to be completed.");
            name = scanner.nextLine();
            Tasks tasks = new Tasks(name);
            tasks1.add(tasks);

            System.out.println("Please enter the name details task to be completed.");
            name = scanner.nextLine();
            Tasks details = new Tasks(name);
            detail.add(details);

            System.out.println("Please enter the date of the task to be completed by.");
            completedBy = scanner.nextLine();
            Tasks date = new Tasks(completedBy);
            dates.add(date);


            menu.Options();

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
