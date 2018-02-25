package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class Library {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd//yyyy");
    //    private Tasks tasks = new Tasks("", "", 0);
    private ArrayList<Tasks> tasks1 = new ArrayList<>();
    public final Menu menu;
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int completedBy;
    private String purpose;
    private ArrayList<String> completed = new ArrayList<>();
    private ArrayList<Tasks> incomplete = new ArrayList<>();


    public Library(Menu menu) {
        this.menu = menu;
    }

    protected void viewTasks() {//the method to display the tasks all together.
        int index = 1;
        System.out.println("Here is all your tasks that have not been completed.");

        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ".  " + tasks.getTaskName() + " \n");
        }

        menu.Options();

    }

    protected void addTask() {//method that adds a task to the incomplete and tasks arrays

        try {
            System.out.println("Please enter the name of the task to be completed.");
            name = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Please enter the details of this task, ");
            purpose = scanner.nextLine();

            System.out.println("Please enter the goal of completion of this task, ");
            completedBy = scanner.nextInt();

            Tasks tasks = new Tasks(name, purpose, completedBy);
            incomplete.add(tasks);
            tasks1.add(tasks);


        } catch (InputMismatchException ime) {
            System.out.println("Please enter the Tasks Title");
            menu.Options();
        }

        System.out.println("Would you like to add another task?\n1.) Yes\n2.) No");

        switch (scanner.nextInt()) {
            case 1:

                addTask();
                break;
            case 2:

                menu.Options();
                break;
            default:

                menu.Options();
                break;

        }

        menu.Options();


    }

    protected void removeTask(int gameIndex) {//the method used to remove your tasks you choose
        int index = 1;
        System.out.println("Input the number of the task to be removed!");

        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ". " + tasks.getTaskName());
        }
        gameIndex--;
        int qwerty = scanner.nextInt();
        tasks1.remove(qwerty - 1);
        incomplete.remove(qwerty - 1);
        System.out.println("Your task has been deleted !");
        menu.Options();

    }

    protected void exit() {//method to terminate the program
        System.out.println("Goodbye");
        System.exit(0);
    }

    protected void editTask(int gameIndex) {//method to edit a task you have created.
        int index = 1;

        try {
            System.out.println("Welcome to task editor,\nplease choose your task to edit...");

            for (Tasks tasks : tasks1) {
                System.out.println(index++ + ". " + tasks.getTaskName());
            }
            gameIndex--;
            int qwerty = scanner.nextInt();
            tasks1.get(qwerty - 1);

            System.out.println("please choose a part of the tasks to manage, \n1.) Change task name\n" +
                    "2.) Change a tasks detail\n" +
                    "3.) Change a tasks due date\n" +
                    "4.) Go back");


            switch (scanner.nextInt()) {

                case 1:
                    try {
                        System.out.println("please enter the new name...");
                        String names = scanner.nextLine();
                        incomplete.get(qwerty - 1).setTaskName(scanner.nextLine());
                        System.out.println("Please enter the name again");
                        tasks1.get(qwerty - 1).setTaskName(scanner.nextLine());
                        System.out.println("Your tasks name have been changed");
                    } catch (InputMismatchException ime) {
                        System.out.println("Please enter the name correctly");
                        editTask(0);
                    }

                    break;
                case 2:
                    try {
                        System.out.println("please enter the new details...");
                        String names = scanner.nextLine();
                        incomplete.get(qwerty - 1).setTastDetails(scanner.nextLine());
                        System.out.println("Please enter the details again...");
                        tasks1.get(qwerty - 1).setTastDetails(scanner.nextLine());
                        System.out.println("Your task's details have been changed");
                    } catch (InputMismatchException ime) {
                        System.out.println("Please enter the details correctly");
                        editTask(0);
                    }

                    break;
                case 3:
                    try {
                        System.out.println("please enter the new date of completion...");
                        String names = scanner.nextLine();
                        incomplete.get(qwerty - 1).setDuedate(scanner.nextInt());
                        System.out.println("Please enter the name again");
                        tasks1.get(qwerty - 1).setDuedate(scanner.nextInt());
                        System.out.println("Your tasks due date has been changed");
                    } catch (InputMismatchException ime) {
                        System.out.println("Please enter the date correctly");
                        editTask(0);
                    }

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

    protected void selectAndViewDetail(int gameIndex) {//shows you the tasks you have made and allows you to see the full detail on the tasks
        int index = 1;
        System.out.println("Here is all the details on your tasks.");

        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ". Task's Name, " + tasks.getTaskName() + ". Task's Details, " + tasks.getTastDetails() + ". Date To complete by, " + tasks.getDuedate() + ". \n");
        }

        menu.Options();

    }

    protected void completedTasks() {//shows just your completed tasks.
        System.out.println("Here is your completed tasks");
        int index = 1;
        for (String tasks : completed) {
            System.out.println(index++ + ". " + completed.get(0));
        }

        menu.Options();
    }

    private void time() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("You created your Task on " +
                dateFormat.format(calendar.getTime()));


    }

    protected void incomplete() {//shows just your uncompleted tasks

        System.out.println("Here is your uncompleted tasks!");
        int index = 1;
        for (Tasks tasks : incomplete) {
            System.out.println(index++ + ". " + tasks.getTaskName());
            System.out.println("These are your uncompleted tasks \nWhat would you like to do now?\n1.) Go back to menu\n2.) Mark a task as complete");
        }

        try {

            switch (scanner.nextInt()) {
                case 1:
                    menu.Options();
                    break;
                case 2:
                    markComplete(0);
                    break;
                default:
                    System.out.println("Please enter a number");
                    break;

            }
        } catch (InputMismatchException ime) {
            System.out.println("Please enter a number");
        }
    }


    protected void markComplete(int gameIndex) {//last section to complete than debug and add more features
        System.out.println("From here you can mark a task complete.\nPlease enter the name of the task you would like to mark complete.");
        int index = 1;
        for (Tasks tasks : incomplete) {
            System.out.println(index++ + ". " + tasks.getTaskName());
            System.out.println("Please enter the tasks name to be completed");
        }
        String next = scanner.nextLine();

        for (int i = 0; i < incomplete.size(); i++) {
            completed.add(next);


        }


        menu.Options();
    }
}


