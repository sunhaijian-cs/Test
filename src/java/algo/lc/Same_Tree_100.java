package algo.lc;

import algo.other.tree.TreeNode;

/**
 * @Author: sunhaijian
 * @Date: 2020/8/7
 * @Description:
 * Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
/ \       / \
2   3     2   3

[1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
/           \
2             2

[1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
/ \       / \
2   1     1   2

[1,2,1],   [1,1,2]

Output: false
 **/
public class Same_Tree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val==q.val){
            boolean res1= isSameTree(p.left,q.left);
            boolean res2= isSameTree(p.right,q.right);
            return res1&&res2;
        }else{
            return false;
        }
    }
}
