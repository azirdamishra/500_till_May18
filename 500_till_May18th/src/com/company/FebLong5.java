package com.company;

import java.util.*;
/*
got 20 out of 100 points -- attempted again in FebLong5but2.java
 */
public class FebLong5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while (t-- >0){
            //int num = Integer.parseInt(in.nextLine());
            int num = in.nextInt();
            Set<String> funnyWordSet = new HashSet<>();
            String[] funnyWords = new String[num];
            for (int i = 0; i < num; i++) {
                funnyWords[i] = in.next(); //should not be nextLine()
                funnyWordSet.add(funnyWords[i]);
            }
            int count = 0;
            int left = 0, right = funnyWords.length-1;

            for(; left<funnyWords.length; left++){

                while (left<right){
                    String word1 = funnyWords[left];
                    String word2 = funnyWords[right];

//                    if(word1.charAt(0) == word2.charAt(0)){
//                        right--;
//                        if(right == left) right = funnyWords.length-1;
//
//                    }

                    if(checkWord(word1, word2, funnyWordSet)) count++;

                    right--;
                }
                right = funnyWords.length-1;

            }

            System.out.println(count * 2);

        }
    }
    private static boolean checkWord(String word1, String word2, Set<String> funnyWords ){

        if(funnyWords.contains(word1.charAt(0) + word2.substring(1))
                || funnyWords.contains(word2.charAt(0) + word1.substring(1))){
            return false;
        }

        return true;

    }
}
