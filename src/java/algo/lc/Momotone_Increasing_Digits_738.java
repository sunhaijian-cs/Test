package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/15
 * @Description:
 *
Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9].

 贪心算法（处理逻辑有点复杂）

1，从左向右找，后一个数比前一个数小的位置。

2，将当前位置的数减一，对比当前位置是否小于前一个数据，如果小于的话，将当前位置从右向左移动。 操作循环。

3，第二步跳出循环有两个条件，（1）当前位置减一之后大于等于前一个位置的数字，（2）循环到了最左边的数字。

 4，将当前位置之后的左右数字全都改成9

 **/
public class Momotone_Increasing_Digits_738 {
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
