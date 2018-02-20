package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Library {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd//yyyy");
    private Tasks tasks = new Tasks();

    protected void viewTasks() {

    }

    protected void addTask() {
        System.out.println("What is the name of your task?");


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
