package algo.lc;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/27
 * @Description:
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.

 **/
public class First_Missing_Positive_41 {
@Test
public void test(){
    int[] nums={1,2,0};

    System.out.println(firstMissingPositive(nums));
}

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0){
            return 1;
        }
        if(nums[0]>1||nums[nums.length-1]<1){
            return 1;
        }
        int point=0;
        int count=1;
        while(point <=nums.length-1){
            if(nums[point]<count){
                point++;
                continue;
            }

            if(nums[point++]!=count++){
                return --count;
            }
        }
        return count;
    }
}
