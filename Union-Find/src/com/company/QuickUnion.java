package com.company;

public class QuickUnion {
    private int[] id;

    //initialising the array using a constructor
    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    //finding the root of the given number
    private int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    //checking if the given numbers are already connected by checking if they have the same root
    //ie they are part of the same tree
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    //making the root of p a child of root of q that is the two whole components get connected
    //by their roots
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
