package com.company;

import java.util.Scanner;

public class SelfDestrStr {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i< n; i++){
            int countingOnes = 0, countingZeros = 0;
            String str = sc.next();
            if(str.length() % 2 != 0){
                System.out.println(-1);
                //System.out.println("hi");
                continue;
            }
            int a[] = new int[str.length()];
            for( int j = 0; j< str.length(); j++){
                a[j] =  Character.getNumericValue(str.charAt(j));//numeric value in the array
                if(a[j] == 1) countingOnes++;
                else countingZeros++;
            }

            int k = Math.abs(countingOnes-countingZeros);

            if(countingOnes == a.length){
                System.out.println(-1);
                //System.out.println("hi2");
                continue;
            }
            if(countingZeros ==  a.length){
                System.out.println(-1);
                //System.out.println("hi3");
                continue;
            }

            //our string has some values of 0s and 1s and it is even in length
            //after calculations we will know if it is a self destructing string

            /*
            so what they said in the question is that we would need to convert this string to a self destruct string
            this would most happen if we have same number of zeroes and ones --> return 0 because no change would be required
            as I have tried and it makes sense i guess?
            But if the nos of 0s and 1s are different then we will have to invert
            Now the rule of inversion is that we pucca need 01 or 10, which means even for inversion we will need a pairing
            We will need to invert before we do the destruction, so we would need to be smart about it
            This means that the excess amount of 0 or 1 would need to be converted to the other number to make the nos equal
            This means (Ones - zeroes)/2 would give me the no of inversions needed to be made

            side note: this all makes sense intuitively but I want written proof lol
            Can I not visualise? it makes sense for equals, so it makes sense for inversion also
             */

            if(k == 0){
                System.out.println(0);
            }
            else{
                k /= 2;
                System.out.println(k);

            }


        }
    }
}
