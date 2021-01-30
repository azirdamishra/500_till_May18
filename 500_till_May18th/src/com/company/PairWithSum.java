package com.company;
/*
Given an array of sorted numbers and a target sum, find a pair in the array whose
sum is equal to the given target.
Write a function to return the indices of the two numbers (i.e. the pair) such that
they add up to the given target.
 */
public class PairWithSum {
    public static void main(String[] args) {
        int[] result = pairWithTargetSum(new int[] {1, 2, 3, 4, 6}, 6);
        System.out.println(result[0] + " and " +  result[1]);
    }
    private static int[] pairWithTargetSum(int[] arr, int sum){
        int right = arr.length - 1;
        int left = 0;
        int eachSum = 0;

        while (left<right){
            eachSum = arr[left] + arr[right];
            if(eachSum == sum){
                return new int[] {left, right};
            }
            if(eachSum < sum) left++;
            if(eachSum > sum) right--;
        }
        return new int[]{-1, -1};
    }
}
