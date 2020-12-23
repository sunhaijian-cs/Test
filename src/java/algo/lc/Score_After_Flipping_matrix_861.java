package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/7
 * @Description:
 * We have a two dimensional matrix A where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.



Example 1:

Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39


Note:

1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j] is 0 or 1.


贪心思想
 思考顺序是
 首先调整行，让最左边的一列全都是1
 然后从最左边的第二行依次调整列

 官方给的代码非常简洁，看的很舒服
 从左到右每一列都可以独立依次放到result中。
 在对第二列开始的值进行转换时，注意横向翻转的影响



不难发现一点：为了得到最高的分数，矩阵的每一行的最左边的数都必须为 11。为了做到这一点，我们可以翻转那些最左边的数不为 11 的那些行，而其他的行则保持不动。

当将每一行的最左边的数都变为 11 之后，就只能进行列翻转了。为了使得总得分最大，我们要让每个列中 11 的数目尽可能多。因此，我们扫描除了最左边的列以外的每一列，如果该列 00 的数目多于 11 的数目，就翻转该列，其他的列则保持不变。

实际编写代码时，我们无需修改原矩阵，而是可以计算每一列对总分数的「贡献」，从而直接计算出最高的分数。假设矩阵共有 mm 行 nn 列，计算方法如下：

对于最左边的列而言，由于最优情况下，它们的取值都为 11，因此每个元素对分数的贡献都为 2^{n-1}2
n−1
，总贡献为 m \times 2^{n-1}m×2
n−1
。

对于第 jj 列（j>0j>0，此处规定最左边的列是第 00 列）而言，我们统计这一列 0,10,1 的数量，令其中的最大值为 kk，则 kk 是列翻转后的 11 的数量，该列的总贡献为 k \times 2^{n-j-1}k×2
n−j−1
。需要注意的是，在统计 0,10,1 的数量的时候，要考虑最初进行的行反转。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/score-after-flipping-matrix/solution/fan-zhuan-ju-zhen-hou-de-de-fen-by-leetc-cxma/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 **/
public class Score_After_Flipping_matrix_861 {

    @Test
    public void test(){

    }




    public int matrixScore(int[][] A) {

        int rows=A.length;
        int cols=A[0].length;

        int result=rows*(1<<(cols-1));

        for (int i = 1; i < cols; i++) {


            int counts=0;

            for (int j = 0; j <rows; j++) {
                if(A[j][0]==1){
                    counts+=A[j][i];
                }else{
                    counts+=1-A[j][i];
                }
            }
            int countRes=Math.max(counts,rows-counts);
            result+=countRes*(1<<(cols-1-i));
        }

            return result;

    }

}
