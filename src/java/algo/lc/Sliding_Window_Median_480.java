package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/9
 * @Description:
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
1 [3  -1  -3] 5  3  6  7       -1
1  3 [-1  -3  5] 3  6  7       -1
1  3  -1 [-3  5  3] 6  7       3
1  3  -1  -3 [5  3  6] 7       5
1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note:
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
Answers within 10^-5 of the actual value will be accepted as correct.



 **/
public class Sliding_Window_Median_480 {
    @Test
    public void test(){
        int[]nums = {1,4,2,3};
//        int[]nums = {1,3,-1,-3,5,3,6,7};
        int k = 4;

        System.out.println(JSON.toJSONString(medianSlidingWindow(nums,k)));
    }


    /**
     * 这样做超时，有问题
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(k<=0||k>nums.length){
            return null;
        }
        double[] result=new double[nums.length-k+1];

        int right=k-1;
        while(right<nums.length){

            result[right-k+1]=caculate(nums,right,k);
            right++;
        }
        return result;

    }

    private double caculate(int[] nums, int right, int k) {


        int [] temp=Arrays.copyOfRange(nums,right-k+1,right+1);
        Arrays.sort(temp);
        System.out.println(JSON.toJSONString(temp));
        //偶数
        if(k%2==0){
           return 0.5*(temp[k/2]+temp[k/2]-1);
        }else{
            return temp[k/2];
        }
    }
}
