package org.headroyce.lucast2021.reutlingervolunteeringapplication;

import android.support.v7.app.AppCompatActivity;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Date;

import android.util.Log;

public class Applogic {

    private String emailuser;
    private String Month;
    private int Monthrange;
    private HashMap<Integer, ArrayList<Assignee>> assignees;


    public Applogic(){
        //create block using month and day
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (calendar.get(Calendar.MONTH) == 0){
            Month = "January";
        }
        if (calendar.get(Calendar.MONTH) == 1){
            Month = "February";
        }
        if (calendar.get(Calendar.MONTH) == 2){
            Month = "March";
        }
        if (calendar.get(Calendar.MONTH) == 3){
            Month = "April";
        }
        if (calendar.get(Calendar.MONTH) == 4){
            Month = "May";
        }
        if (calendar.get(Calendar.MONTH) == 5){
            Month = "June";
        }
        if (calendar.get(Calendar.MONTH) == 6){
            Month = "July";
        }
        if (calendar.get(Calendar.MONTH) == 7){
            Month = "August";
        }
        if (calendar.get(Calendar.MONTH) == 8){
            Month = "September";
        }
        if (calendar.get(Calendar.MONTH) == 9){
            Month = "October";
        }
        if (calendar.get(Calendar.MONTH) == 10){
            Month = "November";
        }
        if (calendar.get(Calendar.MONTH) == 11){
            Month = "December";
        }


        assignees = new HashMap<Integer, ArrayList<Assignee>> ();

        Date cool = new Date();
        Calendar f = Calendar.getInstance();
        f.setTime(cool);

        for(int x = 0; x <= YearMonth.now().lengthOfMonth(); x++){
            assignees.put(x, new ArrayList<Assignee>());
        }
        //make all dates put in entiremonth buttons

    }


    public void makeusername(String user){

        emailuser = user;
        //set top text equal to username so that user can see they are signed in
    }


    public int numAssignees( int day ){

        return assignees.get(day).size();
    }


    public boolean maxAssignees (int day){

        if (assignees.get(day).size() > 2){
            return true;
        }

        return false;

    }


    public void addassignee (String assignee, int day){
        //int[] assigneemonth = new int[Monthrange];

        Assignee person = new Assignee(assignee);

        assignees.get(day).add(person);

    }


    public void printday (int day){

        System.out.print("love" + day);

    }









}
