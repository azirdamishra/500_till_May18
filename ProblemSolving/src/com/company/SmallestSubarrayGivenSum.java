package com.company;

public class SmallestSubarrayGivenSum {
    public static int FindSubarrSize(int sum, int [] arr){
        int currWindowSum = 0;
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;

        for(int windowEnd = 0; windowEnd < arr.length ; windowEnd++){
            currWindowSum  +=  arr[windowEnd];
            while (sum <= currWindowSum){
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                currWindowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int result = FindSubarrSize(7, new int[] {3,4,1,1,6});
        System.out.println("Min size of contiguous subarray of sum K: " + result);
    }
}
