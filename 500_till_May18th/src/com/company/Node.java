package com.company;

public class Node {
        String value;
        Node leftChild;
        Node rightChild;

        public Node(String value){
            this.value = value;
        } //constructor

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        void printValue(){
            System.out.println(value);
        }
        protected void printProtected(){
            System.out.println(value);
        }
        private void printpvt(){
            System.out.println(value);
        }
    }
