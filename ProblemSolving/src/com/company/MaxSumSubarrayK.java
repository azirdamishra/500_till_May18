package com.company;

import java.util.Arrays;

public class MaxSumSubarrayK {

    public static int findMaxSumInArray(int K, int[] arr){
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;
        for(int end = 0; end < arr.length; end++){
            windowSum += arr[end];
            if(end >= K - 1){
                if(maxSum < windowSum){
                    maxSum = windowSum;
                }
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int result = findMaxSumInArray(2, new int[] {2, 3, 4, 1, 5});
        System.out.println("Max sum of contiguous subarray of size K: " + result);
    }

}
