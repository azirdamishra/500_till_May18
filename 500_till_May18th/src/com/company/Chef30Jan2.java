package com.company;

public class Chef30Jan2 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- >0){
            int size = in.readInt();
            int[] arr = new int[size];
            //boolean [] isEven = new boolean[size];
            int even = 0;
            int zero = 0;
            int odd = 0;
            for (int i = 0; i < size; i++) {
                arr[i] = in.readInt();
            }

            //if all the numbers are even then only those need to be changed which are
            //odd and vice versa
            for (int i = 0; i < size; i++) {
                if(arr[i] %2 == 0){
                    even++;
//                    isEven[i] = true;
                }else{
                    odd++;
                }
            }
            if(even == 0 || odd == 0) System.out.println(zero);
            if(even > odd && odd != 0) System.out.println(odd);
            else System.out.println(even);
            //if(even < odd && even != 0) System.out.println(even);

        }
    }
}
