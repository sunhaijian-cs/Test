package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/12
 * @Description:
给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
示例 1:

输入: [1,1,2,3,3,4,4,8,8]
输出: 2
示例 2:

输入: [3,3,7,7,10,11,11]
输出: 10
注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。




 **/
public class Single_Element_In_A_Sorted_Array_540 {

    public static void main(String[] args) {
        int [] nums={1,1,2,3,3,4,4,8,8};
//        int [] nums={1,3,3,7,7,10,10,11,11};
//        int result =singleElement(nums);
        int result =singleElement2(nums);

        System.out.println(result);
    }

    private static int singleElement(int[] nums) {
        int l=0;
        int r=nums.length-1;


        while(l<r){
            int mid=l+(r-l)/2;


            if(nums[mid]==nums[mid-1]){
                Boolean  isRightEven= (r-mid)%2==0;
                if(isRightEven){
                    r=mid-2;
                }else{
                    l=mid+1;
                }


            }else if(nums[mid]==nums[mid+1]){
                Boolean  isLeftEven= (mid-l)%2==0;
                if(isLeftEven){
                    l=mid+2;
                }else{
                    r=mid-1;
                }
            }else{
                return nums[mid];
            }
        }

        return nums[l];

    }

    /**
     * 仅对偶数进行二分查找
     * @param nums
     * @return
     */
    private static int singleElement2(int[] nums) {
        int l=0;
        int r=nums.length-1;


        while(l<r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }

        return nums[l];

    }
}
