package com.company;

import java.util.Scanner;
/*
        1 2 3 4 5
        1 2 3 4 5
        if we gave 0 0 0 0 3 balloons then -- 5*2 + 4*4 + 3*3 + 2*2 + 1 candies to be given
        in this we have not minimised the cadies to be given out on the 4th day as there obviously
        exists anothe way to get lesser candies on the 4th day
        if we gave 0 0 0 1 2 balloons then -- 3*4 + 5*3 + ... candies to be given -- minimises the
        oveall value and so the second one is the right answer

       ==> the question states to minimise the no of candies that are to be given per day and
       not overall and so, we see that while overall we may be giving more, we have minimised
       it over each day
         */
public class HMAPPY {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //n is number of days and m is no of balloons
        int N = in.nextInt(); //range is till 10^5
        long M = in.nextLong(); //range is till 10^18
        long[] balloonsPerDay = new long[N];
        long[] compensatingCandies = new long[N];
        for (int i = 0; i < balloonsPerDay.length; i++) {
            balloonsPerDay[i] = in.nextLong();//A[i]
        }
        for (int i = 0; i < compensatingCandies.length ; i++) {
            compensatingCandies[i] = in.nextLong();//B[i]
        }

        long low = 0;
        long high = (long) 1e18;
        while (high>low){
            long mid = low + (high- low)/2; //number of candies **
            //check if the no of candies that we pick for a day is enough to consume the balloons
            //provided or are more balloons left ie is sum <= M
            if(check(mid, compensatingCandies, balloonsPerDay, M)){
                //if sum <= m this means that we have found the right k and now k needs to decrease
                high = mid;
            }else {
                //if the sum is > m this means that the no of candies is insufficient and needs to
                //be increased
                low = mid + 1;
            }
        }
        System.out.println(low); //need to return the maximum of the total min cadies that we give
        // each day as compensation -- this we get by simple maths

    }
    private static boolean check(long mid, long[] candies, long[] balloons, long M){
        //M is the no of balloons provided
        long sum = 0;
        for (int i = 0; i < balloons.length; i++) {
            long balloonsNeeded = balloons[i] - (mid/candies[i]);
            sum += Math.max(0, balloonsNeeded);
        }
        return sum <= M;
    }
}
