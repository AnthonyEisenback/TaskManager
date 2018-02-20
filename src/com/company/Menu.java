package com.company;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    public Library library = new Library();


    protected void Options() {

        System.out.println("What would you like to do today?\n1.) Add a task \n" +
                "2.) Remove a task\n" +
                "3.) Uncompleted tasks\n" +
                "4.) Completed Tasks\n" +
                "5.) Edit a task \n" +
                "6.) View details of a task\n" +
                "7.) Exit Program");

        switch (scanner.nextInt()) {

            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                library.exit();
                break;

            default:
                System.out.println("Please enter a number");
                break;


        }


    }
}
