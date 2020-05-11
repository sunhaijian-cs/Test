package algo.other.tree;

import org.junit.Test;

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
}
