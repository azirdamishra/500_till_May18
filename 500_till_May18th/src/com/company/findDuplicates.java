package com.company;
/*
Given an array of sorted numbers, remove all duplicates from it. You should not use
any extra space; after removing the duplicates in-place return the length of the
subarray that has no duplicate in it
 */

//if its not a sorted array we may use a Hashset to compare
public class findDuplicates {
    private static int remove(int[] arr){
        int fast = 1;
        int slow = 0;
        for (; fast < arr.length; fast++) {
            //let the counter keep movig if the IF statement is false
            if(arr[fast] != arr[fast-1]){
                //slow = fast;
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return slow+1; //slow is an index
    }

    public static void main(String[] args) {
        int result = remove(new int[] {2, 2, 2, 11});
        System.out.println(result);
    }

}
