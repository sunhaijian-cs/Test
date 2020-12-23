package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/21
 * @Description:
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
 **/
public class Min_Cost_Climbing_Stairs_746 {

    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp=new int [cost.length];
        return Math.min(dp(cost,0),dp(cost,1));
 }


    public int dp(int[] cost,int level){
        if(level>=cost.length){
            return 0;
        }
        if(dp[level]>0){
            return dp[level];
        }

        dp[level]=Math.min(dp(cost,level+1),dp(cost,level+2))+cost[level];
        return dp[level];
 }


    /**
     * 更优的做法
     * 核心思想： 一步一步走，计算每一步的最小值
     *
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        // Purpose
        // Purpose of this problem is get to cost.length + 1 with minimal cost
        // The user can only take 1 or 2 steps starting at the 0 index the 1st index

        // General Method
        // Choose the lowest one at each point by either taking 1 or 2 step
        // Choose both to see and store that one everytime
        //
        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int a = cost[0];
        int b = cost[1];
        int minCost = 0;
        for(int i = 2; i < cost.length; i++) {
            minCost = cost[i] + Math.min(a, b);
            a = b;
            b = minCost;



        }
        return Math.min(a, b);
    }
}
