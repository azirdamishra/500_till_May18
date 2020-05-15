package com.company;

import java.util.Arrays;

public class threeSumFast {
    //do not instantiate
    private threeSumFast(){}

    //check for duplicated integers
    private static boolean containsDuplicateIntegers(int [] a){
        for(int i = 0; i< a.length; i++){
            if(a[i] == a[i-1]){
                return true;
            }
        }
        return false;
    }

    public static int printAll(int[] a){
//        int n = a.length;
        Arrays.sort(a);
        int count = 0;
        if(containsDuplicateIntegers(a)) throw new IllegalArgumentException("array contains duplicate intergers");
        for(int i = 0; i< a.length; i++){
            for(int j = i+1; j< a.length; j++){
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if(k<j){
                    System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    count++;
                }
            }
        }
        return count;
    }

}
