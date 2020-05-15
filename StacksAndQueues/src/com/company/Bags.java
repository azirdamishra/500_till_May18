package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bags<Item> implements Iterable<Item> {
    private Node<Item> first = null;    //beginning of the bag
    private int n = 0;  //no of components in the bag

    //helper linked list class
    private static class Node<Item>{
         Item item;
         Node<Item> next;
    }

    //initialises an empty bag
    public Bags(){
        first = null;
        n = 0;
    }

    //checks if the bag is empty
    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void add(Item item){
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    //Returns an iterator that iterates over the items in this bag in arbitrary order.
    public Iterator<Item> iterator(){
        return new ListIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item>{
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args) {
        Bags<String> bag = new Bags<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }

}
