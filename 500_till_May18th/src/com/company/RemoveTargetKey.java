package com.company;

public class RemoveTargetKey {
    private static int arrayWoutKey(int [] arr, int key){
        int fast = 0;
        int slow = 0;
        for (; fast < arr.length; fast++) {
            //let the counter keep moving if the IF statement is false
            if(arr[fast] != key){
                //slow = fast;
                if(slow < arr.length){
                    slow++;
                    arr[slow] = arr[fast];
                }

            }
        }
        return slow; //slow is an index
    }
    public static void main(String[] args) {
        int result = arrayWoutKey(new int[] {3, 2, 3, 6, 3, 10, 9, 3}, 3);
        System.out.println(result);
    }
}
