package com.company;

//import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//causing problems also need to do rectangles
//rewrite this
public class totalScore {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer tk = new StringTokenizer(in.readLine());
        int t = Integer.parseInt(in.readLine());
        while (t-- >0){
            String[] arr = in.readLine().split(" ");
            int numOfParticipants = Integer.parseInt(arr[0]);
            int numOfProblems = Integer.parseInt(arr[1]);
            String[] points = in.readLine().split(" ");
            int[] pointsPerProblem = new int[numOfProblems];
            for (int i = 0; i < numOfProblems; i++) {
                pointsPerProblem[i] = Integer.parseInt(points[i]);
            }
            String[] stringScore = new String[numOfParticipants];
            for (int i = 0; i < numOfParticipants; i++) {
                stringScore[i] = in.readLine();
            }
            for (int i = 0; i < numOfParticipants; i++) {
                System.out.println(studentScore(pointsPerProblem, stringScore[i]));
            }

        }
    }
    private static int studentScore(int[] pointsPerProblem, String studentScore){
        int score = 0;
        for (int i = 0; i < studentScore.length(); i++) {
            int value = Integer.parseInt(Character.toString(studentScore.charAt(i)));
            if(value == 1) score += pointsPerProblem[i];
        }
        return score;
    }
}
