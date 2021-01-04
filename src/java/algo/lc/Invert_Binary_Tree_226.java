package algo.lc;

import algo.other.tree.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.Objects;

/**
 * Leetcode 226: Invert Binary Tree
        4
      /   \
     2     7
    / \   / \
   1   3 6   9
 to
      4
    /   \
   7     2
  / \   / \
 9   6 3   1

 Trivia:
 This problem was inspired by this original tweet by Max Howell:
   Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
 方法一：循环，栈存储（DFS，非递归)
 本质思想是，左右节点进行交换，循环翻转每个节点的左右子节点，将未翻转的子节点存入栈中，循环直到栈里所有节点都循环交换完为止。

 方法二：循环，队列存储（BFS，非递归）
 本质思想是，左右节点进行交换，循环翻转每个节点的左右子节点，将未翻转的子节点存入队列中，循环直到栈里所有节点都循环交换完为止。

 方法三：递归
 本质思想也是左右节点进行交换，交换前递归调用对根结点的左右节点分别进行处理，保证交换前左右节点已经翻转。

 https://zhuanlan.zhihu.com/p/76818774
 **/
public class Invert_Binary_Tree_226 {


    public static void main(String[] args) {

        TreeNode root=TreeNode.generateTree();

        //层序遍历
        invertBinaryTree(root);

        System.out.println(JSON.toJSONString(root));


    }

    private static void invertBinaryTree(TreeNode root) {
        if(Objects.isNull(root)){
            return ;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        return ;
    }

}
