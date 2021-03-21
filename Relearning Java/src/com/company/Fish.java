package com.company;
//inheritance
public class Fish extends Animal{
    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int size, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    private void rest(){

    }

    private void swimming(int speed){ //these are made private so that it is only usable by the Fish class as this movement is
        //specific to fish
        //other methods below are also pvt because they are deeper spcf functionalities of swimming
        moveMuscles();
        moveBackfins();
        super.move(speed);
    }

    private void moveMuscles(){
        
    }
    private void moveBackfins(){

    }
}
