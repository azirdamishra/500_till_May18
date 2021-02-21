//package com.company;
//
//import java.util.*;
////bhaiya method
//public class FebLong5but3 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = Integer.parseInt(in.nextLine());
//        while (t-- > 0) {
//            int number = Integer.parseInt(in.nextLine());
//            Set<String> funnyWordSet = new HashSet<>();
//            Map<Character, Integer> firstLetters = new HashMap<>();
//            Map<Character, Map<String, Integer>> restWords = new HashMap<>();
//
//            //String[] funnyWords = new String[number];
//            for (int i = 0; i < number; i++) {
//                //funnyWords[i] = in.next(); //should not be nextLine()
//                String st = in.next();
//                funnyWordSet.add(st);
//                //String key = st.substring(0,1);
//                firstLetters.put(st.charAt(0),
//                        firstLetters.getOrDefault(st.charAt(0), 0) + 1);
//                restWords.put(st.substring(1), restWords.getOrDefault(st.substring(1), 0) + 1);
//            }
//        }
//    }
//}
///*
//public static void main(String[] args) throws Exception {
//        InputReader in = new InputReader(System.in);
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//        int tc = in.readInt();
//        for (int t = 0; t < tc; t++) {
//            int n = in.readInt();
//            String words[] = in.readLine().split(" ");
//            Set<String> wordSet = new HashSet<>(Arrays.asList(words));
//            Set<String> allWords = new HashSet<>();
//            Map<Character, Map<String, Integer>> startCounter = new HashMap<>();
//            for (int i = 0; i < words.length; i++) {
//                String newWord = words[i].substring(1);
//                for (int j = 0; j < 26; j++) {
//                    allWords.add((char)('a' + j) + newWord);
//                }
//                char fch = words[i].charAt(0);
//                if (!startCounter.containsKey(fch)) {
//                    startCounter.put(fch, new HashMap<>());
//                }
//                if (!startCounter.get(fch).containsKey(words[i].substring(1))) {
//                    startCounter.get(fch).put(words[i].substring(1), 0);
//                }
//                startCounter.get(fch).put(words[i].substring(1), startCounter.get(fch).get(words[i].substring(1)) + 1);
//            }
//            int res = 0;
//            for (String word: allWords) {
//                if (!wordSet.contains(word)) {
//                    for (int i = 0; i < 26; i++) {
//                        char ch = (char)('a' + i);
//                        char wc = word.charAt(0);
//                        if (wordSet.contains(ch + word.substring(1)) && startCounter.containsKey(wc)) {
//                            for (String rest: startCounter.get(wc).keySet()) {
//                                if (!wordSet.contains(ch + rest)) {
//                                    res++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            out.write(Long.toString(res));
//            out.newLine();
//        }
//        out.close();
//    }
//}
//
// */
