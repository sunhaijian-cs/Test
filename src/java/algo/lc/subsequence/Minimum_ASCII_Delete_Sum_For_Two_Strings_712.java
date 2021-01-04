package algo.lc.subsequence;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/9
 * @Description:
Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
Note:

0 < s1.length, s2.length <= 1000.
All elements of each string will have an ASCII value in [97, 122].



 **/
public class Minimum_ASCII_Delete_Sum_For_Two_Strings_712 {

    @Test
    public void test(){
        String s1="ccaccjp";
        String s2="fwosarcwge";
//        System.out.println(minimumDeleteSum(s1,s2));
        System.out.println(minimumDeleteSum2(s1,s2));

//        System.out.println(JSONObject.toJSONString(dp));
//        System.out.println("-----------");
//        System.out.println(minimumDeleteSum3(s1,s2));
    }

    @Test
    public void test2(){
        String s2="fwosarcwge";

        for (int i = 0; i <s2.length() ; i++) {


            System.out.println(Integer.valueOf(s2.charAt(i)));

        }
    }



    int dp[][];
    public int minimumDeleteSum(String s1, String s2) {
        dp=new int [s1.length()+1][s2.length()+1];
        return dp(s1,0,s2,0);

    }

    public int dp(String s1,int n1, String s2,int n2 ){

        if(n1==s1.length()&&n2==s2.length()){
            return 0;
        }

        if(n1==s1.length()){
            int res=0;

            for (int i = n2; i <s2.length() ; i++) {
                res+=Integer.valueOf(s2.charAt(i));
            }
            dp[n1][n2]=res;
            return res;
        }

        if(n2==s2.length()){
            int res=0;


            for (int i = n1; i <s1.length() ; i++) {
                res+=Integer.valueOf(s1.charAt(i));
            }
            dp[n1][n2]=res;
            return res;
        }

        if(  dp[n1][n2]>0){
            return   dp[n1][n2];
        }


        if(s1.charAt(n1)==s2.charAt(n2)){
            dp[n1][n2]=dp(s1,n1+1,s2,n2+1);
            return   dp[n1][n2];

        }else{

            dp[n1][n2]= Math.min(dp(s1,n1,s2,n2+1)+Integer.valueOf(s2.charAt(n2)),dp(s1,n1+1,s2,n2)+Integer.valueOf(s1.charAt(n1)));
            return   dp[n1][n2];
        }

    }


    // 备忘录
    int memo[][];
    /* 主函数 */
    int minimumDeleteSum2(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp2(s1, 0, s2, 0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
// 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    int dp2(String s1, int i, String s2, int j) {
        int res = 0;
        // base case
        if (i == s1.length()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        if (j == s2.length()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp2(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = Math.min(
                    s1.charAt(i) + dp2(s1, i + 1, s2, j),
                    s2.charAt(j) + dp2(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }




    public int minimumDeleteSum3(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i+1][s2.length()] + s1.codePointAt(i);
        }
        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = dp[s1.length()][j+1] + s2.codePointAt(j);
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j] + s1.codePointAt(i),
                            dp[i][j+1] + s2.codePointAt(j));
                }
            }
        }


//        System.out.println(JSONObject.toJSONString(dp));
        return dp[0][0];
    }





}
