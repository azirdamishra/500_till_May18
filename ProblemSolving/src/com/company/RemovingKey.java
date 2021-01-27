package com.company;

public class RemovingKey {
    public static int remove(int [] arr, int k){
        int slow = 0;
        for(int fast = 0; fast < arr.length; fast++){
            if(arr[fast] != k){
                arr[slow] = arr[fast];
                slow++;
            }
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(RemovingKey.remove(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(RemovingKey.remove(arr, 2));
    }
}
