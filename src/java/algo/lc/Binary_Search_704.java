package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/8
 * @Description:
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].

https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/er-fen-cha-zhao-xiang-jie
 需要注意的点
1，计算 mid 时需要防止溢出，代码中 left + (right - left) / 2 就和 (left + right) / 2 的结果相同，
但是有效防止了 left 和 right 太大直接相加导致溢出。

 2，使用两端都封闭的方式比较简答

 **/
public class Binary_Search_704 {
    @Test
    public void test(){
        int[] nums={-1,0,3,5,9,12};

        int targht=9;
        System.out.println(search(nums,targht));

        int[] nums1={1,2,2,2,3};
        System.out.println(left_bound1(nums1,6));
        System.out.println(left_bound2(nums1,6));

    }
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;// 注意

        while(left<=right){// 注意
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;// 注意
            }else if(nums[mid]>target){
                right=mid-1;// 注意
            }

        }
        return -1;
    }

    /**
     * 二分查找寻找最左边界方法一
     * @param nums
     * @param target
     * @return
     */
    int left_bound1(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        // target 比所有数都大
        if (left == nums.length) return -1;
        // 类似之前算法的处理方式
        return nums[left] == target ? left : -1;
//        return left;
    }

    /**
     * 二分查找寻找最左边界方法一
     * @param nums
     * @param target
     * @return
     */
    int left_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }


    /**
     * 二分查找寻找最右边界方法一
     * @param nums
     * @param target
     * @return
     */
    int right_bound1(int[] nums, int target) {
        if (nums.length == 0) {return -1;}
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) {return -1;}
        return nums[left-1] == target ? (left-1) : -1;
//        return left - 1; // 注意
    }

    /**
     * 二分查找寻找最右边界方法二
     * @param nums
     * @param target
     * @return
     */
    int right_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

}
