package com.company;
//linked list implementation
public class StackOfStrings {

    private class Node {    //access modifier doesn't matter
        String item;
        Node next;
    }

    private Node first = null;

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        //this is used to add a new item at the end of the arrow
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;  //the new object created in 'first' now points to oldfirst
        //first.item is now the last string in the stack
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }



    public static void main(String[] args){
        StackOfStrings stack = new StackOfStrings();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("-")) StdOut.print(stack.pop());
            else stack.push(s);

        }
    }

}

