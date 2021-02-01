package com.company;
//package com.company;

public class watermelon {
    public static void main(String[] args) throws Exception{
        InputReader in = new InputReader(System.in);
        int num = in.readInt();

        if(num == 2 || num<0){
            System.out.printf("NO");
            return;
        }

        if(num % 2 == 0){
            System.out.printf("YES");
            return;
        }
        System.out.printf("NO");
    }
}

