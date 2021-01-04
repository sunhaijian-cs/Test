package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: sunhaijian
 * @Date: 2020/6/15
 * @Description:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
暴力查找
 时间复杂度O(n^2)
 空间复杂度O(1)


 **/
public class Two_Sum_1 {
    @Test
    public void test(){
        int[] nums={2, 7, 11, 15};
        int target=9;
        System.out.println(JSON.toJSONString(twoSum(nums,target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {

            if(map.get(target-nums[i])!=null){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }


        throw new IllegalArgumentException("two sum param error");
//        return null;
    }


}
