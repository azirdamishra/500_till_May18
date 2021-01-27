package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowelsInGivenSubstrLen {
    //private static final String[] VOWELS = new String[]{"a", "e", "i", "o", "u"};

    public static int maxVowels(String s, int k){
        int windowEnd = 0;
        int windowStart = 0;
        int vowelNo = 0;
        int maxNo =0;
        Set<Character> vowelList = new HashSet<>();
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');

        for(; windowEnd<s.length(); windowEnd++){
            if(vowelList.contains(s.charAt(windowEnd))) vowelNo++;

            if(windowEnd-windowStart+1 > k){
                if(vowelList.contains(s.charAt(windowStart))) vowelNo --;
                windowStart++;
            }

            maxNo = Math.max(maxNo, vowelNo);
        }
        return maxNo;

    }
}
