package com.company;


import java.util.Scanner;

public class catchTheif {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[4];
        int n = sc.nextInt();
        for(int a = 0; a < n; a++){

            for(int i = 0; i< 4; i++){
                String s = sc.next(); //very smart and imp
                //space separated numbers are taken as input and put
                //in each element of the array
                arr[i] = Integer.parseInt(s);
                //System.out.println(arr[i]);
            }
            boolean flag = false;
            //int gaps = Math.abs(arr[0]-arr[1]);
            int max = Math.max(arr[0], arr[1]);
            int min = Math.min(arr[0], arr[1]);
            while (true){
                if(min == max){
                    flag = true;
                    break;
                }
                if(max<min){
                    break;
                }else {
                    min += arr[2];
                    max -= arr[2];
                }
            }

            if(flag) System.out.println("Yes");
            else System.out.println("No");

//            if(gaps >= arr[2] && (float)gaps/2 != arr[2]) System.out.println("No");
////distance can be travelled in more than one second
//            if((float)gaps/2 == arr[2]) System.out.println("Yes");
        }

    }
}
