package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 */
public class tripletSumtoZero {
    private static List<List<Integer>> searchTriplets(int[] arr){
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        //we need to find unique solutions so we will need to skip the duplicates in the
        //sorted array
        for (int i = 0; i < arr.length; i++) {
            if(i>0 && arr[i-1] == arr[i]) continue;
            searchPair(arr, -arr[i],triplets, i+1);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, List<List<Integer>> triplets, int left){
        int right = arr.length -1;

        while (left < right){
            int currSum = arr[left] + arr[right];
            if(currSum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left<right && arr[left] == arr[left-1]) left++;
                while ( right != arr.length-1 && left<right && arr[right] == arr[right+1]) right--;
            }
            if(currSum>targetSum) right--;
            if(currSum<targetSum) left++;
        }
    }

    public static void main(String[] args) {
        System.out.println(tripletSumtoZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(tripletSumtoZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
