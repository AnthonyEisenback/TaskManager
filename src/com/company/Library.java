package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Library {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a : MM/dd/yyyy");
    private ArrayList<Tasks> tasks1 = new ArrayList<>();
    public final Menu menu;
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private Date date = new Date();
    private String clock;

    public Library(Menu menu) {
        this.menu = menu;
    }

    protected void viewTasks() throws IOException {//the method to display the tasks all together.
        scanner.nextLine();
        int index = 1;
        System.out.println("Here is all your tasks.");

        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ".  " + tasks.getTaskName());
        }

        menu.Options();

    }

    protected void addTask() throws IOException {//method that adds a task to the incomplete and tasks arrays

        try {
            System.out.println("Enter name of the task");
            Scanner addName = new Scanner(System.in);
            String name = (addName.nextLine());

            System.out.println("Enter the details of the task");
            Scanner addPrice = new Scanner(System.in);
            String price = (addPrice.nextLine());


            System.out.println("Enter the due date of the task");
            Scanner addDue = new Scanner(System.in);
            String due = (addDue.nextLine());


            tasks1.add(new Tasks(name, price, due, false));


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

    protected void removeTask(int gameIndex) throws IOException {//the method used to remove your tasks you choose
        int index = 1;
        System.out.println("Input the number of the task to be removed!");

        try {
            for (Tasks tasks : tasks1) {
                System.out.println(index++ + ". " + tasks.getTaskName());
            }
            gameIndex--;
            int qwerty = scanner.nextInt();
            tasks1.remove(qwerty - 1);
            System.out.println("Your task has been deleted !");
            menu.Options();
        } catch (IndexOutOfBoundsException IND) {
            System.out.println("Please enter a valid number!");
        }

    }

    protected void exit() throws IOException {//method to terminate the program
        BufferedWriter writer = new BufferedWriter(new FileWriter("Logs.txt"));
        int size = tasks1.size();
        for (int i = 0; i < size; i++) {
            String str = tasks1.get(i).taskName + " " + tasks1.get(i).tastDetails + " " + tasks1.get(i).duedate;
            writer.write(str);
            if (i < size - 1)//This prevent creating a blank like at the end of the file**
                writer.write("\n");
        }
        writer.close();


        System.out.println("Goodbye");
        System.exit(0);
    }

    protected void editTask(int gameIndex) throws IOException {//method to edit a task you have created.
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
                        scanner.nextLine();
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
                        tasks1.get(qwerty - 1).setDuedate(scanner.nextLine());
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

    protected void selectAndViewDetail(int gameIndex) throws IOException {//shows you the tasks you have made and allows you to see the full detail on the tasks
        int index = 1;
        System.out.println("Here is all the details on your tasks.");

        for (Tasks tasks : tasks1) {
            System.out.println(index++ + ". Task's Name, " + tasks.getTaskName() + ". Task's Details, " + tasks.getTastDetails() + ". Date To complete by, " + tasks.getDuedate() + ". \n");
        }

        menu.Options();

    }

    protected void incomplete() throws IOException {//shows just your uncompleted tasks
        Tasks list = new Tasks("", "", "", false);
        Calendar calendar = Calendar.getInstance();

        System.out.println("This is your time right now. " + dateFormat.format(calendar.getTime()));


        System.out.println("Here is your uncompleted tasks!");

        int index = 1;

        for (Tasks tasks : tasks1) {

            if (tasks.completed == false) {
                System.out.println(index++ + ". " + tasks.taskName + " and has been completed on... " + dateFormat.format(date));

            } else if (tasks.completed == true) {
                System.out.println("You have no tasks to complete!");
                menu.Options();
            }
        }
        menu.Options();
    }

    protected void markComplete(int input) throws IOException {//last section to complete than debug and add more features
        name = "";

        System.out.println("From here you can mark a task complete.");
        int index = 1;

        for (Tasks tasks : tasks1) {
            if (tasks.completed == false) {
                System.out.println(index++ + ". " + tasks.getTaskName());
            } else {

            }

        }
        try {
            System.out.println("What would you like to complete today?");
            int i = scanner.nextInt() - 1;
            tasks1.get(i).setCompleted(true);

            Calendar calendar = Calendar.getInstance();

            String cal = dateFormat.format(calendar.getTime());

            tasks1.get(i).setDuedate(cal);


        } catch (InputMismatchException ime) {
            System.out.println("Please enter a number!");


        } catch (IndexOutOfBoundsException iob) {
            System.out.println("Please enter a number within the range!");
            menu.Options();
        }


    }

    protected void completedTasks() throws IOException {//shows just your completed tasks.
        System.out.println("Here is your completed tasks");

        int index = 1;

        for (Tasks tasks : tasks1) {

            if (tasks.completed == true) {
                System.out.println(index++ + ". " + tasks.taskName + " and has been completed on... " + tasks.getDuedate());

            } else if (tasks.completed == false) {
            }
        }

        System.out.println("Would you like to clear all the completed tasks?\n1.) Yes\n2.) Go back to home");

        try {
            Tasks tasks = new Tasks("", "", "", false);
            switch (scanner.nextInt()) {
                case 1:
                    if (tasks.completed = true) {
                        tasks1.removeAll(tasks1);
                    } else {

                    }

                    System.out.println("Tasks cleared!");
                    menu.Options();
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
        } catch (IndexOutOfBoundsException iod) {
            System.out.println("Please select a number within the range!");
            menu.Options();
        }

    }

}