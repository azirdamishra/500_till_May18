package com.company;
// the array given is already in ascending order
// we only need to return a pair and not an array containing all the pairs in order
public class PairWithTargetSum {
    public static int[] findingNoPair(int arr[], int targetSum){
        int left = 0;
        int right = arr.length -1;
        int[] finalarr = new int[arr.length];
        int counter = 0;
        while (left < right){
            int currsum = arr[left] + arr[right];
            if(currsum == targetSum){
                return new int[] {left, right};
//                while(counter < finalarr.length-1){
//                    finalarr[++counter] = arr[left];
//                    finalarr[counter] = arr[right];
//                }
            }
            if(currsum < targetSum) left++;
            if(currsum > targetSum) right--;
        }
        return new int[] {-1, -1};
        //return finalarr;
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.findingNoPair(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.findingNoPair(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
