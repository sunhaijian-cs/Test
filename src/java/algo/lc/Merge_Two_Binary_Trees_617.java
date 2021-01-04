package algo.lc;

import algo.other.tree.BTreePrinter;
import algo.other.tree.TreeNode;
import apple.laf.JRSUIUtils;
import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author: sunhaijian
 * @Date: 2020/4/26
 * @Description:
 *
 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，
两个二叉树的一些节点便会重叠。你需要将他们合并为一个新的二叉树。
合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
否则不为 NULL 的节点将直接作为新二叉树的节点。

输入:
Tree 1                     Tree 2
     1                         2
    / \                       / \
   3   2                     1   3
  /                           \   \
 5                             4   7
输出:
合并后的树:
    3
   / \
  4   5
 / \   \
5   4   7

这道题目主要考察二叉树的遍历方式，前序遍历、中序遍历和后序遍历、层序遍历，
原则上可以采用任何一种遍历方式解决此题。
 主要方法分为两种，
1，递归很简单
2，迭代




 **/
public class Merge_Two_Binary_Trees_617 {
    @Test
    public void test(){

        TreeNode t1=TreeNode.generateTree();
        TreeNode t2= TreeNode.generateNonBalancedTree();

//        TreeNode result=mergeBinaryTree(t1,t2);
//        TreeNode result=mergeBinaryTree2(t1,t2);
        TreeNode result=mergeBinaryTree3(t1,t2);

        BTreePrinter.printTreeNode(result);


    }
    public TreeNode mergeBinaryTree(TreeNode t1, TreeNode t2){
        if(Objects.isNull(t1)){
            return t2;
        }
        if(Objects.isNull(t2)){
            return t1;
        }
        t1.val=t1.val+t2.val;
        t1.left=mergeBinaryTree(t1.left,t2.left);
        t1.right=mergeBinaryTree(t1.right,t2.right);
        return t1;
    }


    /**
     * 我的写法
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeBinaryTree2(TreeNode t1, TreeNode t2){



        Stack <TreeNode []> stack=new Stack<>();

        stack.push(new TreeNode[]{t1,t2});

        while(!stack.isEmpty()){
            TreeNode [] t=stack.pop();

            if(Objects.isNull(t[0])){
                t[0]=t[1];
                continue;
            }
            if(Objects.isNull(t[1])){
                continue;
            }

            t[0].val+=t[1].val;

            stack.push(new TreeNode[]{t[0].right,t[1].right});
            stack.push(new TreeNode[]{t[0].left,t[1].left});

        }
        return t1;
    }


    /**
     * 其他写法
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeBinaryTree3(TreeNode t1, TreeNode t2){

        if(Objects.isNull(t1)){
            return t2;
        }



        Stack <TreeNode []> stack=new Stack<>();

        stack.push(new TreeNode[]{t1,t2});

        while(!stack.isEmpty()){
            TreeNode [] t=stack.pop();

            if(Objects.isNull(t[0])||Objects.isNull(t[1]) ){

                continue;
            }

            t[0].val+=t[1].val;

            if(Objects.isNull(t[0].left)){
                t[0].left=t[1].left;
            }else{
                stack.push(new TreeNode[]{t[0].left,t[1].left});
            }

            if(Objects.isNull(t[0].right)){
                t[0].right=t[1].right;
            }else{
                stack.push(new TreeNode[]{t[0].right,t[1].right});
            }
        }
        return t1;
    }

}
