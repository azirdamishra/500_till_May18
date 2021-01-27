package com.company;

public class ReplacingOnes {
    public static int findLength(int [] arr, int k){
        int windowStart = 0;
        int maxLength =  0;
        int max1count = 0;
        for ( int windowEnd = 0;  windowEnd <  arr.length; windowEnd++){
            if (arr[windowEnd] == 1 ){
                max1count++;
            }

            if (windowEnd - windowStart + 1 - max1count > k){
                if(arr[windowStart] == 1){
                    max1count--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd-windowStart +1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
