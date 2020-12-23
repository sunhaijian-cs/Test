package algo.lc;

import algo.other.tree.TreeNode;
import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/16
 * @Description:
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

1
/ \
2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

-10
/ \
9  20
/  \
15   7

Output: 42

 **/
public class Binary_Tree_Maximum_Path_Sum_124 {

    static int ans = Integer.MIN_VALUE;
    @Test
    public void test(){

    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        help(root);
        return ans;

    }

    private int help(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=Math.max(0,help(root.left));
        int right=Math.max(0,help(root.right));
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left,right)+root.val;

    }
}
