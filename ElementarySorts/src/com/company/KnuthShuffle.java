package com.company;
import java.lang.Math;
import java.util.Random;

public class KnuthShuffle {
    //randomly and uniformly shuffles array in linear time
    public static void shuffle(Object[] a){
        int N = a.length;
        for(int i = 0; i<N; i++){
            int r = (int)(Math.random() * ((i) + 1)); //(Math.random() * ((max - min) + 1)) + min
            //Math.random() * ( max - min ) returns a value in the range [0, max – min] where max is excluded.
            exch(a,i,r);
            //make sure not to pick between 0 and N-1 as that is a common bug for this algorithm
        }
    }

    private static void exch(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
