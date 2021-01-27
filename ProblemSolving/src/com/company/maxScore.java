package com.company;

public class maxScore {
    public static int maximumValue(int [] cardPoints, int k){
        int c1 = 0;
        int c2 = cardPoints.length-1;
        int sum1 =0 ,sum2 = 0;
        while (c1<k){
            sum1 += cardPoints[c1];
            c1++;
            sum2 += cardPoints[c2];
            c2--;
        }
        return Math.max(sum1,sum2);
    }
}
