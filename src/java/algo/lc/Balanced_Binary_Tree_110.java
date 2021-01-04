package algo.lc;

import algo.other.tree.TreeNode;
import org.junit.Test;

import java.util.Objects;

/**
 * @Author: sunhaijian
 * @Date: 2020/4/20
 * @Description:
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
https://blog.csdn.net/niceHou666/article/details/83215657
本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

      3
     / \
    9  20
  /  \
15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
4   4
返回 false 。
————————————————
版权声明：本文为CSDN博主「niceHou666」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/niceHou666/java/article/details/83215657
 **/
public class Balanced_Binary_Tree_110 {

    @Test
    public void test(){
        TreeNode treeNode=new TreeNode();

        System.out.println(isBalanced(TreeNode.generateNonBalancedTree()));

    }

    public boolean isBalanced(TreeNode root){
        if(Objects.isNull(root)){
            return true;
        }
        if(Math.abs(deth(root.left)-deth(root.right))>1) {
            return false;
        }else{
            return isBalanced(root.left)&&isBalanced(root.right);
        }


    }

    private int deth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(deth(root.left),deth(root.right))+1;
    }
}
