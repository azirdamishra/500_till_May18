package com.company;
import java.util.*;
public class noRepeatSubstr {
    public static int findLength(String str) {
        int slow = -1;
        int fast = 0;
        int ans = 0;
        Set<Character> uniqueCharsOfSlidingWindow = new HashSet<>();
  	/*
		a      b e d        e   f
		slow              fast
		uniqueCharsOfSlidingWindow -> (a, b, c, d)
  	*/
        for (; fast < str.length(); fast++) {
            //element at fast
            while (uniqueCharsOfSlidingWindow.contains(str.charAt(fast))) {
                uniqueCharsOfSlidingWindow.remove(str.charAt(++slow));
            }
            uniqueCharsOfSlidingWindow.add(str.charAt(fast));
            ans = Math.max(ans, uniqueCharsOfSlidingWindow.size());
        }
        return ans;
    }
}
