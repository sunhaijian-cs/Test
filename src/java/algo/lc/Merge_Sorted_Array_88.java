package algo.lc;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/12
 * @Description:
https://mp.weixin.qq.com/s/QAzk-MFAQZfSU7vpnMu7rA
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中*，*使 nums1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

三种方法：
第一种方法 对应的算法是 ' 合并后排序 ', 时间复杂度比较大;

第二种方法 对应的算法是 ' 双指针 + 从前向后比较 '

往后挪动汽车时间复杂度高

移到第三个货架空间复杂度高

第三种方法 对应的算法是 ' 双指针 + 从后向前比较 ' , 省时又不占空间, 完美!


 **/
public class Merge_Sorted_Array_88 {

    public static void main(String[] args) {

        int [] num1={1,2,3,0,0,0};
        int [] num2={2,5,6};

        int n1=3;
        int n2=3;

//        int [] result=mergeSortedArray(num1,num2,n1,n2);
        int [] result=mergeSortedArray2(num1,num2,n1,n2);
        System.out.println(JSONObject.toJSONString(result));


    }

    private static int[] mergeSortedArray(int[] num1, int[] num2, int n1, int n2) {
        int p1=n1+n2-1;
        n1-=1;
        n2-=1;


        while(n1>=0||n2>=0){
            if(n1<0){
                num1[p1]=num2[n2];
                p1--;
                n2--;
            }
            if(n2<0){
                break;
            }

            if(num1[n1]>num2[n2]){
                num1[p1]=num1[n1];
                p1--;
                n1--;
            }else{
                num1[p1]=num2[n2];
                p1--;
                n2--;
            }
            System.out.println("n1="+n1+"----n2="+n2);
        }
        return num1;
    }


    private static int[] mergeSortedArray2(int[] num1, int[] num2, int n1, int n2) {

        int p1=n1+n2;
        while(n1>0&&n2>0){
            num1[--p1] =num1[n1-1]>num2[n2-1]?num1[--n1]:num2[--n2];
        }
        if(n2>0){
            for (int i = 0; i < n2; i++) {
                num1[i]=num2[i];
            }
        }
        return num1;
    }

}
