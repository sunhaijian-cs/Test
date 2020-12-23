package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/18
 * @Description:
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.



Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1


 这个问题最核心的点是找到比m2  也就是一个递增的二元组中较大的数。

 最小的数一直在更新， 二元组中较大的数如果找到了比自己小的二元组较大的数就更新自己。

 如果找到了第三个数就 return true




 **/
public class Increasing_Triplet_Subsequence_334 {

    @Test
    public void test(){
        int[] nums ={10,9,8,11,1,2,0};
        System.out.println(increasingTriplet(nums));
    }


    public boolean increasingTriplet(int[] nums) {
        int m1=Integer.MAX_VALUE;
        int m2=Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {

            if(m1>=nums[i]) {
                m1=nums[i];
            }else if (m2>=nums[i]){
                m2=nums[i];
            }else {
                return true;
            }
        }
        return false;



    }
}
