package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

public class UnorderedMazPQ<Key extends Comparable<Key>> {
    private Key[] pq;   //pq[i] --> ith element in pq
    private int N; // no of elements in pq

    public UnorderedMazPQ(int capacity){
        this.N = capacity;
        pq = (Key[]) new Comparable[this.N]; //no generic array creation
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Key x){
        pq[N++] = x;
    }

    public Key delMax(){
        int max = 0;
        for(int i= 1; i<N; i++){
            if(less(pq[max], pq[i])) max = i;
        }
        exch(pq, max, N-1);
        return pq[--N];
    }

    public int size(){
        return pq.length;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args){
        UnorderedMazPQ<Transaction> pq = new UnorderedMazPQ<>(100);

        while (StdIn.hasNextLine()){
            String line = StdIn.readLine();
            Transaction item = new Transaction(line);
            int M = StdIn.readInt(); //m smallest items that are to be present in pq
            pq.insert(item);
            if(pq.size() > M ){
                pq.delMax();
            }
        }
    }
}
