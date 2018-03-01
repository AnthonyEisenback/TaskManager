package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    public Library library = new Library(this);

    public SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    protected void Options() {//this is the main menu that shows you all the first choices you have when the program is launched

        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a  MM/dd/yyyy");
        //get current date time with Date()
        Date date = new Date();

        System.out.println("The time is " + dateFormat.format(date));

        System.out.println("What would you like to do today?\n1.) Add a task \n" +
                "2.) Remove a task\n" +
                "3.) View Your tasks\n" +
                "4.) Mark a task as Complete\n" +
                "5.) Completed Tasks\n" +
                "6.) View Uncompleted tasks\n" +
                "7.) Edit a task \n" +
                "8.) View details of a task\n" +
                "9.) Exit Program");

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


