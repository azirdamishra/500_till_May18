package com.company;

import java.util.Arrays;

/*
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is
as close to the target number as possible, return the sum of the triplet. If there are more
than one such triplet, return the sum of the triplet with the smallest sum.
 */
public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
    private static int searchTriplet(int[] arr, int targetSum){
        if (arr == null || arr.length < 3)
            throw new IllegalArgumentException();
        int currSum = 0;
        //int resultSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE; //it is the minDiff between the target sum and the triplet of the array
        //this had to be on the outside of the for loop because we need to find triplet with
        //overall minimum difference in the entire loop else it would keep getting restored
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int neededSum = targetSum - arr[i-1];
            //System.out.println(resultSum + "?");
            int left = i;
            int right = arr.length - 1;

            while (left<right){
                currSum = arr[left] + arr[right];
                if(neededSum == currSum){
                    return currSum + arr[i-1];
                }
//                    System.out.println(Math.abs(neededSum-currSum) + " Math.abs(neededSum-currSum)");
//                    System.out.println(Math.abs(minDiff) + " Math.abs(minDiff)");
//                    System.out.println(neededSum-currSum + " neededSum-currSum");
//                    System.out.println(minDiff + " minDiff");
//                    System.out.println("i value " + i);

                if(Math.abs(neededSum-currSum) < Math.abs(minDiff) ||
                        (Math.abs(neededSum-currSum) == Math.abs(minDiff) &&
                                neededSum-currSum > minDiff)){
                    minDiff = neededSum-currSum;
//                    System.out.println("Changed min diff " + minDiff);

                }
                if(neededSum < currSum) right--;
                else left++;
                }

            }

        return targetSum - minDiff;
    }

}
/*
Another type of code:
This I like more
import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    if (arr == null || arr.length < 3)
      throw new IllegalArgumentException();

    Arrays.sort(arr);
    int smallestDifference = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1, right = arr.length - 1;
      while (left < right) {
        // comparing the sum of three numbers to the 'targetSum' can cause overflow
        // so, we will try to find a target difference
        int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
        if (targetDiff == 0) //  we've found a triplet with an exact sum
          return targetSum - targetDiff; // return sum of all the numbers

        // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
        if (Math.abs(targetDiff) < Math.abs(smallestDifference)
            || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
          smallestDifference = targetDiff; // save the closest and the biggest difference

        if (targetDiff > 0)
          left++; // we need a triplet with a bigger sum
        else
          right--; // we need a triplet with a smaller sum
      }
    }
    return targetSum - smallestDifference;
  }

  public static void main(String[] args) {
    System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
    System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
    System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
  }
}
 */