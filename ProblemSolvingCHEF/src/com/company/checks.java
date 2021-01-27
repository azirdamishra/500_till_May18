package com.company;

import java.text.DecimalFormat;

public class checks {
    public static void main(String[] args) {
        // write your code here
        float a = (float)22/7;
        //float b =  a;
        System.out.println(a);
        DecimalFormat df2 = new DecimalFormat("#.##");
        float b = Float.parseFloat(df2.format(a));
        System.out.println(b);
    }
}
