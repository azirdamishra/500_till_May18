package com.company;

public class BottomUpMergeSort {
    private static Comparable[] aux;

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int middle, int hi){
        //assert statements are the preconditions before moving forward
        assert isitSorted(a, lo, middle);
        assert isitSorted(a, middle+1, hi);

        for(int p= 0; p< hi; p++){
            aux[p] = a[p];
        }

        int i = lo; int j = hi;
        for(int k = 0; k< hi; k++){
            if      (i > middle)           aux[k] = a[j++];
            else if (less(a[j], a[i]))  aux[k] = a[j++];
            else if (j > hi)            aux[k] = a[i++];
            else                        aux[k] = a[i++];
        }
        assert isitSorted(a, lo, hi);
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1; sz < N; sz++){ //size of the subarrary and it gets executed only logn times
            for(int lo  = 1; lo < N - sz; lo += sz + sz){
               merge(a,aux, lo, lo+sz-1, Math.min(lo + sz + sz - 1, N-1));
            }
        }
    }

    //is the entire array sorted
    private static boolean isitSorted(Comparable[] a) {
        return isitSorted(a, 0, a.length);
    }

    // is the array a[lo..hi) sorted
    private static boolean isitSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
}
