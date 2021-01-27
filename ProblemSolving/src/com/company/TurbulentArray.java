package com.company;

public class TurbulentArray {
    public static int longestTurbulentSubarr(int[] arr){
        //we will make two methods
        //one in which odd is always greater than even
        //two in which even is always greater than odd
        //both methods would return the max length that they find
        //we have two max lengths for each and then have max of both in the end
        boolean flag = true;
        for(int i = 0; i<arr.length;i++){
            if(arr[i] != arr[0] ) flag = false;
        }
        if(flag)return 1;
        //if(arr.length == 1) return 1;
        int max1 = oddIsAlwaysGreater(arr);
        int max2 = EvenIsAlwaysGreater(arr);
        return Math.max(max1, max2);
    }
    private static int oddIsAlwaysGreater(int[] arr){
        int length = 2;
        int maxLength = 0;
        for(int pointer = 1; pointer<arr.length; pointer++){
            if(pointer + 1 == arr.length){
                return maxLength = Math.max(maxLength, length);
            }
            if(pointer % 2 != 0){
                if(arr[pointer]>arr[pointer+1] && arr[pointer] >arr[pointer-1])length++;
                else length = 2;
            }else {
                if(arr[pointer]<arr[pointer+1] && arr[pointer] <arr[pointer-1])length++;
                else length = 2;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    private static int EvenIsAlwaysGreater(int [] arr){
        int length = 2;
        int maxLength = 0;
        for(int i = 1; i< arr.length; i++){
            if(i + 1 == arr.length){
                return maxLength = Math.max(maxLength, length);
            }
            if(i % 2 == 0){
                if(arr[i]>arr[i+1] && arr[i] >arr[i-1])length++;
                else length = 2;
            }else {
                if(arr[i]<arr[i+1] && arr[i] <arr[i-1])length++;
                else length = 2;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
