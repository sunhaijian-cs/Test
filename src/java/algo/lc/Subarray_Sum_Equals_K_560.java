package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/7/21
 * @Description:
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2


Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 **/
public class Subarray_Sum_Equals_K_560 {

    @Test
    public void test(){
        int []nums ={-1,-1,1};
        System.out.println(subarraySum(nums,0));
    }


    /**
     * 虽然可以accept 但是不简洁
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int []preSum=new int [nums.length];
        preSum[0]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            preSum[i]=preSum[i-1]+nums[i];
        }

        int ans = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(preSum[j]-preSum[i]==k){
                    ans++;
                }
            }
        }

        for (int i = 0; i <nums.length ; i++) {
            if(preSum[i]==k){
                ans++;
            }
        }
        return ans;

    }


    /**
     * 简洁的做法
     * @param nums
     * @param k
     * @return
     */

    int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        // 构造前缀和
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];

        int ans = 0;
        // 穷举所有子数组
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // sum of nums[j..i-1]
                if (sum[i] - sum[j] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
