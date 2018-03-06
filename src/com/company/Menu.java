package com.company;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    private Scanner scanner = new Scanner(System.in);
    public Library library = new Library(this);

    protected void Options() throws IOException {//this is the main menu that shows you all the first choices you have when the program is launched

        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a  MM/dd/yyyy");
        Date date = new Date();

        System.out.println(ANSI_YELLOW + "The time is " + dateFormat.format(date.getTime()) + ANSI_RESET);

        System.out.println(ANSI_GREEN + "would you like to do today?\n1.) Add a task \n" +
                "2.) Remove a task\n" +
                "3.) View Your tasks\n" +
                "4.) Mark a task as Complete\n" +
                "5.) Completed Tasks\n" +
                "6.) View Uncompleted tasks\n" +
                "7.) Edit a task \n" +
                "8.) View details of a task\n" +
                "9.) Exit Program" + ANSI_RESET);

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
                    library.markComplete(0);
                    break;

                case 5:
                    library.completedTasks();

                    break;

                case 6:
                    library.incomplete();

                    break;

                case 7:
                    library.editTask(0);


                    break;

                case 8:
                    library.selectAndViewDetail(0);


                    break;

                case 9:
                    library.exit();

                case 10:

                default:
                    System.out.println("Please enter a number from 1-9");
                    Options();
                    break;

            }

        } catch (IndexOutOfBoundsException ime) {
            scanner.nextLine();
            Options();
            System.out.println(ANSI_RED + "Please input a valid number" + ANSI_RESET);
        } catch (InputMismatchException ime) {
            System.out.println(ANSI_RED + "Please enter a valid number" + ANSI_RESET);
            scanner.nextLine();
            Options();

        }
    }
}


