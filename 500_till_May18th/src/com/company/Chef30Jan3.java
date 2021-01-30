package com.company;

public class Chef30Jan3 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- >0){
//            int[] two = new int[2];
//            for(int i = 0; i<2; i++){
//                two[i] = in.readInt();
//            }
//            int noOfQues = two[0];
//            int secLimit = two[1];
            int noOfQues = in.readInt();
            int secLimit = in.readInt();
            int[] arr = new int[noOfQues];
            int isNegative = 0;
            int oneSec = 0;
            boolean moreThanSecLim = false;

            for (int i = 0; i < noOfQues; i++) {
                arr[i] = in.readInt();
                if(arr[i] == -1) isNegative++;
                if(arr[i] <= 1 && arr[i] != -1) oneSec++;
                if(arr[i] > secLimit) moreThanSecLim = true;
            }

            if(isNegative <= noOfQues/2){
                if(!moreThanSecLim){
                    if(oneSec != noOfQues){
                        System.out.println("Accepted");
                    }else System.out.println("Bot");
                }else System.out.println("Too Slow");

            }else System.out.println("Rejected");


        }
    }
}
