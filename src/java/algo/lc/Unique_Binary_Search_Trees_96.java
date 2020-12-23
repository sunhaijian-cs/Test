package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/24
 * @Description:
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3

input 1   1

input 2  2


input  3
1开头  2
2开头 1
3开头 2



 input 4

1开头   5  f(3)
2开头   2  f(2)*f(1)
3开头   2  f(1)* f(2)
 4开头  5  f(3)



 n
 n-1  （n-2）+2  。。。。。n-1
 f(n-1)  f(n-2)*f(2)  f(n-3) +f(3)



 **/
public class Unique_Binary_Search_Trees_96 {
    @Test
    public void Test(){
        System.out.println(numTrees(4));
    }
    public int numTrees(int n) {
        int []nums =new int[n+1];
        nums[1]=1;
        nums[2]=2;
//        nums[3]=5;    2+ 1*1+2


        if(n<3){
            return nums[n];
        }

        for (int i = 3; i <=n ; i++) {

            int sum=0;
            sum+=2*nums[i-1];
            for (int j = 1; j <=i-2 ; j++) {
                sum+=nums[j]*nums[i-1-j];
            }
            nums[i]=sum;
        }
        return nums[n];
    }




}
