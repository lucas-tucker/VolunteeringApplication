package org.headroyce.lucast2021.reutlingervolunteeringapplication;

public class Assignee {

    //attributes to be implemented later, not in the time for Design Project 2
    private int numhours;
    private int daysvolunteered;
    private int age;
    private String name;

    public Assignee (String name){
        this.name = name;
    }

    public int getage(){

        return this.age;
    }


    public int gethours(){

        return this.numhours;
    }


    public int getdays(){

        return this.daysvolunteered;
    }



    public String getprofile(){

        return (this.name + ", " + this.age + ", " + this.numhours + "hours");

    }
}
