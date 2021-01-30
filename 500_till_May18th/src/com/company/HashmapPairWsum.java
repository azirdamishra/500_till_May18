package com.company;

import java.util.HashMap;

/*
Given an array of sorted numbers and a target sum, find a pair in the array whose
sum is equal to the given target.
Write a function to return the indices of the two numbers (i.e. the pair) such that
they add up to the given target.
 */
public class HashmapPairWsum {
    //using hashmap instead of the two pointer/binary search approach
    private static int[] pairSumWhashMap(int [] arr, int targetSum){
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int findInMap = targetSum - arr[i];
            if(numMap.containsKey(findInMap)){
                return new int[] {numMap.get(findInMap), i}; //return the array which
                //has the needed substraction result as well as the index of arr[i]
            }else {
                numMap.put(arr[i], i); //put number and its index in the map to be
                //found later
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int[] result = pairSumWhashMap(new int[] {2, 5, 9, 11}, 7);
        System.out.println(result[0] + " and " +  result[1]);
    }
}
