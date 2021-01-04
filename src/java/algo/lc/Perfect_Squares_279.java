package algo.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/27
 * @Description:
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.



 **/
public class Perfect_Squares_279 {

    @Test
    public void test(){

        System.out.println(numSquares1(12));

    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }



    /**
     * 贪心算法不行，不能得到最优解
     * @param n
     * @return
     */
    public int numSquares1(int n) {
        List<Integer> sNums=new ArrayList();
        for(int i=1;i<1000;i++){
            sNums.add(i*i);
        }


        int res=0;
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        while(n!=0){
            int temp=1;
            for(int i=0;i<sNums.size();i++){
                if(n<sNums.get(i)){
                    temp=i-1;
                    break;
                }
            }
            n=n-sNums.get(temp);
            res++;
        }
        return res;

    }

}
