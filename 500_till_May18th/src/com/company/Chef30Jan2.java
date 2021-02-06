package com.company;
/*
Determine the minimum number of operations you have to perform so that all pairwise differences
in the resulting array are even
 */

public class Chef30Jan2 {
    //correct
//    public static void main(String[] args) {
//        InputReader in = new InputReader(System.in);
//        int t = in.readInt();
//        while (t-- > 0){
//            int num = in.readInt();
//            int[] arr = new int[num];
//            for (int i = 0; i < num; i++) {
//                arr[i] = in.readInt();
//            }
//            int even = 0, odd = 0, output = 0;
//            for (int j = 0; j<arr.length; j++) {
//                if (arr[j] % 2 == 0) even++;
//                else odd++;
//            }
//            output = Math.min(even, odd);
//            System.out.println(output);
//
//        }
//    }

    public static void main(String[] args) {
        //original code, corrected
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- > 0) {
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
                if (arr[i] % 2 == 0) {
                    even++;
//                    isEven[i] = true;
                } else {
                    odd++;
                }
            }
            //okay that was v stupid
            if (even == 0 || odd == 0){
                System.out.println(zero);
                return;
            }
            if (even > odd) System.out.println(odd);
            else System.out.println(even);
        }
    }
}

/*


import java.util.*;
        import java.lang.*;
        import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int t=0;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        while(t-- >0)
        {
            int n=0,y=0,z=0,o=0,e=0;

            n=Integer.parseInt(br.readLine());
            String v[]=br.readLine().split(" ");
            int a[]=new int[n];
            for(y=0;y<n;y++){
                a[y]=Integer.parseInt(v[y]);
            }
            for(y=0;y<n;y++)
            {
                if(a[y]%2==0)
                {
                    e++;
                }
                else
                {
                    o++;
                }
            }
            z=e<o?e:o;
            System.out.println(z);
        }
    }
}

 */
