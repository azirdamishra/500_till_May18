package com.company;

import java.util.Arrays;

public class SmallestPair {
    public static void main(String args[]){
        InputReader input = new InputReader(System.in);
        int t = input.readInt();
        while (t-- >0){
            int size = input.readInt();
            int [] arr = new int[size];

            for(int i = 0; i<size; i++){
                arr[i] = input.readInt();
            }

            //int left = 0;
            //int right = size - 1;
            int minSum = 0;
            //int sum = 0;

            Arrays.sort(arr);
            minSum = arr[0] + arr[1];

            System.out.println(minSum);

        }
    }
}
