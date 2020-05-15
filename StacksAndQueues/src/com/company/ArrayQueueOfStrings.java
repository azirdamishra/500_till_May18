package com.company;
/*
check out princeton's solution
https://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html
 */

public class ArrayQueueOfStrings {

    private String[] q;
    private int N = 0 ; //also known as the tail where we add new elements
    //index 0 is the head from where we remove elements

    //N  is both the size of the stack and the index of the next position
    //of the stack

    public ArrayQueueOfStrings(){
        q = new String[1];   //q.length is the capacity
        //we don't need to use capacity here because we are using 1 and can resize the array
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void enqueue(String item){
        if(N == q.length){  //array is full this implies we need to resize the array
            resize(2 * q.length);
        }
        q[N++] = item;
    }

    private void resize(int capacity){
        String [] copy = new String[capacity];
        for(int i =0; i< q.length; i++){
            copy[i] = q[i];
        }
        q = copy; //create duplicate arrays
    }

    public String dequeue(){
        //remove element in q[0]
        if(isEmpty()){
            return null;
        }

        if(N> 0 && N == q.length/4){
            resize(q.length/2);
        }

        String item = q[0];
        for(int i= 1;i<N; i++){
            q[i-1]= q[i];
        }
        q[N-1] = null;
        N--;
        return item;
    }


}
