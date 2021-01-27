package com.company;
//wasn't that hard

public class GCDandMax {
    public static void main(String args[]){
        int a = 12;
        int b = 0;
        //int ans = findGCD(a, b);
        //System.out.println(ans);
        //int ansEuclid = EuclidGCD(a, b);
        //System.out.println(ansEuclid);
        int maxfactorans1 = maxFactor1(a);
        System.out.println(maxfactorans1);


    }
    //what we really wanna do is use recursion as the euclidean method?
    //How is it better than the for loop -- depends on the system really
    //and type of implementation -- both of mine use the same math
    //so same only almost

    //Also need to find the max factor of the no we find as gcd
    //am i finding max factor or max prime factor because max factor
    //is that no/2 bitch * facepalm *
    private static int maxFactor1(int a){
        int maxfactor = 0;
        for(int i = 2; i*i < a; i++){
            if(a%i == 0) {
                maxfactor = Math.max(maxfactor, i);
                //System.out.println(maxfactor);
            }
        }
        if(maxfactor == 0) maxfactor = a;
        return maxfactor;
    }

    private static int EuclidGCD(int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        if(min == 0) return Math.max(a,b);
        return EuclidGCD(min, max%min);
        /*
        so the euclidean algorithm is essentially:
        No = Quotient*divisor + remainder
        where No = max, and divisor = min
        and the imp numbers will be the divisor and the reminder
        // proof for euclid which is quite a universal method
        https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm#:~:text=The%20Euclidean%20Algorithm%20for%20finding,%3D%20B%E2%8B%85Q%20%2B%20R)
        on khan academy its logical af
         */


    }
    private static int findGCD(int a, int b){
        //to find the GCD ideally we should use the eucliedian
        //method for optimal results, what about finding the max
        //of the GCD?
        int minimum = Math.min(a, b);
        //System.out.println(minimum);
        if(a == 0 || b == 0) return Math.max(a,b);
        for(int i = minimum; i>1; i--){
            if(a%i == 0 && b%i ==0){
                return i;
            }
        }
        return 1;
    }
}
