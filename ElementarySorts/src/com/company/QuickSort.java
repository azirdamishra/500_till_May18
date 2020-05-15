package com.company;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;
public class QuickSort {

    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        while (true){
            while (less(a[++i], a[lo])){
                if (i == hi) break;
            }//find item on left to swap

            while (less(a[lo], a[--j])){
                if (j==lo) break;
            }//find item on right to swap

            if (i >= j) break; //check if pointers cross
            exch(a, lo, j); //swap
        }
        exch(a, lo, j); //swap with partitioning element (which is chosen randomly)
        return j;   //return index of item now known to be in place
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);   //shuffle needed for performance guarantee
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[]a , int lo, int hi){
        if(hi <= lo + 10){ //cutoff to insertion sort for 10 to 20 items
            Insertion.sort(a,lo, hi);
        }
        //optimise by finding the median of indexes instead of the first random element
        //better to take the median of 3 random items (lo, middle, hi)
        //now 12/7 compares slightly better than 12/35 which was before
        //this is because partition happens very close to the middle
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
