package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/7/23
 * @Description:
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
[1,3,1],
[1,5,1],
[4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 **/
public class Minimum_Path_Sum_64 {

    public int minPathSum(int[][] grid) {
        if(grid.length<1){
            return 0;
        }
        int dpArr[][]=new int[grid.length][grid[0].length];
        dpArr[0][0]=grid[0][0];

        for (int i = 1; i <grid[0].length ; i++) {
            dpArr[0][i]=dpArr[0][i-1]+grid[0][i];
        }
        for (int i = 1; i <grid.length ; i++) {
            dpArr[i][0]=dpArr[i-1][0]+grid[i][0];
        }

        for (int i = 1; i <grid.length ; i++) {
            for (int j = 1; j <grid[0].length ; j++) {
                if( dpArr[i-1][j]>=dpArr[i][j-1]){
                    dpArr[i][j]=dpArr[i][j-1]+grid[i][j];
                }else{
                    dpArr[i][j]=dpArr[i-1][j]+grid[i][j];
                }
            }
        }
        return dpArr[grid.length-1][grid[0].length-1];
    }
}
