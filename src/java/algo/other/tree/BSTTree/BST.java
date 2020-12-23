package algo.other.tree.BSTTree;

import algo.other.tree.BTreePrinter;
import algo.other.tree.TreeNode;
import org.junit.Test;

import java.util.Objects;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/22
 * @Description:
 BST框架

void BST(TreeNode root, int target) {
if (root.val == target)
// 找到目标，做点什么
if (root.val < target)
BST(root.right, target);
if (root.val > target)
BST(root.left, target);
}


 **/
public class BST {
    static TreeNode preNode=null;
    /**
     * 校验是否是二叉搜索树
     */
    @Test
    public void testValidBST(){
//        TreeNode treeNode1= TreeNode.generateTree();
        TreeNode treeNodeNonBST = TreeNode.generateNonSearchTree();

        BTreePrinter.printTreeNode(treeNodeNonBST);

//        System.out.println(isValidBST(treeNodeNonBST,null,null));
        System.out.println(isValidBSTInOrder(treeNodeNonBST));


    }
    /**
     * 在BST中查找一个数
     */
    @Test
    public void testSearchInBST(){
        TreeNode treeNode1= TreeNode.generateTree();

//        BTreePrinter.printTreeNode(treeNodeNonBST);

        Boolean result=isInBST(treeNode1,5);
        System.out.println(result);


    }

    /**
     * 在BST中插入一个数
     */
    @Test
    public void testInsertIntoBST(){
        TreeNode treeNode= TreeNode.generateTree();

        BTreePrinter.printTreeNode(treeNode);

        TreeNode result=insertIntoBST(treeNode,50);

        BTreePrinter.printTreeNode(result);



    }

    /**
     * 在BST中插入一个数
     */
    @Test
    public void testDeleteNodeBST(){
        TreeNode treeNode= TreeNode.generateTree();

        BTreePrinter.printTreeNode(treeNode);

        TreeNode result=deleteNode(treeNode,9);

        BTreePrinter.printTreeNode(result);



    }

    private TreeNode deleteNode(TreeNode treeNode, int key) {
        if(treeNode ==null) {
            return null;
        }
        if(treeNode.val==key){
            if(treeNode.left==null) {
                return treeNode.right;
            }
            if(treeNode.right==null){
                return treeNode.left;
            }
            TreeNode minNode= getMin(treeNode.right);
            treeNode.val=minNode.val;
            treeNode.right =deleteNode(treeNode.right,minNode.val);

        }else if(treeNode.val>key){
            treeNode.left =deleteNode(treeNode.left,key);
        }else if(treeNode.val<key){
            treeNode.right= deleteNode(treeNode.right,key);
        }
        return treeNode;

    }

    private TreeNode getMin(TreeNode right) {
        while (right.left!=null) {
            right=right.left;
        }
        return right;
    }

    private TreeNode insertIntoBST(TreeNode treeNode, int i) {
        if(Objects.isNull(treeNode)){
            return new TreeNode(i);
        }
        if(treeNode.val>i){
            treeNode.left= insertIntoBST(treeNode.left,i);
        }
        if(treeNode.val<i){
            treeNode.right= insertIntoBST(treeNode.right,i);
        }
        return treeNode;
    }

    private Boolean isInBST(TreeNode treeNode1,int target) {
        if(Objects.isNull(treeNode1)){
            return false;
        }
        if(treeNode1.val==target){
            return true;
        }
        if(treeNode1.val>target){
            isInBST(treeNode1.left,target);
        }
        if(treeNode1.val<target){
            isInBST(treeNode1.right,target);
        }

        return false;
    }


    public boolean isValidBST(TreeNode root, TreeNode min , TreeNode max){
        if(Objects.isNull(root)) {
            return true;
        }
        System.out.println(root.val+"    "+(Objects.isNull(min)?"null":min.val)+"   "+(Objects.isNull(max)?"null":max.val));
        if(Objects.nonNull(min) &&root.val<=min.val) {
            return false;
        }

        if(Objects.nonNull(max) &&root.val>=max.val) {
            return false;
        }
        return isValidBST( root.left,min,root)
                && isValidBST( root.right,root,max);

    }

    /**
     * 中序遍历的方式来判断是否是二叉搜索树
     * @param root
     * @return
     */
    public  boolean isValidBSTInOrder(TreeNode root){


        if(Objects.isNull(root)) {
            return true;
        }
        boolean resultLeft=isValidBSTInOrder( root.left);
        if(Objects.isNull(preNode)){
            preNode=root;
        }else{
            if(root.val<=preNode.val){
                return false;
            }
            preNode=root;
        }
        boolean resultRight=isValidBSTInOrder( root.right);

        return resultLeft&&resultRight;

    }

}
