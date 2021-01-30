package com.company;

import java.util.Arrays;

public class Chef30Jan1 {
    public static void main(String[] args) {
        InputReader input = new InputReader(System.in);
        int t = input.readInt();
        while (t-- >0){
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = input.readInt();
            }

            Arrays.sort(arr);
            if(arr[0] + arr[1] == arr[2]) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
