package com.company;

public class threeWayQS {
    private static void sort(Comparable[] a, int lo, int hi){
        if(lo <= hi)  return;
        int gt = hi; int lt = lo;
        Comparable v = a[lo];
        int i = lo;
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0) exch(a, i++, lt++);
            if (cmp >0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
