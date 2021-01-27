package com.company;

import java.util.Scanner;
//NEVER USE N AND NUM IN THE SAME CODE
public class PrintPattern {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int a = 0; a<n; a++){
            int num = sc.nextInt();
            int [][] grid = new int[num][num];
            int counter = 1;
            int k;
            //int finalno = num*num;

            for(int i = 0; i< 2*num; i++){
                for (int j = 0; j<num; j++){
                    for( k = 0; k<num; k++){
                        if (j+k == i){
                            grid[j][k] = counter++;
                            //System.out.println(counter);
                            //System.out.println("this is" + "j:" + j + "k" + k);
                            //System.out.print(j + " ");
                            //System.out.println(grid[j][k]);
                            //break;
                        }
                        //System.out.println("hello");
                        //if(k == j) break;

                    }
                }
            }
            for(int i = 0;i<num;i++) {
                for(int j = 0;j<num;j++) {
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }
        }

    }
}
