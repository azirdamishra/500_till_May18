package com.company;
/*
For each friend, can you help Chef find out if this friend
 will be able to attend the meeting? More formally,
 check if Li≤P≤Ri for each valid i.

 HH:MM AM or HH:MM PM
 no of char = 8
 */
public class FebLong3 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- >0){
            String chefTime = in.readString();
            int numFrens = in.readInt();
            int [] frenTimings = new int[2*numFrens];
            for (int i = 0; i < 2*numFrens; i++) {
                String str = in.readString();
                //str = str.substring(0,2) + str.substring(3,5);
//                if(str.charAt(6) == 'A'){
//                    frenTimings[i] = Integer.parseInt(str);
//                }
//                if(str.charAt(6) == 'P'){
//                    frenTimings[i] = Integer.parseInt(str) + 1200;
//                }
            }
            char AmorPm = chefTime.charAt(6);
            chefTime = chefTime.substring(0,2) + chefTime.substring(3,5);
            int chefTimeInt = Integer.parseInt(chefTime);
            if(AmorPm == 'P') chefTimeInt += 1200;
            String answerStr = "";
            for (int i = 0; i < frenTimings.length; i+=2) {
                if(chefTimeInt < frenTimings[i+1] && chefTimeInt > frenTimings[i]){
                    answerStr += "1";
                }else answerStr += "0";
            }
            System.out.println(answerStr);

        }
    }
}
