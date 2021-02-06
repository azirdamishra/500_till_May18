package com.company;

import java.util.Arrays;

public class FebLong2 {
    //using sliding window
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- >0){
            int size = in.readInt();
            long[] arr = new long[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.readInt();
            }
            Arrays.sort(arr);
            int center = 1;

//            for (int i = 0; i < arr.length; i++) {
////                int left = i + 1;
////                int right = arr.length -1;
////                while (right > i){
////                    //int currSum = function(i, left, right, arr);
////                }
//            }
            long maxSum = Math.abs(arr[0] - arr[center])
                    + Math.abs(arr[center] - arr[size-1])
                    + Math.abs(arr[0] - arr[size-1]);
            System.out.println(maxSum);

        }
    }
//    private static int function(int i, int left, int right, int[] arr){
//        return Math.abs(arr[i] - arr[left])
//                + Math.abs(arr[left] - arr[right])
//                + Math.abs(arr[right] - arr[i]);
//    }
}
