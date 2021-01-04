package algo.lc;

import com.alibaba.fastjson.JSON;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/27
 * @Description:
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Follow up:
Could you solve it in linear time?

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7


Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length
 **/
public class Sliding_Window_Maximum_239 {
    static Deque<Integer> deque=new LinkedBlockingDeque<>();
    public static void main(String[] args) {
        int [] nums={1,3,-1,-3,5,3,6,7};
        int [] result=maxSlidingWindowNums(nums,3);

        System.out.println(JSON.toJSONString(result));



    }

    private static int[] maxSlidingWindowNums(int[] nums,int k) {

        int [] result=new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {

            if (i<k-1){
                push(nums[i]);
            }else{
                push(nums[i]);
                result[i-k+1]=max();
                pop(nums[i-k+1]);

            }
        }

        return result;

    }


    public static  void push(int k){
        while (!deque.isEmpty()&&deque.peekLast()<k){
            deque.pollLast();
        }
            deque.addLast(k);
    }
    public static int max(){
        return deque.peekFirst();
    }

    public static void pop(int k){
        if(!deque.isEmpty()&&deque.peekFirst()==k){
            deque.pollFirst();
        }
    }
}
