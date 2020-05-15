//package com.company;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int size; // size of the grid
    private boolean [][] grid;
    private final int top = 0;
    private final int bottom;
    private int open_elements;
    private final WeightedQuickUnionUF wquf; //weighted quick union to find object reference

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.size = n;
        this.bottom = n*n +1 ;
        wquf = new WeightedQuickUnionUF(size * size + 2);
        grid = new boolean[size][size];
    }

    private boolean areIndicesInvalid(int i, int j) {
        return (i < 0 || i > this.size-1 || j < 0 || j > this.size-1);
    }

    //this helps us get the index of a site in the grid that can be used in the WQUF implementation
    private int getSiteIndex(int row, int col){
        if (areIndicesInvalid(row,col)){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return row*this.size + col + 1;
    }

    // opens the site (row, col) if it is not open already and connects it to adjacent site if any
    public void open(int row, int col){
        if (areIndicesInvalid(row,col)){
            throw new java.lang.IndexOutOfBoundsException();
        }
        int index = getSiteIndex(row, col);
        grid[row][col] = true; //open the grid element

        if (index == 1){
            wquf.union(0, index);
        }
        if (index == this.size*this.size + 1 ){
            wquf.union(index, bottom);
        }
        if(row >0 && isOpen(row-1, col)){
            int new_index = getSiteIndex(row-1, col);
            wquf.union(index, new_index );
        }

        if(row < this.size-1 && isOpen(row+1, col)){
            int new_index = getSiteIndex(row+1, col);
            wquf.union(index, new_index );
        }

        if(col >0 && isOpen(row, col-1)){
            int new_index = getSiteIndex(row, col-1);
            wquf.union(index, new_index );
        }

        if(row < this.size -1 && isOpen(row, col + 1)){
            int new_index = getSiteIndex(row, col + 1);
            wquf.union(index, new_index);
        }

    }

    // is the site(row,col) open
    public boolean isOpen(int row, int col){
        if (areIndicesInvalid(row,col)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return grid[row][col];
    }

    // the site row,col is full only when it is able to reach the top box via connections
    public boolean isFull(int row, int col){
        if (areIndicesInvalid(row, col)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return wquf.connected(0, getSiteIndex(row,col));
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        for(int i = 0; i< this.size; i++){
            for(int j = 0; j < this.size; j++){
                if (isOpen(i,j)) open_elements++;
            }
        }
        return open_elements;
    }

    // does the system percolate?
    public boolean percolates(){
        return wquf.connected(top, bottom);
    }

    // test client (optional)
    //public static void main(String[] args)
}
