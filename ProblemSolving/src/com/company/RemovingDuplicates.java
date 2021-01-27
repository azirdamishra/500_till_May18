package com.company;

public class RemovingDuplicates {
    public static int removeNo(int [] arr){
        int slow = 1;// next pointing at a repeated element
        for(int i = 0; i < arr.length; i ++){
            if(arr[slow-1] != arr[i]){
                arr[slow] = arr[i];
                slow++;
            }
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemovingDuplicates.removeNo(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemovingDuplicates.removeNo(arr));
    }
}
