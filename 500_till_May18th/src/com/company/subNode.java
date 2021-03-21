package com.company;

public class subNode extends Node{
    public subNode (String value){
        super(value);
    }
    @Override
    protected void printProtected(){
        System.out.println("this is inside subnode " + value);
    }


    private void printpvt(){
        System.out.println("this is inside subnode3 " + value );
    }

}
