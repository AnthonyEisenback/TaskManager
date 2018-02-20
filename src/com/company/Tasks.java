package com.company;

public class Tasks {

  int duedate;
  String taskName;
  String tastDetails;
  int dateStarted;

    public Tasks() {
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

    public int getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(int dateStarted) {
        this.dateStarted = dateStarted;
    }
}
