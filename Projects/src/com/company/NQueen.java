package com.company;

//finding all solutions to N Queens problem -- this is giving me a headache
// geeks for geeks: https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
//GFG also has the Bit Masking solution which is also super cool
// COdeSpeedy: https://www.codespeedy.com/find-all-distinct-solutions-to-n-queens-problem-in-java/
//Techie Delhight: https://www.techiedelight.com/print-possible-solutions-n-queens-problem/

public class NQueen {
    //final int N = 4;
    //print board
     void print(int grid[][], int N){
         System.out.println("First solution");
        for (int i= 0; i < N; i++){
            for(int j=0; j<N; j++){
                if(grid[i][j] == 1){
                    System.out.print(" " + "Q");
                    //making changes to values by finding the reflection of points about y=-x to
                    //solve for the second solution
                    //nvm that only gives for N=4 there are many more for N>4
//                    if(i == j) grid[i][j] =2;
//                    else grid[j][i] = 2;
                }
                else{
                    System.out.print(" " + "_");
                }
            }
            System.out.println();
        }
        //the other solution would be its symmetrical opposite along the left bending diagonal
         // the other solution would happen when we choose to broadly increment the column instead of
         //the row and do the depth first search in the row of each column instead of vice versa as of now
         //only for N = 4

//         System.out.println("Second solution");
//         for (int i= 0; i < N; i++){
//             for(int j=0; j<N; j++){
//                 if(grid[i][j] == 2) System.out.print(" " + "Q");
//                 else System.out.print(" " + "_");
//             }
//             System.out.println();
//         }
    }
//  we are going to check validity of placement travelling row wise, which means incrementing
    //the row and going deep into the columns
    // we only need to check the left side of the column we are in this way, and this slightly
// //reduces the amount of work
    boolean isSafe(int grid[][], int row, int col, int N){
        int i, j;
        for(i = 0; i<col; i++){
            if(grid[row][i] == 1) return false;
        }
        for( i =row, j=col; i>=0 && j>=0; i--, j--){
            if(grid[i][j] == 1) return false;
        }
        for (i = row, j=col; i< N && j>=0; j--, i++){
            if(grid[i][j] == 1) return false;
        }
        return true;
    }

    boolean NQueenMethod(int grid[][], int col, int N){
        //base case --> all queens are placed in the right places
        //this is a recursive method so be extra careful about initialising variables
        if(col >= N) return true; //  it is given that the row would be N

        for(int i = 0; i <N; i++){ //incrementing the row

            if(isSafe(grid, i, col, N)){
                grid[i][col] = 1;

                //calling the recursive method to check if the place infront of it is able to
                //rightly place the queen
                if(NQueenMethod(grid, col + 1, N)) return true;
                // the value of the current element will be determined by the next one,
                //because backtracking ensures that the incorrect one is not placed

                //thus we go through all the columns of that row, checking for a legitimate spot for
                //that element. If we find one we keep it and then recursively check the position for
                //the next element and when isSafe returns false for that same row but different column
                //we increment the next row. In case the value of the next in line on the same row is
                //the right one compared to the previous one then we backtrack

                //if none of the above works then we would need to remove the queen we placed
                //in this for loop
                grid[i][col] = 0; //this causes backtrack
            }
        }

        //if the queen is not placed in the entire column (as the rows have already been checked
        // in the above for loop) then we would return false
        return false;
    }
    public boolean solvingBoard(){
        int N = 10;
        int grid[][] = new int[N][N];

        for(int i = 0; i<N; i++){
            for(int j=0; j<N; j++){
                grid[i][j] = 0;
            }
        }
//        int grid[][] = { { 0, 0, 0, 0 },
//                          { 0, 0, 0, 0 },
//                          { 0, 0, 0, 0 },
//                          { 0, 0, 0, 0 } };

        if(!NQueenMethod(grid, 0, N)){
            System.out.println("Solution does not exist");
            return false;
        }
        print(grid, N);
        return true;
    }

    public static void main(String args[]){
        NQueen Queens =  new NQueen();
        Queens.solvingBoard();
    }
}
