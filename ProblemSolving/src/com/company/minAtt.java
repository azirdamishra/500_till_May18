//package com.company;
/* package codechef; // don't place package name! */
import java.util.Scanner;
/* Name of the class has to be "Main" only if the class is public. */
public class minAtt {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int inputs = sc.nextInt(); //read user input

        for(int k = 0; k<inputs; k++){
            int pastDays = sc.nextInt();
            String days = sc.next();
            int counter = 0;
            int daysSure = 120-pastDays;

            for(int i= 0; i<pastDays; i++){
                char digit = days.charAt(i);
                if(digit =='1' )counter++;
            }
            //System.out.println(counter);
            //int num =
            if(counter+daysSure >= (float)(0.75 * 120))System.out.println("YES");
            else System.out.println("NO");
        }

    }
}
