package algo.lc;

import com.alibaba.fastjson.JSON;

import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/27
 * @Description:
 *
Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:

Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number;
The second 1's next greater number needs to search circularly, which is also 2.


Note: The length of given array won't exceed 10000.


 **/
public class Next_Greater_Number_2_503 {

    public static void main(String[] args) {

        int []nums ={2,1,2,4,3};

        int [] result=getNextGreaterNums2(nums);
        System.out.println(JSON.toJSONString(result));

    }

    private static int[] getNextGreaterNums2(int[] nums) {
        Stack<Integer> stack=new Stack();
        int []result=new int[nums.length];
        int n=nums.length;
//        这里n设置为nums length，  这个大小实际上比数组的最后一个元素下标大1。所以使用取余操作能覆盖所有数组里的元素。

        //注意为啥是2n-1,0出来了
        for (int i = 2*n-1; i >=0; i--) {
            while (!stack.isEmpty()&&stack.peek()<=nums[i%n]){
                stack.pop();
            }
            result[i%n]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }


        return result;
    }


}
