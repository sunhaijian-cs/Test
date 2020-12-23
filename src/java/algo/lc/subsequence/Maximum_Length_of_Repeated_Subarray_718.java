package algo.lc.subsequence;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/4
 * @Description:
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation:
The repeated subarray with maximum length is [3, 2, 1].


Note:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100

 找出状态
 dp[i][j]  标识a[i]之前，和b[j]之前 最大的字符重复个数


初始化
dp[0][0]  dp[0][B.length-1]
dp[0][0]  dp[A.length-1][0]


最长公共子数组  ---非常典型的动态规划



 **/
public class Maximum_Length_of_Repeated_Subarray_718 {


    @Test
    public void test(){
        int []a ={1,2,3,2,1};
        int []b ={3,2,1,4,7};

        System.out.println(findLength(a,b));


    }


    public int findLength(int[] A, int[] B) {
        int dp[][]=new int[A.length][B.length];
        int max=0;



        for (int i = 0; i <A.length ; i++) {
            if(A[i]==B[0]){
                dp[i][0]=1;
            }
        }
        for (int i = 0; i <B.length ; i++) {
            if(B[i]==A[0]){
                dp[0][i]=1;
            }
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if(A[i]==B[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }

}
