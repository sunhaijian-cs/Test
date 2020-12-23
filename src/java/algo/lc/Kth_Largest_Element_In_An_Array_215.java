package algo.lc;

import java.util.PriorityQueue;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/29
 * @Description:
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 **/
public class Kth_Largest_Element_In_An_Array_215 {


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue();
        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }

}
