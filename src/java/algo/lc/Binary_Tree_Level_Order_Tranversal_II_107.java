package algo.lc;

import algo.other.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: sunhaijian
 * @Date: 2020/7/2
 * @Description:
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
3
/ \
9  20
/  \
15   7
return its bottom-up level order traversal as:
[
[15,7],
[9,20],
[3]
]

 **/
public class Binary_Tree_Level_Order_Tranversal_II_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList();
        }
        Queue<TreeNode> q=new LinkedList();
        List<List<Integer>> res=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> midRes=new LinkedList();
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                midRes.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }

            res.add(0,midRes);
        }
        return res;
    }
}
