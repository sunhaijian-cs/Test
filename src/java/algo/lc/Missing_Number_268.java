package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/15
 * @Description:
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 … n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2

示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8

 三种解法：
 1，异或法
 2，求和法
 3，二分法（先排序-不推荐这种方法）

 **/
public class Missing_Number_268 {

    public static void main(String[] args) {
        int []nums ={3,0,1};
//        int []nums ={9,6,4,2,3,5,7,0,1};

//        int result=checkMissingNumber1(nums);
        int result=checkMissingNumber2(nums);
        System.out.println(result);

    }

    /**
     * 异或法
     * @param nums
     * @return
     */
    private static int checkMissingNumber1(int[] nums) {
        int result=0;
        for (int i = 0; i <nums.length ; i++) {
            result=result^i^nums[i];

        }
        return result^nums.length;
    }

    /**
     * 求和法
     * @param nums
     * @return
     */
    private static int checkMissingNumber2(int[] nums) {

        int sum=(nums.length+1)*(0+nums.length)/2;
        for (int i = 0; i <nums.length ; i++) {
            sum-=nums[i];

        }
        return sum;
    }
    /**
     * 二分法
     * @param nums
     * @return
     */
    private static int checkMissingNumber3(int[] nums) {

        int sum=(nums.length+1)*(0+nums.length)/2;
        for (int i = 0; i <nums.length ; i++) {
            sum-=nums[i];

        }
        return sum;
    }


}
