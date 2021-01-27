package com.company;

//import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.StringTokenizer;

public class password {
    public static void main(String args[]) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //InputReader input = new InputReader(System.in);
        //input.
        int t = Integer.parseInt(reader.readLine());

        while (t-- >0){
            //int counter = 0;
            boolean a = false, b = false, c = false, d = false;
            String str = reader.readLine();
            //System.out.println(str.length());
            if(str.length() < 10){
                System.out.println("NO");
                continue;
            }
            for(int i = 0; i<str.length(); i++){

                if(Character.isAlphabetic(str.charAt(i)) && Character.isUpperCase(str.charAt(i))&& i != 0 && i != str.length()-1) a = true;
                if(Character.isAlphabetic(str.charAt(i)) && Character.isLowerCase(str.charAt(i))) b = true;
                if(Character.isDigit(str.charAt(i)) && i != 0 && i != str.length()-1)c = true;
                if((str.charAt(i) == '@' || str.charAt(i) == '%' || str.charAt(i) == '#' || str.charAt(i) == '&' || str.charAt(i) == '?') && (i != 0 && i != str.length()-1)) d = true;

            }
            if(a && b && c && d) System.out.println("YES");
            else System.out.println("NO");


        }
    }
}
