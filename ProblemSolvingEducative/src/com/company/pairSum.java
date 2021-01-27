package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
2 3
4, 6, 5
n = 2
nC2 =
 */
public class pairSum {
    public static void main(String args[]){
        //Scanner sc = new Scanner(System.in);
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(input.readLine());
            while (t-- >0){
                //System.out.println("Hola");
                StringTokenizer tk = new StringTokenizer(input.readLine());
//                int [] arr = new int[2];
//                for(int i = 0; i<2; i++){
//                    String s = sc.next();
//                    arr[i] = Integer.parseInt(s);
//                }


                //String s = sc.next();
                long left = Long.parseLong(tk.nextToken());
                long right = Long.parseLong(tk.nextToken());


                if(left == right){
                    System.out.println("1");
                    continue;
                }
                //System.out.println("hello");

                //long num = right-left + 1;
                //int reachable = num + (num*(num + 1)/2);
                //long reachable = num * (num + 1)/2;
                long answer = 2*right - 2*left + 1;

                System.out.println(answer);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
