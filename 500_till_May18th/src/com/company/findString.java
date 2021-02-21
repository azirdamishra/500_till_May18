package com.company;
//input can be something like this:
//GACATTGTGAACAGTAAAAAAGTCCATGCAATGCGCAAGGAGCAGAAGAGGAAGCAGGGCAAGCAGCGCTCCATGGGCTCTCCCATGGACTACTCTCCTCTGCCCATCGACAAGCATGAGCCTGAATTTGGTCCATGCAGAAGAAAACTGGATGGG

import java.util.Scanner;
//finding the no of equal substr found in dna string

public class findString {
    public static void main(String[] args) {
//        InputReader in = new InputReader(System.in);
        Scanner in = new Scanner(System.in);
        String dnaString = in.nextLine();
        String subStr = in.nextLine(); //string to be found in the dna
        int start = 0;
        int counter = 0;
        for(int end =0; end<dnaString.length(); end++){
//            System.out.println("this is end " + end);
//            System.out.println("this is start " + start);

            if(end - start + 1> subStr.length()){
                start++;
                //System.out.println(start);
            }
            if(end-start+1 ==  subStr.length()){
                String sub = dnaString.substring(start, end+1);
                System.out.println(sub);
                if(sub.equals(subStr)){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
