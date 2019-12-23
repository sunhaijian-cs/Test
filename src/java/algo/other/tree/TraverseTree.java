package algo.other.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2019/9/29
 * @Description: 树的遍历
 **/
public class TraverseTree {
    public static void main(String[] args) {

        TreeNode root=new TreeNode().generateTree();

        //层序遍历
        levelTraversal(root);


    }

    private static void levelTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        List<TreeNode> nextLevelTreeNode=new ArrayList();
        nextLevelTreeNode.add(root);

        while(nextLevelTreeNode.size()!=0){
            List<TreeNode> temp=new ArrayList();
            for (TreeNode t: nextLevelTreeNode) {
                System.out.println(t.value);
                if(t.treeNodeLeft!=null){
                    temp.add(t.treeNodeLeft);
                }
                if(t.treeNodeRight!=null){
                    temp.add(t.treeNodeRight);
                }
            }

            nextLevelTreeNode.clear();
            nextLevelTreeNode.addAll(temp);
            temp.clear();
        }
    }

}


