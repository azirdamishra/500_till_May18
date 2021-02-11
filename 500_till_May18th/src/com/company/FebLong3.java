package com.company;

import java.util.Scanner;

/*
For each friend, can you help Chef find out if this friend
 will be able to attend the meeting? More formally,
 check if Li≤P≤Ri for each valid i.

 HH:MM AM or HH:MM PM
 no of char = 8
 */
public class FebLong3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        //imp input taking: https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/
        while (t-- > 0){
            String[] meetingTime = in.nextLine().split(" ");

            int meetingTimeInt = convertToNum(meetingTime[0],meetingTime[1]);

            int noOfFrens = Integer.parseInt(in.nextLine());

            String answer = "";

            while (noOfFrens-- >0){
                String[] st = in.nextLine().split(" ");
                int first = convertToNum(st[0], st[1]);
                //System.out.println("This is first " + first);

                int second = convertToNum(st[2], st[3]);
                //System.out.println("This is second "+ second);
                if(isItWithin(first, second, meetingTimeInt)){
                    answer += "1";
                }
                else answer += "0";
            }

            System.out.println(answer);

        }

    }
    private static int convertToNum(String time, String amOrpm){
        if(time.substring(0,2).equals("12") && amOrpm.equals("AM")){
            return Integer.parseInt("00" + time.substring(3,5));
        }

        int number = Integer.parseInt(time.substring(0,2) + time.substring(3,5));
        if(amOrpm.equals("PM") && !time.substring(0,2).equals("12")) number += 1200;
        return number;
    }

    private static boolean isItWithin(int start, int end, int time){
        return time >= start && time <= end;
    }

}
/*          Note:
            int ni = in.readInt();
            int mi = in.readInt();
            System.out.println(ni);
            System.out.println(mi);
            Input:
            1
            2 3
            Output:
            2
            3
            //even computations work in the middle of the input
             */