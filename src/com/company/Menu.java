package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    public Library library = new Library(this);


    protected void Options() {

        System.out.println("What would you like to do today?\n1.) Add a task \n" +
                "2.) Remove a task\n" +
                "3.) View Your tasks\n" +
                "4.) Completed Tasks\n" +
                "5.) View Uncompleted tasks\n" +
                "6.) Edit a task \n" +
                "7.) View details of a task\n" +
                "8.) Exit Program");

        try {


            switch (scanner.nextInt()) {

                case 1:
                    library.addTask();

                    break;

                case 2:
                    library.removeTask(0);

                    break;

                case 3:
                    library.viewTasks();

                    break;

                case 4:
                    library.completedTasks();

                    break;

                case 5:
                    library.incomplete();
                    break;

                case 6:
                    library.editTask(0);
                    break;

                case 7:
                    library.selectAndViewDetail();

                    break;

                case 8:
                    library.exit();

                    break;

                default:
                    System.out.println("Please enter a number");
                    break;

            }

        } catch (InputMismatchException ime) {
            scanner.nextLine();
            Options();
            System.out.println("Please input a number");
        }


    }
}
