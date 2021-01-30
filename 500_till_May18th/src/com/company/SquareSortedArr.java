package com.company;
/*
Given a sorted array, create a NEW array containing squares of all the numbers of
the input array in the sorted order.
 */
public class SquareSortedArr {
    private static int[] makeSquares(int[] arr){
        int[] squares = new int[arr.length];
        int counter = arr.length-1;
        //be aware of the times taken and  the size of the array
        //need to find location of 0 and might take long so switch approach
        //start from the ends
        int right = arr.length -1;
        int left = 0;
        while(left<right && counter >= 0){
            //starting with the largest so we go backwards
            //creating a separate variable for below also helps, no calc reqd later
            arr[left] *=  arr[left];
            arr[right] *= arr[right];

            if(arr[left] == arr[right]){
                squares[counter--] = arr[right--];
                squares[counter--] = arr[left++];
                continue;
            }

            if(arr[left] > arr[right]){
                squares[counter--] =  arr[left++];
                arr[right] = (int) Math.sqrt(arr[right]);
                continue;
            }
            if(arr[left] < arr[right]){
                squares[counter--] = arr[right--];
                arr[left] = (int) Math.sqrt(arr[left]);
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] result = makeSquares(new int[]{-2, -1, 0, 2, 3});
        //System.out.println(result);
        for(int num: result){
            System.out.print(num + " ");
        }

    }
}
