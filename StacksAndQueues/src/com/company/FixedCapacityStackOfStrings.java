package com.company;
//this code is trivial without the resizing
public class FixedCapacityStackOfStrings {
    private String [] s;
    private int N = 0; //it is both the size of the stack and the index of the next position
    //of the stack

    public FixedCapacityStackOfStrings(int capacity){
        //'capacity' is a cheat that we use here to make our work easier which asks the user
        //for size of the array - it is basically N
        s= new String[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    //add a new element onto the end of the array and increase the length of the array
    public void push(String item){
        s[N++] = item;
    }

    //used to decrement value of N and then used to remove the last element of the
    //array and make its reference null.
    public String pop(){
        String item = s[--N];   //decrements N and uses the new value
        s[N]= null;
        return item;
    }
}
