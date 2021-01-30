package com.company;

public class Chef30Jan5 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- >0){
            int length = in.readInt();

            String str = in.readString();
            char[] arr = str.toCharArray();
//            int noOfZeroes = 0;
//            int noOfOnes = 0;
//            int min1 = 0;
//            int min2 = 0;
//            if(length %2 == 0){
//                firstHalf(arr);
//                return;
//            }else {
//            }
            int left = 0;
            int right = arr.length-1;
            int zeroes = 0, ones = 0;
            int half = 0;
            if(arr.length%2 == 0) half = arr.length/2;
            else half = (arr.length+1)/2;
            while (left<right){
                if(arr[left++] == '1')ones++;
                if(arr[right--] == '0')zeroes++;
            }
            if(ones == zeroes) System.out.println(arr.length/2);
            if(ones > half - ones && zeroes < half - zeroes) System.out.println(half-ones+zeroes);
            if(ones < half-ones && zeroes > half-zeroes) System.out.println(ones + half - zeroes);
            //return -1;




        }
    }
//    private static int firstHalf(char[] arr){
//        int left = 0;
//        int right = arr.length-1;
//        int zeroes = 0, ones = 0;
//        int half = 0;
//        if(arr.length%2 == 0) half = arr.length/2;
//        else half = (arr.length+1)/2;
//        while (left<right){
//            if(arr[left++] == '1')ones++;
//            if(arr[right--] == '0')zeroes++;
//        }
//        if(ones == zeroes) System.out.println(arr.length/2);
//        if(ones > half - ones && zeroes < half - zeroes) System.out.println(half-ones+zeroes);
//        if(ones < half-ones && zeroes > half-zeroes) System.out.println(ones + half - zeroes);
//        //return -1;
//    }
}
