package com.company;

public class DijkstraAlgo {
    public static void main(String[] args){
        GeneralStack<String> ops = new GeneralStack<String>();
        GeneralStack<Double> vals = new GeneralStack<Double>();

        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("("));
            if(s.equals("+")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals(")")){
                String op = ops.pop();
                if(op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
            }
            //otherwise return a new double initialized to the value represented by the specified String
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
