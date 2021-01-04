package algo.lc;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/8
 * @Description:
给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

示例 1:

输入: [2,2,3,4]
输出: 3
解释:
有效的组合是:
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
注意:

数组长度不超过1000。
数组里整数的范围为 [0, 1000]。


 分析
任意两边之和大于第三边，那是不是说我们需要把三条边都组合配对考虑一下？其实不用，我们可以得出下面的结论

a < b < c && a + b > c => 三角形
如果已知三条边的大小顺序，那么其实我们只需要比较一次即可。

TwoSum 变种问题 如果题目要求找到比 target 小/大 的配对该怎么处理？
 **/
public class Valid_Triangle_Number_611 {
    public static void main(String[] args) {
        int [] nums={2,2,3,4};
        int result=validTriangleNumber(nums);

        System.out.println(result);

    }

    private static int validTriangleNumber(int[] nums) {
        if(Objects.isNull(nums)||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);

        int result=0;

        for (int i = nums.length-1; i >=2; i--) {
            int l=0 ,r=i-1;
            while (l<r){
                if(nums[i]<nums[l]+nums[r]){
                    result+=r-l;
                    r--;
                }else{
                    l++;
                }
            }

        }



        return result;

    }


}
