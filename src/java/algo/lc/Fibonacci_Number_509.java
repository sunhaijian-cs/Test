package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/9/3
 * @Description:
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).



Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 **/
public class Fibonacci_Number_509 {

    @Test
    public void test(){

        System.out.println(fib1(10));
        System.out.println(fib2(10));
        System.out.println(fib3(10));
    }

    /**
     *最简单的方式，但是复杂度最高。
     * @param N
     * @return
     */
    public int fib1(int N) {
        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }
        return fib1(N-1)+fib1(N-2);
    }

    /**
     * 使用了备忘录，大大减少了时间复杂度
     * @param N
     * @return
     */
    public int fib2(int N) {
        int []memor =new int [N+1];
        memor[0]=0;
        memor[1]=1;

        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }
        for (int i = 2; i <=N ; i++) {
            memor[i]= memor[i-1]+ memor[i-2];
        }

        return memor[N];
    }

    /**
     * 使用了备忘录，大大减少了时间复杂度,同时控制空间复杂度O（1）
     * @param N
     * @return
     */
    public int fib3(int N) {

        int pre=0;
        int current=1;

        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }
        for (int i = 2; i <=N ; i++) {
            int temp=current;
           current= current+ pre;
           pre=temp;

        }

        return current;
    }




}
