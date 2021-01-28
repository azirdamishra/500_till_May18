package com.company;

/*
Educative problem set -- sliding window
finding if any perm of str 1 is present in str 2
Given a string and a pattern, find out if the string contains any permutation of the pattern.
 */

import java.util.HashMap;
import java.util.Map;
//assuming no repetition in str 1
//wrong assumption
public class PermsInString {
    private static boolean findPermInStr(String mainString, String pattern ){
        //str1 is the pattern and str2 is the given string
        //GIVE BETTER NAMES

        //Set<Character> set = new HashSet<>();
        //we need a HashMap to count the frequencies as well
        //I am also faltering in the steps methinks
        Map<Character, Integer> charMap = new HashMap<>();
        for(char ch : pattern.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch, 0)+ 1);
        }
        int counter =  0;
        int start = 0;
        int end = 0;
        //this for loop will help us match all characters in the Hashmap to all characters in our current window whose
        //size needs to be compared to str1
        for(; end < mainString.length(); end++){
            char right = mainString.charAt(end);

            if(charMap.containsKey(right)){
                //decrement the frequency of the letter in the Hashmap
                charMap.put(right, charMap.get(right)-1);
                counter++;
//                if(charMap.get(right) == 0){
//                    counter++;
//                }
            }
            //if(counter == charMap.size()) return true; //no of key value pairs in the mapping not their frequency
            if(counter == pattern.length()) return true;

            //the window needs to be shrunk if it proceeds ahead
            if(end >= pattern.length()-1){ //but here the window size is using str1 or pattern length
                char left = mainString.charAt(start++);//the old left char is now at the old start location of str2
                if(charMap.containsKey(left)){
                    //increment the frequency because it is being removed from the window
                    //or put it back in if its frequency is zero
//                    if(charMap.get(left) == 0){
//                        counter--;
//                        /*
//                        the counter keeps a check whether all the key value pairs get matched if the frequency is zero
//                        this is the criteria that helps us get out of the loop and efficiently check if the Hashmap is
//                        empty
//                        Why don't we use the criteria of counter == size of str1 ??
                    //I checked we can. There is no problem, just a different way of writing code
                    //I have changed my own code accordingly
                    // I think it just takes slightly more time in one of the other
//                         */
//
//                    }
                    charMap.put(left, charMap.get(left) + 1);
                    counter--;
                }
            }

        }
        //System.out.println("Hello");
        return false;
    }

    public static void main(String args[]){
        boolean value = findPermInStr("oidbcaf", "ab");
        System.out.println(value);
    }
}
