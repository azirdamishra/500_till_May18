package com.company;
//recursive sorting with nlogn time
public class MergeSort {
    //private int cutoff = 7;

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        //assert statements are the preconditions before moving forward
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        for(int k= 0; k< hi; k++){
            aux[k] = a[k];
        }

        int i = lo; int j = hi;
        for(int k = 0; k< hi; k++){
            if      (i > mid)           aux[k] = a[j++];
            else if (j > hi)            aux[k] = a[i++];
            else if (less(a[j], a[i]))  aux[k] = a[j++];
            else                        aux[k] = a[i++];
        }
        assert isSorted(a, lo, hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if ( hi <= lo) {
            System.out.println("check if values are correct");
            return;
        }

        //this is used for tiny arrays of size 7
        if(hi <= lo + 7){
            InsertionSort.sort(a);
            return;
        }

        int mid = (hi - lo)/2 + lo;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if(!less(a[mid + 1], a[mid])) return;
        //this is useful for optimisation for partially sorted arrays
        merge(a, aux, lo, mid, hi);

    }
// this is the sort function that will be used outside this
// program ie for mergesort implementation
    public static void sort(Comparable[] a){
        Comparable[] aux =  new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        //it is important that we have this separate method for making the aux array only
        //so that there is not a lot of space utilisation
    }

    //is the entire array sorted
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    // is the array a[lo..hi) sorted
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    //for Insertion sort for optimisation for tiny arrays
    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
