package com.company;

public class MinHeap<T extends Comparable<T>> {
    private T[] Heap; //we declare T array whose name is Heap
    private int size; //this is the number of elements that we want to store in the array
    private int maxsize; //this is the maximum capacity of the array

    private static final int FRONT = 1; //we declare a temp variable for the starting location of the heap

    //initialising a constructor for building a heap
    public MinHeap(T[] arr, T node){
        //every time we create a heap an array with its name (arr) must be passed along with the initial starting value for the node
        this.maxsize = arr.length;
        this.size = 0;
        Heap = arr;
        Heap[0] = node;
    } //this creates an instance of the heap

    //Method to return the position of the current node at pos
    private int parent(int pos){
        return pos/2;
    }

    //function to return the position the right child for the node currently at pos
    private int rightChild(int pos){
        return (2*pos) + 1;
    }

    //method to return the position of the left node child for current node at pos
    private int leftChild(int pos){
        return (2*pos);
    }

    //function that returns true if the passed node is a leaf node
    private boolean isLeaf(int pos){
        if (pos >= size/2 && pos <= size){
            return true;
        }
        return false;
    }

    //function to swap two nodes of the heap
    private void swap(int fpos, int spos){
        T tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    //function to print the contents of the heap
    public void print(){
        for (int i= 1; i<= size/2; i++){
            System.out.println("PARENT: " + Heap[i] + "LEFT CHILD" + Heap[2*i] + "RIGHT CHILD" + Heap[2*i +1]);
            System.out.println();
        }
    }

    //core method heapify can be called when we insert a node into an existing heap or we delete a node from a heap
    //to heapify the node at pos
    private void minHeapify(int pos){
        // if the node is a non-leaf and greater than any of its child
        if(isLeaf(pos)){
            if (Heap[pos].compareTo(Heap[leftChild(pos)])>0
                    || Heap[pos].compareTo(Heap[rightChild(pos)])>0){
                //depending on whether the right child is lesser or the left, swap with that and heapify

                if (Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)])<0){
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    //function to insert a node into a heap
    public void insert(T element){
        if (size >= maxsize){
            return;
        }

        Heap[++size] = element;
        int current = size;

        while(Heap[current].compareTo(Heap[parent(current)]) < 0){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    //here in min heap we are only talking about removing the root node (topmost node) and so the deletion method only concerns that
    //Function to remove and return the minimum element from the heap
    public T remove(){
        T popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--]; //here we place the lowermost largest leaf node and then we use the heapify method to make it a proper min heap again
        minHeapify(FRONT);
        return popped;
    }

    //function to build the min heap using the minHeapify
    public void minHeap(){
        for (int pos = size/2; pos >= 1; pos --){
            minHeapify(pos);
        }
    }





}
