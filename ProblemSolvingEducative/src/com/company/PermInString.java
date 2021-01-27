package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class PermInString {
    public static void FindPermInStr(String given, String pattern){
        HashMap newSet = new HashMap<String, Integer>();
        for(int i = 0; i< pattern.length();i++){
            if(newSet.get(pattern.charAt(i)) == null){
                newSet.put(pattern.charAt(i), 1);
            }
            else{
                //Integer count = newSet.get(pattern.charAt(i));

            }
        }
    }
}
