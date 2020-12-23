package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/8
 * @Description:



https://mp.weixin.qq.com/s/QqNKWqwmEG_-Crl6otXiyA
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

解法一
 分成两种种情况
情况1
当前柱子小于前后两个柱子中最矮的那个，则当前柱子会存水，当前位置可以存储的雨水容量 = leftMax - curr = 1
情况2
当前柱子大于等于前后两个柱子中最矮的那个，不会存水
时间复杂度 O(n^2)


解法二双指针
这个方式相当于对解法1的优化。
在解法1中，需要找到当前位置左右两边的最大值，但是实际上只会用到左右两边最大值中小的那个。
而解法2中，实际不计算两个指针之间的数值最大值，只计算两个指针和两边的对应最大值最小值，
而只有小的那一边指针才可以移动，比如说 left_max<right_max  一定有left_max<Math.max(right_max,中间柱子的最大值)。


时间复杂度O(n)
 **/
public class Trapping_Rain_Water_42 {

    public static void main(String[] args) {
//        int [] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int [] height={0,1,0,2,1,0,0,0,0,0,0,0};

//        int sum=trap1(height);
        int sum=trap2(height);
//        int sum=trap3(height);

        System.out.println(sum);

    }

    private static int trap1(int[] height) {

        int sum=0;

        for (int i = 1; i < height.length-1; i++) {
            int left_max=height[0];

            for (int j = i-1; j >=0; j--) {
                if (left_max<height[j]){
                    left_max=height[j];
                }
            }
            int right_max=height[height.length-1];
            for (int j = i+1; j <=height.length-1; j++) {
                if (right_max<height[j]){
                    right_max=height[j];
                }
            }
            int min=Math.min(left_max,right_max);

            if(height[i]<min){
                sum=sum+min-height[i];
            }
        }
        return sum;
    }


    /**
     * 错误实例--思想不对
     * @param height
     * @return
     */
    private static int trap2(int[] height) {

        int sum=0;
        if(height.length<=2){
            return 0;
        }


        int left=0;
        int right=height.length-1;

        int left_max=height[left];
        int right_max=height[right];

        while (left<right){
            left++;
            right--;
//            if(left>right){
//                break;
//            }

            int min=Math.min(left_max,right_max);

            if(height[left]<min){
                sum=sum+min-height[left];
            }
            if (height[left]>left_max){
                left_max=height[left];
            }

            if(left>right){
                break;
            }

            if(height[right]<min){
                sum=sum+min-height[right];
            }
            if (height[right]>right_max){
                right_max=height[right];
            }


        }

        return sum;
    }



    private static int trap3(int[] height) {

        int sum = 0;
        if (height.length <= 2) {
            return 0;
        }


        int left = 1;
        int right = height.length - 2;

        int left_max = height[left];
        int right_max = height[right];

        while (left <= right) {
           if(left_max<right_max){
            if(height[left]<left_max){
                sum=sum +left_max-height[left];
            }
            left_max=left_max>height[left]?left_max:height[left];


            left++;

           }else{
               if(height[right]<right_max){
                   sum=sum +right_max-height[right];
               }
               right_max=right_max>height[right]?right_max:height[right];

               right--;


           }


        }

        return sum;
    }


}
