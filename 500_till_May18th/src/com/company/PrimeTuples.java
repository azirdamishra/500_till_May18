package com.company;

import java.util.Arrays;

//codechef problem
/*
Find the no of good tuples that can be formed by
integers from 1 to N
good tuple (a,b,c) iff a + b = c
 */

public class PrimeTuples {
    public static void main(String[] args) throws Exception {
        //System.out.println(isItPrime(35));
        InputReader input = new InputReader(System.in);
        int t = input.readInt();
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int t = Integer.parseInt(reader.readLine());
        boolean[] primeArr = new boolean[100001];
        Arrays.fill(primeArr, true);
        primeArr[0] = false;
        primeArr[1] = false;
        for (int i = 2; i <= 100000; i++) {
            if(primeArr[i])
                for (int j = 2*i; j < 100001; j+= i) {
                    primeArr[j] = false;
                }
        }
        int[] ansarr = new int[100001];
        for (int i = 0; i < 100001; i++) {
            //check whether the number i suits the observation in the if statement below
            //if so then increase its value in the answer array by 1 (else it will remain
            //0 as initiated)
            if(i-2 >= 0 && primeArr[i] && primeArr[i-2])ansarr[i]++;
            //following the if statement increase the value by the previous array elements'
            //to include the previous such sums as well
            if(i-1>= 0) ansarr[i] += ansarr[i-1];
        }

        while (t-- > 0){
            int numbers = input.readInt();
            //int numbers = Integer.parseInt(reader.readLine());

            int counter = 0;
            int tuples = 0;

            System.out.println(ansarr[numbers]);
            //simply print the answer as stored in the answer array so its only an
            //array access that is required
            }


        }

    //Doing it Erathosthese' way
//    private static boolean isPrime(int num){
//
//    }


    //finding whether a given number is prime
    private static boolean isPrime(long num){
        //weed out all the obvious answers
        if(num<2) return false;
        if(num == 2 || num == 3 || num == 5) return true;
        if(num%2 == 0 || num % 3 == 0 || num % 5 ==0) return false;
        long sqrtOfNum = (long) Math.sqrt(num);
        for(long i = 6L; i<= sqrtOfNum; i+=6){
            System.out.println(i);
            if(num%(i-1) == 0 || num%(i+1) == 0) return false;
        }
        //least number of iterations
        return true;
    }


}
