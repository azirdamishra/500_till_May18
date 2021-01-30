package com.company;

public class Chef30Jan4 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- > 0){
            int size = in.readInt();
            int[] arr = new int[size];
            int oddNos = 0;

            for (int i = 0; i < size; i++) {
                arr[i] = in.readInt();
                if(arr[i] % 2  != 0)oddNos++;
            }

            if(oddNos % 2 == 0) System.out.println(1);
            else System.out.println(2);
        }
    }
}
