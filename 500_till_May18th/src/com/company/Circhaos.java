package com.company;
//doing what wrong???
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//apparently it works with scanner as well?? what is input.close?
// rewrite the entire code using only the problem statement
//https://www.codechef.com/problems/CIRCHAOS

public class Circhaos {
    //method to get gcd
    private static int gcdEuclid(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a,b);

        if(min == 0) return max;
        return gcdEuclid(max%min,min);
    }
    //method to get highest factor less than the number of wiz
    private static int largestFactor(int a, int N){
        //a is the gcd and N is the no of wiz
        //we are finding the max factor of gcd that is <= N
        //find factors of a number and make sure its smaller
        //than N
        int max = 0;
        //you need to have below properties
        for(int i = a; i>0; i--){
            //we can only have 1 in case a is prime
            //and N is less than a
            if(a%i == 0 && i <= N){
                max = Math.max(max, i);
            }
            //return max;
        }
        //System.out.println("a is " + a);
        if(max == 0 && N < a) return 1;
        if(max == 0) return N;

        return max;

    }

    //final action method that shows answer
    public static void main(String args[]) throws Exception{

//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
        /*
        scanner takes too much time and there is no
        way to get buffered reader to read space
        separated input
        */
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(input.readLine());
//            String x = input.readLine();
//            int t = Integer.parseInt(x);

            while (t-- > 0){
                //get all the input in an array
                //use string token for one line
                StringTokenizer tk = new StringTokenizer(input.readLine());
                //String s = sc.next();
                int N = Integer.parseInt(tk.nextToken());//no of wiz
                //s = sc.next();
                int M = Integer.parseInt(tk.nextToken());//magic powers

                //first we find the gcd of the numbers that are present
                int gcdOfAllM = 0;
                int[] magicPowers = new int[M];
                StringTokenizer tk2 = new StringTokenizer(input.readLine());
                for(int i = 0; i<M; i++){
                    magicPowers[i] = Integer.parseInt(tk2.nextToken());
                    gcdOfAllM = gcdEuclid(gcdOfAllM, magicPowers[i]);
                }
                //thus we get the gcd

                //then we find the greatest factor of the gcd that
                //is less than N
                //System.out.println(gcdOfAllM);
                int largestFactorOfGCD = largestFactor(gcdOfAllM, N);
                //System.out.println("largest fac of GCD is " + largestFactorOfGCD);

                //we subtract this number from N to get the number of
                //wiz that are killed -- giving us the final output
                int noOfKills = N - largestFactorOfGCD;
                System.out.println(noOfKills);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
