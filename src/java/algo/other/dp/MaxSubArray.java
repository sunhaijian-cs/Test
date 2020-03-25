package algo.other.dp;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/3/23
 * @Description:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 解决方法：
 1，暴力法
 2，分治法
 3，分析法
 4，动态规划





 **/
public class MaxSubArray {

    @Test
    public  void mainMethod() {
        int [] a ={-2,1,-3,4,-1,2,1,-5,4};


//        System.out.println(first(a));
//        System.out.println(second(a,0,a.length-1));
//        System.out.println(three(a));
        System.out.println(four(a));
    }

    /**
     * 暴力法
     * 时间复杂度 n^3
     * 当然可以优化
     */
    private int  first(int [] a ) {
        int n=a.length;

        int maxSum=a[0];
        int currSum;

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                currSum=0;
                for (int k = i; k <j ; k++) {
                    currSum+=a[k];
                }
                if (currSum>maxSum){
                    maxSum=currSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * 分治法
     * 1，将数组从中间分开，那么最大的子数组要么完全在左半边数组，要么完全在右边数组，要么跨立在分界点上。
     * 2，完全在左数组，右数组可以直接递归解决
     * 3，跨立在分界点上：实际上时左数组的最大后缀和右数组的最大前缀的和。因此从左向前扫，从右向后扫。
     *
     * 时间复杂度  (nlogn)
     **/
    private int  second(int [] a,int from ,int to ) {
        if(from ==to){
            return a[from];
        }
        int middle =(from + to )/2;
        int m1=second(a,from,middle);
        int m2=second(a,middle+1,to);

        int left=a[middle];
        int now=a[middle];

        for (int i=middle-1;i>=from;i--){
            now+=a[i];
            left =max(now ,left);
        }
        int right =a[middle+1];
        now =a[middle+1];
        for (int  i =middle+2 ; i <=to; i++) {
            now +=a[i];
            right =max(now,right);

        }
        int m3=left+right;
        return max(m1,m2,m3);

    }

    private int max(int ... m) {
        int max=m[0];
        for (int i = 1; i <m.length ; i++) {
            if(max<m[i]){
                max=m[i];
            }
        }

        return max;
    }

    /**
     * 分析法
     *
     *
     *
     *
     **/
    private int  three(int [] a ) {

        int [] p =new int[a.length];
        p[0]=a[0];
        for (int i = 1; i <a.length ; i++) {
            p[i]=p[i-1]+a[i];
        }

        int max=a[0];
        int min =a[0];

        for (int i = 1; i < a.length; i++) {
            if (p[i]<min){
                min=p[i];
            }

            if((p[i]-min)>max){
                max=p[i]-min;
            }
        }

        return max;
    }
    /**
     * 动态规划
     *
     *
     *
     *
     **/
    private int  four(int [] a ) {
        int result =a[0];
        int sum=a[0];

        for (int i = 1; i < a.length; i++) {
            if (sum>0){
                sum+=a[i];
            }else{
                sum=a[i];
            }
            if (sum>result){
                result=sum;
            }
        }




        return  result;
    }

}
