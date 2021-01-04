package algo.other.tree.BSTTree;

import algo.other.tree.BTreePrinter;
import algo.other.tree.TreeNode;
import apple.laf.JRSUIUtils;
import org.junit.Test;

import javax.transaction.TransactionRequiredException;
import java.util.Objects;

/**
 * @Author: sunhaijian
 * @Date: 2020/4/26
 * @Description:
 **/
public class TestTree {

    @Test
    public void test(){

        TreeNode treeNode= TreeNode.generateTree();
        BTreePrinter.printTreeNode(treeNode);

    }

    /**
     * 二叉树所有的节点中的值加一
     */
    @Test
    public void test1(){

        TreeNode treeNode= TreeNode.generateTree();
        BTreePrinter.printTreeNode(treeNode);
        treeNodeValPlus(treeNode);
        BTreePrinter.printTreeNode(treeNode);
    }

    public void treeNodeValPlus(TreeNode treeNode){
        if(treeNode==null){
            return ;
        }
        treeNode.val++;
        treeNodeValPlus( treeNode.left);
        treeNodeValPlus( treeNode.right);
    }





}
