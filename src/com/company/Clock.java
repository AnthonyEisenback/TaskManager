package com.company;

public class Clock {

    public int seconds;
    public int minutes;
    public int hours;

    public void timeTick(){

        seconds = seconds + 1;
        if(seconds==60){
            minutes++;
            seconds=0;
            if(minutes==60){
                hours++;
                minutes=0;
            }
        }
    }
    public String toString(){

        return hours + ":" + minutes + ":" + seconds;

    }


}

