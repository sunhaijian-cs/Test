package algo.lc.subsequence;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/5
 * @Description:
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.


 最长公共子序列 很典型的动态规划算法

 **/
public class Longest_Common_Subsequence_1143 {


    @Test
    public void test(){




    }

    int [][]dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp=new int [text1.length()][text2.length()];
        return dp(text1,0,text2,0);

    }

    public int dp(String text1,int t1, String text2,int t2){



        if(t1==text1.length()||t2==text2.length()){
            return 0;
        }

        if(dp[t1][t2]!=0){
            return dp[t1][t2];
        }

        if(text1.charAt(t1)==text2.charAt(t2)){
            int result=dp(text1,t1+1,text2,t2+1)+1;
            dp[t1][t2]=result;

            return result;
        }
        int result=Math.max(dp(text1,t1+1,text2,t2),dp(text1,t1,text2,t2+1));
        dp[t1][t2]=result;

        return result;

    }
}
