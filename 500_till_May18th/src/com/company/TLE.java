package com.company;

import java.util.Arrays;

public class TLE {
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        int[] arr = new int[100000];
        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= 100000; i++) {
            if(isPrime[i])
            for (int j = 2*i; j < 100001; j+= i) {
                isPrime[j] = false;
            }
        }
        long et = System.currentTimeMillis();
        System.out.println(et - st);
        for (int i = 0; i < 100;i++) {
            if(isPrime[i]) System.out.println(i);
        }
    }
}
