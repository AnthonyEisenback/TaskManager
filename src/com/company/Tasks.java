package com.company;

import java.util.Scanner;


public class Tasks {

  String  duedate;
  String taskName;
  String tastDetails;
  String dateStarted;
  boolean completed;
  String time;


  /** Nice job with your model */

    public Tasks(String taskName, String tastDetails, String duedate, boolean completed) {
        this.duedate = duedate;
        this.taskName = taskName;
        this.tastDetails = tastDetails;
        this.dateStarted = dateStarted;
        this.completed = completed;
        this.time = time;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
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

    public void setTime (){
        this.time = time;
    }


}
