package algo.lc;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/13
 * @Description:
根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

 方法一
 暴力查找---一般会超时

 方法二
递减栈方法
递减栈 ：栈里只有递减元素。

具体操作如下：

遍历整个数组，如果栈不空，且当前数字大于栈顶元素，那么如果直接入栈的话就不是 递减栈 ，所以需要取出栈顶元素，由于当前数字大于栈顶元素的数字，而且一定是第一个大于栈顶元素的数，直接求出下标差就是二者的距离。

继续看新的栈顶元素，直到当前数字小于等于栈顶元素停止，然后将数字入栈，这样就可以一直保持递减栈，且每个数字和第一个大于它的数的距离也可以算出来。

 相似题型:
Next_Greater_Number_496

 **/
public class Daily_Temperatures_739 {

    public static void main(String[] args) {
        int []temperatures={73, 74, 75, 71, 69, 72, 76, 73};
//        int []result=dailyTemperatures(temperatures);
        int []result=dailyTemperatures2(temperatures);
        System.out.println(JSONObject.toJSONString(result));

    }

    /**
     *暴力法
     */
    private static int[] dailyTemperatures(int[] temperatures) {
        int []result =new int [temperatures.length];
        for (int i = 0; i < temperatures.length-1; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if(temperatures[i]<temperatures[j]){
                    result[i]=j-i;
                    break;
                }
            }
        }
        return result;
    }
    private static int[] dailyTemperatures2(int[] temperatures) {
        int []result =new int [temperatures.length];

        Stack<Integer> stack=new Stack();
        for (int i = 0; i < temperatures.length-1; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            int tempIndex=stack.peek();
            if(temperatures[tempIndex]>temperatures[i]){
                stack.push(i);
                continue;
            }

            while(temperatures[tempIndex]<temperatures[i]){
                result[tempIndex]=i-tempIndex;
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                tempIndex=stack.peek();
            }
            stack.push(i);
        }


        return result;
    }






}
