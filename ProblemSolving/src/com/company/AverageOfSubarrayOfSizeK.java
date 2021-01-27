package com.company;
import java.util.Arrays;
public class AverageOfSubarrayOfSizeK {

    public static double[] findAverages(int K, int[] arr){
        double [] result = new double[arr.length - K + 1]; //length of the array that contains the final result of what the method does
        double windowSum = 0;
        int windowStart = 0; //the first element of the k window that keeps changing as the window shifts
        //windowStart just makes work easier
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd]; //store the sum of the window
            if(windowEnd >= K - 1){
                // the above is done so that we stop when the iteration reaches windowEnd = 4 as
                // it now has 5 elements and this makes the bout for the first window
                // then we keep this window constant and its values changing by accessing the
                // if loop everytime after windowSum = 4
                result[windowStart] = windowSum/ K ; //calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; //slide the window ahead
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
