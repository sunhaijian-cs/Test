package algo.lc;

import algo.other.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/15
 * @Description:
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/bfs-kuang-jia

 **/
public class Minimum_Depth_Of_Binary_Tree_111 {
    @Test
    public void test(){

    }

    public int minDepth(TreeNode root) {
        if(root==null){return 0;}
        Deque<TreeNode> deque=new ConcurrentLinkedDeque<>();
        int depth=1;
        deque.offerLast(root);
        while(!deque.isEmpty()){
            for (int i = 0; i < deque.size(); i++) {
                TreeNode temp=deque.pollFirst();
                if(temp.left==null&&temp.right==null){
                    return depth;
                }
                if(temp.left!=null){
                    deque.offerLast(temp.left);
                }
                if(temp.right!=null){
                    deque.offerLast(temp.right);
                }
            }

            depth++;
        }

        return depth;
    }

}

//
//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }