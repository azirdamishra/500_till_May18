package com.company;
//this is a great question in terms of the usages of different components of java
import java.util.Arrays;
//solved

//interesting input that should return true
//[[-27],[-40]]
//[10,18,41,-13,25,48,-40,40,-34,-13,17,43,32,-28,28,-19,-47,45,3,42,-2,33, 28,-9,-11,-16,3,34,-30,-6,32,23,24,-14,-14,1,40,-43,-34,40,23,9,14,14,-31, 50,-18,-23,-19,-21,38,24,-41,-28,47,-8,17,-34,-45,-24,7,-5,7,-23,-42,-4,31, 48,40,15,-27,-39,50,-40,38,-18,26,17,49,-18,28,9,3,42,5,-43,9,-36,15,38, -15,-33,-21,4,-11,24,-15]

//this input return true
//[[7122186,-6877645,3486322],[-8477030],[1917773],[-9337589],[7017586],[-4492418],[-745836],[-912773],[9818463,4180029],[-4576693,-6690524,-7751890],[-7659435],[4847283]]
//[3486322,7122186,-6877645,3486322,-8477030,1917773,-9337589,7017586,-4492418,-745836,-912773,9818463,4180029,-4576693,-6690524,-7751890,1917773,-7659435,4847283]

//[[-5,0]]
//[2,0,-2,5,-1,2,4,3,4,-5,-5]
//should be false

public class weirdNameButfindIn2DArray {
    public static void main(String[] args) {
        int[][] grid = {{7122186,-6877645,3486322},{-8477030},{1917773},{-9337589},{7017586},{-4492418},{-745836},{-912773},{9818463,4180029},{-4576693,-6690524,-7751890},{-7659435},{4847283}}; //yayayayayaayay
        int[] nums = {3486322,7122186,-6877645,3486322,-8477030,1917773,-9337589,7017586,-4492418,-745836,-912773,9818463,4180029,-4576693,-6690524,-7751890,1917773,-7659435,4847283};
        int [][] grid2 = {{1,-1,-1},{3,-2,0}};
        int[] nums2 = {1,-1,0,1,-1,-1,3,-2,0};
        boolean answer = findingGroups(grid, nums);
        boolean answer2 = findingGroups(grid2, nums2);
        System.out.println(answer + " 1");
        System.out.println(answer2 + " 2");

    }
    private static boolean findingGroups(int[][] groups, int[] nums){
        int i = 0; //i is the count in the nums array
        int groupCount = 0; //is the count of the number of groups //for now j == groupCount
        while (groupCount < groups.length){
            //check for the groups starting from the first one and not going over it again and again
            while (i<nums.length){
                int newIndex = i + groups[groupCount].length;
                if(newIndex > nums.length){
                    //System.out.println("hellooo");
                    return false;
                }
                //check if subarr is same as the group
                int[] subArr = Arrays.copyOfRange(nums,i, newIndex);
                if(Arrays.equals(subArr, groups[groupCount])){
                    i = newIndex;
                    groupCount++;
                    break; //breaks out of the while loop
                }
                i++; //incase the if statement does not execute the loop must still go on
            }
            if(i == nums.length && groupCount != groups.length ){
                return false;
            }
        }
        return true;
    }
}
