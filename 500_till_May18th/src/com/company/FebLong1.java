package com.company;

public class FebLong1 {
    /*
    Print a single line containing one integer ― the largest divisor of N between 1 and 10.
    Note: 1 and -1 divide (are divisors of) every integer, every integer is a divisor of itself, and every integer
    is a divisor of 0, except by convention 0 itself (see also Division by zero). Numbers divisible by 2 are called
    even, and numbers not divisible by 2 are called odd.
     */
//corner cases are soooo imp
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int num = in.readInt();
        //int max_divisor = 1;
        for (int i = 10; i >=1 ; i--) {
            //if(num == 0) System.out.println();
            if(num == 1) System.out.println(1);
            //System.out.println(i);
            if(num % i == 0){
                //max_divisor = i;
                System.out.println(i);
                return;
            }
        }
    }

}
