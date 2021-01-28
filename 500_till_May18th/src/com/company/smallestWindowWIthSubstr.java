package com.company;

/*
Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
 */
//need to redo i am quite close what to do???

import java.util.HashMap;
import java.util.Map;

public class smallestWindowWIthSubstr {
    private static String smallestSubstr(String str, String pattern){
        /*
         finding the smallest substring, even with other letters such that it contains all the
         letters of the pattern
         */
        //need a hashmap
        Map<Character, Integer> charMap = new HashMap<>();
        for(char chr: pattern.toCharArray()){
            charMap.put(chr, charMap.getOrDefault(chr, 0)+1);
        }
        int end = 0, start = 0, counter = 0; //counter here is not for the mapsize but for the characters that are being removed
        //int minLenOfSubstr = 0;
        String finalSubstr= str;

        for(;end < str.length(); end++){
            //start will be positioned where the first letter of the pattern is found
            char rightChar = str.charAt(end);
            char leftChar;
            if(charMap.containsKey(end) && counter == 0){
                //we have the first character of pattern in str
                //we decrement its freqn, increment counter and put start here meanwhile introducing leftChar
                charMap.put(rightChar, charMap.get(rightChar) -1);
                counter++;
                start = end;
                //leftChar = str.charAt(start);
            }

            //now we decrease the freqn and inc the counter for all of the other letters in the str till we find that
            // all the freqn in the map has become zero or that the counter = size of pattern
            if(charMap.containsKey(end) && counter>0){
                charMap.put(rightChar, charMap.get(rightChar) -1);
                counter++;
                //System.out.println(counter + " yo");
            }

            //this now means that the string contains in its first and last letters the letters of pattern and also them
            //in between and so needs to be shortened to find other such string
            //here we use this 'if' to store this string and decrease the window size
            if(counter == pattern.length()){
                String result = str.substring(start, end);
                if(result.length() < finalSubstr.length()){
                    finalSubstr = result;
                }
                //saved the string now decrease the window
                start++;
                leftChar = str.charAt(start);
                while (!charMap.containsKey(leftChar) && start<=end){
                    leftChar = str.charAt(start);
                    start++;
                    counter--;
                    System.out.println("Hi");
                }
                //so start will land on the letter which is contained in the charMap thus starting the new window
                //counter keeps track of the window size so it is imp to decrement
                //and now the end can continue whatever it was doing
            }

        }
        System.out.println(counter);
        if(counter == pattern.length()) return finalSubstr;
        return "";

    }

    public static void main(String[] args) {
        System.out.println(smallestSubstr("aabdec", "abc"));

    }
}
