package com.company;
import edu.princeton.cs.algs4.StdRandom;
public class QuickSelect {

    public static Comparable select(Comparable[] a, int k){
        StdRandom.shuffle(a);
        int lo = 0; int hi = a.length -1;
        while(lo < hi){
            int  j = QuickSort.partition(a, lo, hi);
            if (j < k) lo = j + 1;
            if (j>k) hi = j-1;
            else return a[k];
        }
        return a[k];
    }
    // Quick select is just the simplest way to find the kth largest element without
    //making it as tedious as sorting
}
