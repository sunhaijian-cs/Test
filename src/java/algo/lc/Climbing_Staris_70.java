package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/13
 * @Description:
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


 **/
public class Climbing_Staris_70 {
    @Test
    public void test(){

        climbStairs(3);

    }

    static int count =0;

    public int climbStairs(int n) {
        count =0;
        backTrack(n);
        return count;
    }

    /**
     *遍历方法超时
     * @param n
     * @return
     */
    public int backTrack(int n) {
        if(n==0){
            count++;
            return 0;
        }
        if(n==1){
            backTrack(n-1);
        }else{
            backTrack(n-1);
            backTrack(n-2);
        }

        return 0;
    }


    /**
     * 初级dp
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int prev1=1;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int cur=prev1+prev2;
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }

}
