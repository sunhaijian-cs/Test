package algo.lc;

import com.alibaba.fastjson.JSON;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/28
 * @Description:
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
Credits:
Special thanks to @ syedee for adding this problem and creating all test cases.



这道题给我们一个整数n，然我们统计从0到n每个数的二进制写法的1的个数，存入一个一维数组中返回，题目中明确表示不希望我们一个数字一个数字，一位一位的傻算，
而是希望我们找出规律，而且题目中也提示了我们注意 [2-3], [4-7], [8-15] 这些区间的规律，那么我们写出0到 15 的数的二进制和1的个数如下：
0    0000    0
-------------
1    0001    1
-------------
2    0010    1
3    0011    2
-------------
4    0100    1
5    0101    2
6    0110    2
7    0111    3
-------------
8    1000    1
9    1001    2
10   1010    2
11   1011    3
12   1100    2
13   1101    3
14   1110    3
15   1111    4

 **/
public class Counting_Bits_338 {

    public static void main(String[] args) {
        int num=5;
        int []result =countingBits(num);
        System.out.println(JSON.toJSONString(result));
    }

    private static int[] countingBits(int num) {
        int []result= new int[num+1];

        for (int i = 1; i <=num; i++) {
            if(i%2==0){
                result[i]=result[i/2];
            }else{
                result[i]=result[i/2]+1;
            }
        }
        return result;
    }
}
