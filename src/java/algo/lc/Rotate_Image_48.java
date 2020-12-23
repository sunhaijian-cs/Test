package algo.lc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/19
 * @Description:
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
[1,2,3],
[4,5,6],
[7,8,9]
],

原地旋转输入矩阵，使其变为:
[
[7,4,1],
[8,5,2],
[9,6,3]
]

00   01
11
3/2=1




示例 2:

给定 matrix =
[
[ 5, 1, 9,11],
[ 2, 4, 8,10],
[13, 3, 6, 7],
[15,14,12,16]
],

1 0    --> 0 2(length-1-i)
i  j       j  (length-1-i)


原地旋转输入矩阵，使其变为:
[
[15,13, 2, 5],
[14, 3, 4, 1],
[12, 6, 8, 9],
[16, 7,10,11]
]

2 1   --  1 1

[i][matrix[0].length-1-j]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

0 1  --- 1，

输入：
[[5,1,9,11],
[2, 4,8,10],
[13,3,6,7],
[15,14,12,16]]
输出：
[[15,13,9,5],
[2,3,4,1],
[12,6,8,7],
[16,14,10,11]]
预期结果：
[[15,13,2,5],
[14,3,4,1],
[12,6,8,9],
[16,7,10,11]]





[1,2,3,4,5],
[1,2,3,4,5],
[1,2,3,4,5],
[1,2,3,4,5],
[1,2,3,4,5],


2

 00   01  02
      11

哎，想了好几才基本做出来，主要有两种做法
 1，将四分之一的元素，每个元素依次旋转4次

 2，先上下翻转矩阵，然后再对角线翻转矩阵。

 **/
public class Rotate_Image_48 {

    @Test
    public void test(){
        int [][] matirx={{5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};

        rotate(matirx);

        System.out.println(JSON.toJSON(matirx));


    }

    public void rotate(int[][] matrix) {

        for (int i = 0; i <matrix.length/2; i++) {
            for (int j = 0; j <(matrix[0].length+1)/2 ; j++) {
                int temp1=matrix[j][matrix[0].length-1-i];
                matrix[j][matrix[0].length-1-i]=matrix[i][j];


                int temp2=matrix[ matrix.length-1-i][matrix[0].length-1-j];
                matrix[ matrix.length-1-i][matrix[0].length-1-j]=temp1;

                temp1=matrix[ matrix.length-1-j][i];
                matrix[ matrix.length-1-j][i]=temp2;

                matrix[i][j]=temp1;

            }
        }

    }

}
