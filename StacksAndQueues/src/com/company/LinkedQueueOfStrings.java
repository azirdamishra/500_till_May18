package com.company;
//this is a general class that we have made to be applied to do linked list queue implementation
//on a client's info
public class LinkedQueueOfStrings {
    //initialise two Node variables to be used in our class for general work from outside

    private class Node{
        String item;
        Node next;
    }

    private Node first, last;

    public boolean isEmpty(){   //to check whether the given queue is empty
        return first == null;
    }

    public void enqueue(String item){   //similar to the push function of stack implementation
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null; //to make sure the queue ends there

        if(isEmpty()){      //to check if the queue is empty
            first = last;
        }else{
            oldlast.next = last;
        }

    }

    public String dequeue(){    //similar to the pop function of Stack implementation
        String item = first.item;
        first = first.next;
        if(isEmpty()){      //to check if the queue is empty
            last = null;
        }
        return item;
    }
}
