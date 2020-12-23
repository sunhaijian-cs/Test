package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/7/21
 * @Description:
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false

 **/
public class Power_Of_Two_231 {

    public boolean isPowerOfTwo(int x) {
        if (x <= 0) {
            return false;
        }
        return (x&(x-1))==0;
    }


}
