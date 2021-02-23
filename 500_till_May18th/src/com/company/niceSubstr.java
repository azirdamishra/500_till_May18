package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class niceSubstr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(longestNiceSubstr(s));
    }
    public static String longestNiceSubstr(String s){
        //using divide and conquer algorithm
        if(s.length() < 2) return "";
        char[] arr = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for(char ch: arr){
            charSet.add(ch);
        }
        for (int i = 0; i < arr.length; i++) {
            char letter = arr[i];
            if(charSet.contains(Character.toLowerCase(letter)) && charSet.contains(Character.toUpperCase(letter))) continue;
            String subStr1 = longestNiceSubstr(s.substring(0,i));
            String subStr2 = longestNiceSubstr(s.substring(i+1));
            return subStr1.length() >= subStr2.length()? subStr1 : subStr2;
        }
        return s;
    }
}
