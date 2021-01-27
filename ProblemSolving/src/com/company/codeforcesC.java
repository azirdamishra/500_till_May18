package com.company;
import java.util.*;
import java.io.*;
//import java.math.*;

public class codeforcesC {
    public static void main(String args[]) throws Exception {
        //taking input
        Scanner scan = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int arrsize = scan.nextInt();
        int allowedReplacements = scan.nextInt();
        int [] arr = new int[arrsize];
        for(int i = 0; i < arrsize; i++){
            arr[i] = scan.nextInt();
        }
        // solution start
        int windowStart = 0;
        int ones = 0;
        int maxSize = 0;
        int r = 0;
        int l = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            if(arr[windowEnd] == 1){
                ones++;
            }
            if(windowEnd - windowStart + 1 - ones > allowedReplacements){
                if(arr[windowStart] == 1) ones --;
                windowStart++;
            }
            if (maxSize < windowEnd - windowStart + 1) {
                l = windowEnd;
                r = windowStart;
            }
            maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
        }

        out.write(Integer.toString(maxSize));
        out.newLine();

        for(int i = 0; i< arr.length; i++){
            if (maxSize > 0)
                if(i >= r && i<= l) arr[i] = 1;
            out.write(arr[i] + " ");
        }
        out.newLine();

        out.close();
    }
}