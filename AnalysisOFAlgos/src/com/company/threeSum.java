package com.company;

public class threeSum {
    //use static methods in java only when you want to call the method without an instance of
    //the class ie the method is independent of the characteristics of the class
    public static int sumToZero(int[] a){
        int count = 0;

        for(int i=0; i< a.length; i++){
            for(int j = 0; j< a.length;j++){
                for (int k= j+1; k<a.length; k++){
                    if(a[i] + a[j] + a[k] == 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
