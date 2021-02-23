package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordConcat {
    private static List<Integer> findConcat(String str, String[] words) {
        //putting the words string into a map to reduce memory
        Map<String, Integer> wordFreqnMap = new HashMap<>();
        for (String s : words) {
            wordFreqnMap.put(s, wordFreqnMap.getOrDefault(s, 0) + 1);
        }
        //returning the indices in List format
        List<Integer> resultIndices = new ArrayList<>();
        int wordsCount = words.length, wordLength = words[0].length();
        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            //words seen will help us check that the frequency does not go beyond that
            //is present in the frequency map, otherwise we reject that sentence that is formed
            Map<String, Integer> wordsSeenbutTesting = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int newestIndex = i + j * wordLength; //this would give us newer words everytime
                String newWord = str.substring(newestIndex, newestIndex + wordLength);
                //check if the word that we find is present in the original freqn map
                if (!wordFreqnMap.containsKey(newWord)) break;
                //add the word into wordsSeen as being a part of the sentence
                wordsSeenbutTesting.put(newWord, wordsSeenbutTesting.getOrDefault(newWord, 0) + 1);
                //check if freqn is more than that in original map, if yes then ignore the wordsSeen
                if (wordsSeenbutTesting.get(newWord) > wordFreqnMap.get(newWord)) break;
                //finish the for loop by checking if j reaches the end of the sentence containing all the
                // words it should acc to the map, if yes then add this index
                // i <= str.length() - wordsCount * wordLength because we need those many words in our
                //sentence compulsarily and if this last i does not contain the sentence that we require then
                //we don't need any other i's beyond it
                if (j + 1 == wordsCount) resultIndices.add(i);

            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        List<Integer> result = findConcat("catfoxcat", new String[]{"cat", "fox"});
        System.out.println(result);
        result = findConcat("catcatfoxfox", new String[]{"cat", "fox"});
        System.out.println(result);
    }
}
