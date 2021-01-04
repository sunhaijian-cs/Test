package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/3
 * @Description:
Description
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 **/
public class Count_Primes_204 {


    @Test
    public void test() {
        System.out.println(countPrimes(10));
    }

    /**
     * 暴力法超时
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                count++;
            }
        }
        return count;
    }

    /**
     * 暴力法超时
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

