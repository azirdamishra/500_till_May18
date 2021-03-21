package com.company;
//inheritance
public class Dog extends Animal{
    //we def need to have a constructor in the Dog class that calls the constructor in the Animal class

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail,int teeth, String coat) {
        super(name, 1, 1, size, weight);//base characteristics which are not just spcf to Dogs
        //automatically the parameters of the ANimal class have been created as params to the Dog class
        //super calls the constructor from the class that we are extending / inheriting from
        // this lets us initialised the animal class and let us add more features in additon to that of the ANimal class
        //which could be unique for the dog
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew(){
        System.out.println("DOg.chew() called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew(); //private method of Dog class called
        super.eat(); //calling the eat method in ANimal class
        //this basically shows that we are overriding the method in the ANimal class to make it sth special for the Dog class
    }

    public void walk(){
        System.out.println("Dog.walk() called");
        //super.move();//can be called but this could cause problems for overriding
        super.move(5);//goes and calls only the move method from the super class and does not even look at the
        //move class created inside Dog (extended) class
    }

    public void run(){
        System.out.println("Dog.run() called");
        move(10);//looks in the Dog class for the move method, and if it is not found, then it goes into the Animal class
        //to look for the move method and runs it
    }
    private void moveLegs(int speed){
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }
}
