package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string and a pattern, find all anagrams of the pattern in the given string.
Anagram is actually a Permutation of a string
Sliding Window -- Educative
 */
public class StringAnagrams {
    public static List<Integer> findAnagramIndices(String str, String pattern){
        List<Integer> result = new ArrayList<Integer>();
        //we need to find first indices of all windows with pattern in str
        //proceed in the same way as before ?
        //instantiated the map
        Map<Character, Integer> charMap = new HashMap<>();
        for(char chr: pattern.toCharArray()){
            charMap.put(chr, charMap.getOrDefault(chr, 0) + 1);
        }

        int end = 0, start = 0;
        //int indices = 0; //will help us store the starting indices and put them in the result list
        int counter = 0;

        for(; end<str.length(); end++){
            char rightChar = str.charAt(end);
            if(charMap.containsKey(rightChar)){
                //result.add(end);
                charMap.put(rightChar, charMap.get(rightChar)-1);
                if(charMap.get(rightChar) == 0) counter++;
            }

            if(end - start + 1 >= pattern.length()){
                if(counter == charMap.size()) result.add(start);
                //indices can be added when the window reduction is happening and counter == size of the map
                char leftChar = str.charAt(start++);
                if(charMap.containsKey(leftChar)){
                    if(charMap.get(leftChar) == 0){
                        counter--;
                    }
                    charMap.put(leftChar, charMap.get(leftChar)+1);
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagramIndices("abbcabc", "abc"));
    }
}
