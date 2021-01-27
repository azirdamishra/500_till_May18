package com.company;

import java.util.Scanner;

public class primeTuples {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- >0){
            int num = sc.nextInt();
            int [] arr = new int[num];
            int counter = 0;
            for(int i = 2; i<=num; i++){
                if(isPrimeOrNot(i)) arr[counter] = i;
                //System.out.println(arr[counter] + " " + counter);
                counter++;
            }
            int finalsum = 0;
            //int pointer = 0;
            for(int i = 2; i < counter; i++){
                if( arr[i-2] + arr[0] == arr[i]) finalsum++;
                //System.out.println(arr[i]);
            }
            System.out.println(finalsum);
        }
    }

//    private static boolean isPrime(int num){
//        for(int i = 2; i <= num/2; i++){
//            if(num % i == 0) return false;
//        }
//        return true;
//    }
    static int a = 2;
    private static boolean isPrimeOrNot(int num){
        if(num == 0 || num == 1) return false;

        if(num == a) return true;

        if(num % a == 0)return false;
        a++;
        return isPrimeOrNot(num);
    }
}
