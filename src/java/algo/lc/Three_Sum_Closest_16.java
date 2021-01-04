package algo.lc;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/24
 * @Description:
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4


 **/
public class Three_Sum_Closest_16 {
    @Test
    public void test(){

        int[] nums={-100,-98,-2,-1};
        int target=-101;

        System.out.println(threeSumClosest(nums,target));
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3){
            return -1;
        }
        Arrays.sort(nums);

        int  minSum=Integer.MIN_VALUE;
        int  minGap=Integer.MAX_VALUE;
        for (int i = 0; i <nums.length-2 ; i++) {
            int first =nums[i];

            int left=i+1;
            int right=nums.length-1;
            while(right>left){
                int temp=first+nums[left]+nums[right];
                if(Math.abs(temp-target)<minGap){
                    minGap=Math.abs(temp-target);
                    minSum=temp;
                }
                if(temp-target>0){
                    right--;
                }else if(temp-target<0){
                    left++;
                }else {
                    return target;
                }
            }



        }


        if(minSum==Integer.MIN_VALUE){
            return nums[0]+ nums[1]+ nums[2];
        }else {
            return minSum;
        }

    }

}
