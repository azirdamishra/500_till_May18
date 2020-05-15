package com.company;

//add these as new methods in the original array implementation when you want to
// resize the array in array implementation

public class ResizingArrayStackOfStrings {
    //if the array is full then create a new array of twice the length of the
    // original and copy items
    private String [] s;
    private int N = 0;//it is both the size of the stack and the index of the next position
    //of the stack

    public ResizingArrayStackOfStrings(){
        s = new String[1];
    }

    //there are two different types of variables involved:
    //1. the length of s
    //2. the size of the stack N    => this denotes the size of input of the user
    // they're both basically the same thing the only difference varying the size of the array
    //is in our hands

    public void push(String item){
        if(s.length == N){
            resize(s.length * 2);
            s[N++] = item;
        }
    }

    //this method is used to change the length of the string and copy the old array into the new
    //one with double the size
    public void resize(int capacity){

        String[] copy = new String[capacity];
        for(int i= 0; i< N;i++){
            copy[i] = s[i];
        }

        s= copy;    //we change the size of the stack (our original instance variable)
    }

    public String pop(){
        String item = s[--N];
        if( N > 0 && N == s.length/4) {
            resize(s.length/2);
        }
        return item;
    }


}
