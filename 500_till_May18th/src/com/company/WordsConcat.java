package com.company;

import java.util.ArrayList;
import java.util.List;
//Incomplete

public class WordsConcat {
    //educative
    /*
    Given a string and a list of words, find all the starting indices of substrings
    in the given string that are a concatenation of all the given words exactly once
    without any overlapping of words. It is given that all words are of the same
    length.
     */
    public static List<Integer> findWordConcatenation (String str, String[] words){
        List<Integer> resultIndices = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            if(!str.contains(words[i])) {
                return resultIndices;
            }
        }


        return resultIndices;
    }


}
