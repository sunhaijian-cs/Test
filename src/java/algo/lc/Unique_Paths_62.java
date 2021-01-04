package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/29
 * @Description:
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28


Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 **/
public class Unique_Paths_62 {

    @Test
    public void test(){
        System.out.println( uniquePaths(7,3));
        System.out.println( uniquePaths2(7,3));
        System.out.println( uniquePaths3(7,3));
    }

    static int res=0;
    int [][]dp3;

    /**
     * 如果纯使用回溯法，则会超时
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        res=0;
        backtrack(1,1,m,n);
        return res;
    }

    public void backtrack(int x,int y ,int m,int n){
        if(x==n&&y==m){
            res++;
            return ;
        }
        if(x<n){
            backtrack(x+1,y,m,n);
        }
        if(y<m){
            backtrack(x,y+1,m,n);
        }

    }


    /**
     * 动态规划   字底向上
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {

        int [][]dp=new int [m][n];

        for (int i = 0; i <m ; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i <n ; i++) {
            dp[0][i]=1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }


        return dp[m-1][n-1];

    }



    /**
     * 动态规划   自顶向下
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {

        dp3=new int [m][n];
        return dp(m,m,n,n);

    }

    public int  dp(int m,int m1,int n,int n1){
        if(m1==1||n1==1){
            return 1;
        }
        if( dp3[m1-1][n1-1]>0){
            return  dp3[m1-1][n1-1];
        }

        dp3[m1-1][n1-1]= dp(m,m1-1,n,n1)+dp(m,m1,n,n1-1);
        return dp3[m1-1][n1-1];
    }





}
