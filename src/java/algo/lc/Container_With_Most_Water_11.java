package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/4/23
 * @Description:
 * https://mp.weixin.qq.com/s/B0KusTdG2wi_wl2RIbkM6Q
 *
 * 给定n个非负整数 ，每个数代表坐标中的一个点
 * 在坐标内画n条竖直线
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水
说明： 你不能倾斜容器，且n的值至少为 2。
 时间复杂度为 O(n)


 关联题型：
176 Two Sum II

 **/
public class Container_With_Most_Water_11 {


    @Test
    public void test(){

        int [] height={3,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }


    public int maxArea(int [] height){

        int maxArea =0;

        maxArea=Math.min(height[0],height[height.length-1])*(height.length-1);
        int i=0;
        int j=height.length-1;

        while(i<j){
            if(height[i]<height[j]){
                i++;
            }else {
                j--;
            }

            if(maxArea<Math.min(height[i],height[j])*(j-i)){
                maxArea=Math.min(height[i],height[j])*(j-i);
            }
        }
        return maxArea;
    }
}
