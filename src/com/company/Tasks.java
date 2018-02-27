package com.company;

import java.util.Scanner;

public class Tasks {

  int duedate;
  String taskName;
  String tastDetails;
  String dateStarted;
  boolean completed;

    public Tasks(String taskName, String tastDetails, int duedate, boolean completed) {
        this.duedate = duedate;
        this.taskName = taskName;
        this.tastDetails = tastDetails;
        this.dateStarted = dateStarted;
        this.completed = completed;
    }

    public int getDuedate() {
        return duedate;
    }

    public void setDuedate(int duedate) {
        this.duedate = duedate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTastDetails() {
        return tastDetails;
    }

    public void setTastDetails(String tastDetails) {
        this.tastDetails = tastDetails;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
