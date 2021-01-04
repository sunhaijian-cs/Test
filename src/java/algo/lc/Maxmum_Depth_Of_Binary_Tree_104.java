package algo.lc;

import algo.other.tree.TreeNode;
import org.junit.Test;

import java.util.Objects;

/**
 * @Author: sunhaijian
 * @Date: 2020/12/1
 * @Description:

Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 
Example 1:
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 
Example 1:
￼
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:
Input: root = [1,null,2]
Output: 2
Example 3:
Input: root = []
Output: 0
Example 4:
Input: root = [0]
Output: 1
 
Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100

Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:
Input: root = [1,null,2]
Output: 2
Example 3:
Input: root = []
Output: 0
Example 4:
Input: root = [0]
Output: 1
 
Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100

 **/
public class Maxmum_Depth_Of_Binary_Tree_104 {

    @Test
    public void test(){

        System.out.println( maxDepth(TreeNode.generateTestTree()));


    }

    public   int maxCount=0;

    public int maxDepth(TreeNode root) {
        if(Objects.isNull(root)){
            return 0;
        }

        countMaxDepth(root,1);
        return maxCount;

    }


    public void countMaxDepth(TreeNode root,int count) {

        if(count>maxCount){
            maxCount=count;
        }

        if(Objects.nonNull(root.left)){
            countMaxDepth(root.left,count+1);
        }

        if(Objects.nonNull(root.right)){
            countMaxDepth(root.right,count+1);
        }
    }


}
