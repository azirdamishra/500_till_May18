package com.company;

public class GenFixedCapacityStack<Item> {
    private Item[] s;
    private int N = 0;

    public GenFixedCapacityStack(int capacity){
        s = (Item[]) new Object[capacity];  //will show warning which is not a problem
    }

    public boolean isEmpty(){
        return N== 0;
    }

    public void push(Item item){
        s[N++] = item;
    }

    public Item pop(){
        return s[--N];
    }
}
