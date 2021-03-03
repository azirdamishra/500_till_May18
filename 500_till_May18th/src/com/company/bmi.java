package com.company;

import java.util.Scanner;

public class bmi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- >0){
            int mass = in.nextInt();
            int height = in.nextInt();
            int bmindex = mass/(height* height);
            if(bmindex <= 18) System.out.println(1);
            if(bmindex<=24 && bmindex >=19) System.out.println(2);
            if(bmindex<=29 && bmindex >= 25) System.out.println(3);
            if(bmindex >= 30) System.out.println(4);
        }
    }
}
