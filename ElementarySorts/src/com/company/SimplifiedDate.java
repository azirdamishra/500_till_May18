package com.company;
//simplified form of date comparator in java interface

//import java.util.Date;
//simple form of the above

//the comparable interface is responsible for comparison of data
//the person writing the code does not need to worry about the datatype

public class SimplifiedDate implements Comparable<SimplifiedDate> {
    //only compares dates to other dates
    private final int month;
    private final int year;
    private final int day ;

    public SimplifiedDate(int m, int d, int y){
        month = m;
        year = y;
        day = d;
    }

    public int compareTo(SimplifiedDate that){  //the word 'that' can be taken as a variable name
        if (this.year< that.year) return -1;
        if(this.year > that.year) return +1;
        if (this.month< that.month) return -1;
        if(this.month > that.month) return +1;
        if (this.day< that.day) return -1;
        if(this.day > that.day) return +1;
        return 0;
    }

}
