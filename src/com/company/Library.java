package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class Library {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss : MM/dd/yyyy");
    //    private Tasks tasks = new Tasks("", "", 0);
    private ArrayList<Tasks> tasks1 = new ArrayList<>();
    public final Menu menu;
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int completedBy;
    private String purpose;
    private List<String> completed = new ArrayList<>();
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
            System.out.println("Enter name of the task");
            Scanner addName = new Scanner(System.in);
            String name = (addName.nextLine());

            System.out.println("Enter the details of the task");
            Scanner addPrice = new Scanner(System.in);
            String price = (addPrice.nextLine());


            System.out.println("Enter the due date of the task");
            Scanner addDue = new Scanner(System.in);
            int due = (addDue.nextInt());


            incomplete.add(new Tasks(name, price, due));
            tasks1.add(new Tasks(name, price, due));


            Calendar calendar = Calendar.getInstance();

            System.out.println("You added your task on, " + dateFormat.format(calendar.getTime()));

        } catch (InputMismatchException ime) {
            System.out.println("Please enter the Tasks Title");
            menu.Options();
        }

        System.out.println("Would you like to add another task?\n1.) Yes\n2.) No");

        try {

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

        } catch (InputMismatchException ime) {
            System.out.println("Please choose a number!");
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

        System.out.println("Would you like to clear all the completed tasks?\n1.) Yes\n2.) Go back to home");

        try {
            switch (scanner.nextInt()) {
                case 1:
                    completed.clear();
                    System.out.println("Tasks cleared!");
                    break;
                case 2:
                    menu.Options();
                    break;
                default:
                    System.out.println("Please enter a number");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Please enter a number");
        }
        menu.Options();

    }


    protected void incomplete() {//shows just your uncompleted tasks

        Calendar calendar = Calendar.getInstance();

        System.out.println("This is your time right now. " + dateFormat.format(calendar.getTime()));


        System.out.println("Here is your uncompleted tasks!");

        int index = 1;
        for (Tasks tasks : incomplete) {
            System.out.println(index++ + ". " + tasks.getTaskName() +"  " + tasks.getDuedate());
        }

        System.out.println("Select 1 to go back to the main menu or 2 to mark a task as completed.");


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


    protected void markComplete(int input) {//last section to complete than debug and add more features
        System.out.println("From here you can mark a task complete.\nPlease enter the name of the task you would like to mark complete.");
        int index = 1;
        for (Tasks tasks : incomplete) {
            System.out.println(index++ + ". " + tasks.getTaskName());
        }



    }
}


