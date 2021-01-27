package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;


/*
how will bitwise manipulation make it easier?? this is wayy to complicated
    https://www.geeksforgeeks.org/bits-manipulation-important-tactics/
    https://discuss.codechef.com/t/fibeasy-editorial/37931
    https://www.topcoder.com/community/competitive-programming/tutorials/a-bit-of-fun-fun-with-bits/
    https://www.codingninjas.com/events/workshop-on-bit-manipulation-for-programming-tasks-interviews
    https://www.codingninjas.com/blog/2020/08/29/bit-manipulation-for-competitive-programming/

 */
public class createFibonacci {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int inputs = sc.nextInt();
        while (inputs-- > 0){
            int length = sc.nextInt();
            float[] arr = new float[length];
            arr = createDeciFibonacci(length);
            int rounds = 0;

            while(rounds < arr.length/2 - 1){
                int counter = 0;
                for(int i = 0; i<arr.length; i++){
                    arr[i] = arr[counter];
                    counter +=2;
                }
                rounds++;
            }



        }
    }
    public static float[] createDeciFibonacci( int length){
        float arr[] = new float[length];
        arr[0] = 0;
        arr[1] = 1;
        DecimalFormat df2 = new DecimalFormat("#.#");
        for(int i = 2; i< arr.length; i++){
            arr[i] = arr[i-2] + arr[i-1];
            arr[i] = (float)0.10*arr[i];
            arr[i] = Float.parseFloat(df2.format(arr[i]));
            arr[i] = 10 * arr[i];
        }
        arr[0] = Float.parseFloat(df2.format(arr[0]));
        arr[1] = Float.parseFloat(df2.format(arr[1]));
        return arr;
    }
}
