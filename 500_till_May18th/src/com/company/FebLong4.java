package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;
//import com.google.common.primitives.Ints;

public class FebLong4 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- >0){
            int size = in.readInt();
            int[] wtArr = new int[size];
            int[] stepArr = new int[size]; //no of steps the frog would take
            int[] sortedWt = new int[size];
            int[] pos = new int[size]; //stores current index of frog
            for (int i = 0; i < size; i++){
                wtArr[i] = in.readInt();
                sortedWt[i] = wtArr[i];
            }
            for (int i = 0; i < size; i++) {
                stepArr[i] = in.readInt();
                pos[i] = i;
            }

            //int[] sortedWts = wtArr; //makes sortedarr refer to the same location as wtarr
            //not the right thing to do
            Arrays.sort(sortedWt);
            int count = 0;

            //assuming that the smallest wt frog is in the right place i.e its position is correct
            for (int i = 1; i < size; i++) {
                //need to find sortedWt[i] in wtArr
                int index = getIndex(sortedWt[i], wtArr);

                //int findNoPrev = sortedWt[i-1];
                //int p = pos[IntStream.range(0, size-1).filter(j -> findNoPrev == wtArr[j] ).findFirst().orElse(0)];
                int p = pos[getIndex(sortedWt[i-1], wtArr)];
                int num = index;//the position where the number is at originally, and where it needs to be incremented
                //so that we know the future positions
                while (num <= p){
                    num += stepArr[index];
                    pos[index] = num;
                    count++;
                }

            }
            System.out.println(count);


        }
    }
    private static int getIndex(int num, int[] arr){
        int find = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num) return i;
        }
        return -1;
    }
}
