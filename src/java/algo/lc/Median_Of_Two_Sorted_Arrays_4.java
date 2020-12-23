package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/27
 * @Description:
 *Given two sorted arrays nums1 and nums2 of size m and n respectively.

Return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000


Constraints:

nums1,length == m
nums2,length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000

 这个问题是hard  有更优的解法，二分等
 **/
public class Median_Of_Two_Sorted_Arrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;

        if(n==0){
            return 0;
        }

        if(n==1){
            return nums1.length==0?nums2[0]:nums1[0];
        }


        if(n%2!=0){
            int k=n/2;
            return getMinK(nums1,nums2,k);

        }else{
            int k=n/2-1;
            return (getMinK(nums1,nums2,k)+getMinK(nums1,nums2,k+1))/2.0;

        }



    }

    public int getMinK(int [] nums1,int [] nums2, int k){
        int result=-1;
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0,j=0;
        while(k>=0){
            if(i==n1){
                j++;
                result=nums2[j-1];
            }else if(j==n2){
                i++;
                result=nums1[i-1];
            }else if(nums1[i]<nums2[j]){
                i++;
                result=nums1[i-1];
            }else if(nums1[i]>=nums2[j]){
                j++;
                result=nums2[j-1];
            }
            k--;
        }
        return result;
    }
}
