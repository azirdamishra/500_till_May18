package com.company;

import java.util.*;

/*
one part was wrong so second attempt
 */
public class FebLong5but2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while (t-- >0){
            int number = Integer.parseInt(in.nextLine());
            Set<String> funnyWordSet = new HashSet<>();
            Map<Character, Integer> firstLetters = new HashMap<>();
            Map<String, Integer> restWords = new HashMap<>();

            int[] firstLStr = new int[number];
            int[] restWStr = new int[number];
            boolean flag1 = false;
            boolean flag2 = false;
            int counter = 0;
            //String[] funnyWords = new String[number];
            for (int i = 0; i < number; i++) {
                //funnyWords[i] = in.next(); //should not be nextLine()
                String st = in.next();
                funnyWordSet.add(st);
                //String key = st.substring(0,1);
                firstLetters.put(st.charAt(0),
                        firstLetters.getOrDefault(st.charAt(0),0) + 1);
                restWords.put(st.substring(1), restWords.getOrDefault(st.substring(1), 0) + 1);
            }
            //total pairs possible are nC2 where n = number
            //defining function nC2 at the end
            int totalPairs = nC2(number);
            //need to find the wrong kinds of pairs and subtract
            int countWrong = 0;
            int count1 = 0, count2 = 0;
            //int max1 = 0, max2 = 0;
//            System.out.println(funnyWordSet);
//            System.out.println(firstLetters);
//            System.out.println(restWords);

            for(Map.Entry mapElement : firstLetters.entrySet()){
                int value = ((int) mapElement.getValue());
                if(value == number){//no unique words can be formed
                    System.out.println(0);
                    return;
                }
                if(value>1){
                    flag1 = true;
                    firstLStr[count1++] = value;
                }
            }

            for(Map.Entry mapEle : restWords.entrySet()){
                int value = ((int) mapEle.getValue());
                if(value == number){//no unique words can be formed
                    System.out.println(0);
                    return;
                }
                if(value>1){
                    flag2 = true;
                    restWStr[count2++] = value;
                }
            }

            if(!flag1 && !flag2){ //this means that any pair can give us the team name
                System.out.println(totalPairs * 2); //for both permutations
                return;
            }
//            System.out.println(flag1);
//            System.out.println(flag2);

            //now for all the terms that cause problems
            for (int i = 0; i < count1; i++) {
                int value = firstLStr[i];// get the value of the letter stored in the map
                totalPairs -= nC2(value);
            }
            for (int i = 0; i < count2; i++) {
                int value = restWStr[i]; //get value of rem words in separate map
                totalPairs -= nC2(value);
            }

            if(flag1 && flag2){
                Arrays.sort(firstLStr);
                Arrays.sort(restWStr);
                int maxCount1 = firstLStr[count1 -1], maxCount2 =restWStr[count2-1];
                if(maxCount1 > 1 && maxCount2 >1){
                    for(Map.Entry mapElement : firstLetters.entrySet()){
                        int value = ((int) mapElement.getValue());
                        char key = ((char) mapElement.getKey());
                        if(value < maxCount1) firstLetters.remove(key);
                    }
                    for(Map.Entry mapEle : restWords.entrySet()){
                        int value = ((int) mapEle.getValue());
                        String key = ((String) mapEle.getKey());
                        if(value<maxCount2) restWords.remove(key);
                    }


//            int max = Math.max(maxCount1, maxCount2);
//            boolean flagy = true;
                    if(maxCount1 > maxCount2){
                        for(Map.Entry mapElement : firstLetters.entrySet()) {
                            //int valueL = ((int) mapElement.getValue());
                            char keyL = ((char) mapElement.getKey());
                            for(Map.Entry mapEle : restWords.entrySet()) {
                                //int valueR = ((int) mapEle.getValue());
                                String keyR = ((String) mapEle.getKey());
                                if(funnyWordSet.contains(keyL+keyR)) counter++;
                            }
                        }
                    }else{
                        for(Map.Entry mapEle : restWords.entrySet()) {
                            //int valueR = ((int) mapEle.getValue());
                            String keyR = ((String) mapEle.getKey());
                            for(Map.Entry mapElement : firstLetters.entrySet()) {
                                //int valueL = ((int) mapElement.getValue());
                                char keyL = ((char) mapElement.getKey());
                                if(funnyWordSet.contains(keyL+keyR)) counter++;
                            }
                        }

                    }
                }
            }


            System.out.println((totalPairs-counter) *2);


        }
    }

    private static int nC2(int num){
        return (num * (num-1)/ 2);
    }

    //private static
}
