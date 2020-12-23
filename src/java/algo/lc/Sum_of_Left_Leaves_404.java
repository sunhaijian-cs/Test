package algo.lc;

import algo.other.tree.TreeNode;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/24
 * @Description:
Find the sum of all left leaves in a given binary tree.

Example:

3
/ \
9  20
/  \
15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 **/
public class Sum_of_Left_Leaves_404 {

    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        tranverseTree(root,false);
        return sum;

    }

    private void tranverseTree(TreeNode root,boolean isLeft){
        if(root==null){
            return ;
        }
        if(root.left==null&&root.right==null&&isLeft){
            sum+=root.val;
        }

        tranverseTree(root.left,true);
        tranverseTree(root.right,false);


    }
}
