package com.company;

import java.util.HashMap;
import java.util.*;

public class LongestRepeatingSubstr {
    public static int replaceAndReturn(String s, int k){
        int windowEnd = 0, windowStart = 0, maxRepeatedLength = 0, maxWindowLength = 0;
        Map<Character, Integer> LetterFreqMap = new HashMap<>();

        for(;windowEnd<s.length(); windowEnd++){
            char rightchar = s.charAt(windowEnd);
            LetterFreqMap.put(rightchar, LetterFreqMap.getOrDefault(rightchar, 0)+1);
            maxRepeatedLength = Math.max(maxRepeatedLength, LetterFreqMap.get(rightchar));

            if(windowEnd - windowStart + 1 - maxRepeatedLength > k){
                char leftchar = s.charAt(windowStart);
                LetterFreqMap.put(leftchar, LetterFreqMap.get(leftchar)-1);
                windowStart++;
            }
            maxWindowLength = Math.max(maxWindowLength, windowEnd-windowStart+1);
        }
        return maxWindowLength;
    }
}
