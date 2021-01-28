package com.company;

import java.util.HashMap;
import java.util.Map;
// I DON'T GET THE FUCKIN CODE
//I am going to try to draw parallels here from my code
public class minWindowSubstr {
    //my method sucked which was smallestWindowWithSubstr
    public static String findSubstring(String str, String pattern){
        int start = 0, end = 0, startOfSubstr = 0, counter = 0;
        int minlength = str.length() +  1;
        Map<Character, Integer> charMap = new HashMap<>();
        for(char chr: pattern.toCharArray()){
            charMap.put(chr, charMap.getOrDefault(chr, 0)+1);
        }
        //we start with extending the window
        for(; end<str.length(); end++) {
            char rightChar = str.charAt(end);
            if (charMap.containsKey(rightChar)) {
                charMap.put(rightChar, charMap.get(rightChar) - 1);
                if(charMap.get(rightChar) >= 0) counter++;
            }

            //shrink the window
            while (counter == pattern.length()){
                //System.out.println(counter + " first counter");
                if(minlength > end - start + 1){
                    minlength = end - start +1;
                    startOfSubstr =  start;
                }
                //System.out.println(minlength + " minlength in loop");
                //System.out.println(start);
                char leftChar = str.charAt(start++);
                //System.out.println(start);
                //note that we could have redundant matching characters, therefore we'll decrement the
                // matched count only when a useful occurrence of a matched character is going out of the window
                if(charMap.containsKey(leftChar)){
                    //System.out.println(charMap.get(leftChar));
                    if(charMap.get(leftChar) == 0) counter--;
                    //System.out.println(counter + " counter in loop");
                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                }
            }

        }
        return minlength > str.length()? "": str.substring(startOfSubstr, startOfSubstr+minlength);

    }
    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));

    }
}
