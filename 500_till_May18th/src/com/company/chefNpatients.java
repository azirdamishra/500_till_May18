package com.company;
//this question is my absolute favourite
//https://www.codechef.com/problems/CHEFPAT
import java.util.*;

public class chefNpatients {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- >0){
            int num = in.nextInt();
            int[] arr = new int[num];//will be sorted and will go thru it in reverse
            int[] copyArr = new int[num]; //this array will keep the original positions intact
            int[] result = new int[num];
            Map<Integer, List<Integer>> positions = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
                copyArr[i] = arr[i];
                //position is i and number is the value or weight
                positions.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
            //System.out.println(positions); //yay
            Arrays.sort(arr);
            //1
             int i = arr.length-1;
            while (i >= 0){
                //get the list from the hashmap
                List<Integer> newList = positions.get(arr[i]);
                for (int j = 0; j < newList.size(); j++) {
                    int value = newList.get(j); //iterating value of list
                    int time = computingHours(i, num); //time that the patient would have to wait for
                    result[value] = time; //we use the value of the list to put the hours into the result arr
                    i--;
                }
            }
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }

        }
    }
    private static int computingHours( int position, int num){
        return Math.abs(position - num);
    }
}
