package com.company;
import java.util.*;
import java.util.logging.Level;

//assuming there are no repeated letters in str 1
public class PermInString {
    public static boolean checkInclusion(String s1, String s2) {
        int lengthOfWindow = s1.length();
        int counter = 0;
        char leftChar = '\0';
        int windowStart =0;
        //Map<Character, Integer> LettersFreqn = new HashMap<>();
        Set<Character> str1 = new HashSet<>();
        for (int i = 0; i < lengthOfWindow; i++) {
            //add the letters in s1 to the set so that they can be checked off later
            //LettersFreqn.put(s1.charAt(i), LettersFreqn.getOrDefault(s1.charAt(i), 0) + 1);
            str1.add(s1.charAt(i));
        }
        for(int windowEnd = 0; windowEnd<s2.length(); windowEnd++){
            char rightChar = s2.charAt(windowEnd);

            if(str1.contains(rightChar)&& counter ==0){
                windowStart = windowEnd;
                leftChar = rightChar;
                str1.remove(rightChar);
                counter++;
            }
            while (str1.contains(rightChar) && counter < lengthOfWindow+1 && leftChar == s2.charAt(windowStart) ){
                leftChar = rightChar;
                str1.remove(rightChar);
                windowStart++;
                counter++;
            }
//            if(windowEnd-windowStart + 1 > lengthOfWindow){
//                windowStart++;
//            }
        }
       return counter == lengthOfWindow;
    }
    public static void main(String[] args){
        System.out.println(checkInclusion("dc", "oidbcaf"));
    }
}
