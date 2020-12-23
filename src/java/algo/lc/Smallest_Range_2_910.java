package algo.lc;

import java.util.Arrays;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/21
 * @Description:
Given an array `A` of integers, for each integer `A[i]` we need to choose either `x = -K` or `x = K`, and add `x` to `A[i] (only once)`.
After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.

Example 1:

Input: A = [1], K = 0
Output: 0
Explanation: B = [1]
Example 2:

Input: A = [0,10], K = 2
Output: 6 Explanation: B = [2,8]
Example 3:

Input: A = [1,3,6], K = 3
Output: 3
Explanation: B = [4,6,3]
Note:

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000

 思路：
想法

如 最小差值 I 问题的解决方法，较小的 A[i] 将增加，较大的 A[i] 将变小。

算法

我们可以对上述想法形式化表述：如果 A[i] < A[j]，我们不必考虑当 A[i] 增大时 A[j] 会减小。这是因为区间 (A[i] + K, A[j] - K) 是 (A[i] - K, A[j] + K) 的子集（这里，当 a > b 时 (a, b) 表示 (b, a) ）。

这意味着对于 (up, down) 的选择一定不会差于 (down, up)。我们可以证明其中一个区间是另一个的子集，通过证明 A[i] + K 和 A[j] - K 是在 A[i] - K 和 A[j] + K 之间。

对于有序的 A，设 A[i] 是最大的需要增长的 i，那么 A[0] + K, A[i] + K, A[i+1] - K, A[A.length - 1] - K 就是计算结果的唯一值。

作者：LeetCode
链接：https://leetcode-cn.com/problems/smallest-range-ii/solution/zui-xiao-chai-zhi-ii-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



 这个题很巧妙，相当于做了问题转化
 1，排序

 将求整个转化后数组的最值，转变为求A[0] + K, A[i] + K, A[i+1] - K, A[A.length - 1] - K 这四个数的最大值和最小值。
 时间复杂度 O(nlogn)
 空间复杂度O(1)


 **/
public class Smallest_Range_2_910 {
    public int smallestRangeII(int[] A, int K) {
        int N = A.length;
        Arrays.sort(A);
        int ans = A[N-1] - A[0];

        for (int i = 0; i < A.length - 1; ++i) {
            int a = A[i], b = A[i+1];
            int high = Math.max(A[N-1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }


}
