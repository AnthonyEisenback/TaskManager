package com.company;

import java.util.Scanner;

public class Tasks {

  int duedate;
  String taskName;
  String tastDetails;
  String dateStarted;

    public Tasks(String taskName, String tastDetails, int duedate) {
        this.duedate = duedate;
        this.taskName = taskName;
        this.tastDetails = tastDetails;
        this.dateStarted = dateStarted;
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

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }
}
