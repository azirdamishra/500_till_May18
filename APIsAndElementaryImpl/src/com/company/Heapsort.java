package com.company;

public class Heapsort {
    public static void sort(Comparable[] pq){
        int N = pq.length;
        for(int k = N/2; k >= 1; k--){
            sink(pq, k, N);
        }
        while (N > 1){
            exch(pq, 1, N);
            sink(pq, 1, --N);
        }
    }

    private static void sink(Comparable[] a, int k, int N){
        while(2*k <= N){
            int j = 2*k;
            if(j<N && less(a, j, j+1)) j++;
            if(!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[i]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
