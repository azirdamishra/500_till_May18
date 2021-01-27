package com.company;

public class GrumpyOwner {
    public static int maxSatisfied(int [] customers, int [] grumpy, int mins){
        int windowEnd = 0;
        int windowStart = 0;
        int initialSatisf = 0;
        int maxWinSum = 0;
        int sum = 0;
        //int counter = 0;

//        for(int i = 0; i<customers.length;i++){
//            if(grumpy[i] == 0) initialSatisf += customers[i];
//        }

        for(; windowEnd<customers.length; windowEnd++){
            if(grumpy[windowEnd] == 0) initialSatisf += customers[windowEnd];
            if(grumpy[windowEnd] == 1){
                sum += customers[windowEnd];
            }

            if(mins < windowEnd - windowStart + 1){
                if (grumpy[windowStart]==1) sum -= customers[windowStart];
                windowStart++;
            }
            maxWinSum = Math.max(maxWinSum, sum);
        }

        return initialSatisf + maxWinSum;
    }

    public static void main(String[] args) {
        int [] customers = new int[] {1,0,1,2,1,1,7,5};
        int [] grumpy = new int[] {0,1,0,1,0,1,0,1};
        int mins = 3;
        System.out.println(GrumpyOwner.maxSatisfied(customers, grumpy, mins));
    }
//&& mins != customers.length && mins != 1
}
