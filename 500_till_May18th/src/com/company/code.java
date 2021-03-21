package com.company;

import java.util.*;

public class code {
    //need to create Node

    //return the value contained in the Node
    //create binary tree with the node

    public static void main(String[] args) {
        //Node rootNode = new subNode("a");
        Node rootNode = new subNode("a");
        rootNode.printProtected();
        rootNode.printValue();
        
        Node leftNode1 = new subNode("b");
        rootNode.setLeftChild(leftNode1);

        Node rightNode1 = new subNode("c");
        rootNode.setRightChild(rightNode1);


        Node leftNodeL = new subNode("d");
        leftNode1.setLeftChild(leftNodeL);
        Node rightNodeL = new subNode("e");
        leftNode1.setRightChild(rightNodeL);

        Node leftNodeR = new subNode("f");
        rightNode1.setLeftChild(leftNodeR);
        Node rightNodeR = new subNode("g");
        rightNode1.setRightChild(rightNodeR);

        //traversal(rootNode);
        stackTraversal(rootNode);


    }

    public static void traversal(Node node){
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(node);

        while (!queue.isEmpty()){
            node = queue.remove();
            node.printValue();
            if(node.getLeftChild() != null){
                queue.add(node.getLeftChild());
            }
            if(node.getRightChild() != null){
                queue.add(node.getRightChild());
            }

        }

    }
    //print the values using bfs

    public static void stackTraversal(Node node){
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while (!stack.isEmpty()){

            while (node.getLeftChild() != null){
                node = node.getLeftChild();
                stack.push(node);
            }
            node = stack.pop();
            node.printValue();


            if(node.getRightChild() != null) {
                node = node.getRightChild();
                stack.push(node);
            }
            //if(node.getLeftChild() == null) continue;

        }
    }


}
