package com.company;

public class binarySearch {
    public static int binarySearch(int [] a, int key){
        int low = 0;
        int high = a.length - 1;

        while(low <= high){
            int midIndex = (low + high)/2 + low;
            if(key < midIndex){
                high = midIndex -1;
            }else if(key> midIndex){
                low = midIndex +1;
            }else {
                return midIndex;
            }
        }
        return -1;
    }
}
