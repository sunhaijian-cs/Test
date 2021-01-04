package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/10
 * @Description:
 **/
public class Search_Insert_Position_35 {

    @Test
    public void test(){
//        int [] nums={1,3,5,6};
        int [] nums={1};
        System.out.println(searchInsert1(nums,0));
    }

    /**
     * O(logn)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left =0,right =nums.length-1;

        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                right=mid;
            }else if(nums[mid]>target){
                right=mid-1;


            }else if(nums[mid]<target){
                left=mid+1;

            }
        }
        return left;
    }

    /**
     * O(n)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        int left =0;

        while(left<nums.length){
           if(nums[left]>=target){
               return left;
           }
           left++;
        }
        return nums.length;
    }
}
