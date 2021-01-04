package algo.other.tree;

import com.alibaba.fastjson.JSONObject;
import com.sun.jmx.remote.internal.ArrayQueue;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: sunhaijian
 * @Date: 2019/9/29
 * @Description: 树的遍历
 **/
public class TraverseTree {
    public static void main(String[] args) {

        TreeNode root=TreeNode.generateTree();

        //层序遍历
//        levelTraversal(root);

        //层序遍历--栈实现
//        levelTraversalQueue(root);

        //层序遍历--递归实现（一般没这么玩的）
        int treeMaxHeight=getTreeMaxHeight(root);
        List<List<Integer>> levelData=new ArrayList<>();
        for (int i = 0; i < treeMaxHeight; i++) {
            levelData.add(new ArrayList<>());
        }

        levelTraversalRecursion(root,levelData,0);
        for (int i = 0; i < treeMaxHeight; i++) {
            System.out.println(JSONObject.toJSONString(levelData.get(i)));
        }



        //先序遍历-递归
//        preorderTraversalRecursion(root);
        //中序遍历-递归
//        inorderTraversalRecursion(root);
        //后序遍历-递归
//        postorderTraversalRecursion(root);



        //先序遍历-非递归(注意栈是先进后出，所以要先将有子节点入栈，而且无法使用队列结构）
//        preorderTraversalNonRecursion(root);

        //中序遍历-非递归(比较麻烦，需要一个辅助节点）
//        inorderTraversalNonRecursion(root);

        //后序遍历-非递归(最麻烦的，需要辅助节点，需要一个flag标识访问节点）
//        postorderTraversalNonRecursion(root);

    }



    private static void postorderTraversalNonRecursion(TreeNode root) {

        if(Objects.isNull(root)){
            return ;
        }

        Stack<TreeNode> stack=new Stack<>();
        TreeNode t=root; //辅助节点
        TreeNode visited=null;//存储访问过的节点 ，防止大量回溯。
        stack.push(t);

        while(!stack.isEmpty()){

            if(Objects.nonNull(t)&& Objects.nonNull(t.left)){
                stack.push(t.left);
                t=t.left;
            }else{
                t=stack.peek();  //不出栈，只取出元素

                if(Objects.isNull(t.right)||t.right==visited){  //如果没有右子节点，或右子节点访问过了。
                    System.out.println(t.val);
                    visited=t;//出栈之后标识已经访问过了
                    t=null;//继续出栈
                    stack.pop();
                }else{   //如果有右子节点，则入栈
//                    visited=t.right;//是否有用？
                    stack.push(t.right);
                    t=t.right;
                }
            }
        }
    }


    private static void inorderTraversalNonRecursion(TreeNode root) {

        if(Objects.isNull(root)){
            return ;
        }

        Stack<TreeNode> stack=new Stack<>();
        TreeNode t=root; //辅助节点
        stack.push(t);

        while(!stack.isEmpty()){

            if(Objects.nonNull(t)&& Objects.nonNull(t.left)){
                stack.push(t.left);
                t=t.left;
            }else{
                 t=stack.pop();  //弹出栈顶节点
                System.out.println(t.val);
                if(Objects.nonNull(t)&&Objects.nonNull(t.right)){  //如果栈顶节点有右孩子，将节点压入栈。
                    stack.push(t.right);
                    t=t.right;
                }else{
                    t=null;   //已经访问过得节点，置空。
                }


            }
        }
    }


    private static void preorderTraversalNonRecursion(TreeNode root) {

        if(Objects.isNull(root)){
            return ;
        }

        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode treeNode=stack.pop();
            if(Objects.isNull(treeNode)){
                continue;
            }

            System.out.println(treeNode.val);
            stack.push(treeNode.right);
            stack.push(treeNode.left);
        }
    }

    private static void postorderTraversalRecursion(TreeNode root) {
        if(Objects.isNull(root)){
            return ;
        }

        postorderTraversalRecursion(root.left);

        postorderTraversalRecursion(root.right);
        System.out.println(root.val);
    }

    private static void inorderTraversalRecursion(TreeNode root) {
        if(Objects.isNull(root)){
            return ;
        }

        inorderTraversalRecursion(root.left);
        System.out.println(root.val);
        inorderTraversalRecursion(root.right);

    }

    private static void preorderTraversalRecursion(TreeNode root) {
        if(Objects.isNull(root)){
            return ;
        }
        System.out.println(root.val);
        preorderTraversalRecursion(root.left);
        preorderTraversalRecursion(root.right);

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
                System.out.println(t.val);
                if(t.left!=null){
                    temp.add(t.left);
                }
                if(t.right!=null){
                    temp.add(t.right);
                }
            }

            nextLevelTreeNode.clear();
            nextLevelTreeNode.addAll(temp);
            temp.clear();
        }
    }

    private static void levelTraversalQueue(TreeNode root) {

        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){

            TreeNode t=queue.poll();
            System.out.println(t.val);
            if(Objects.nonNull(t.left)) {
                queue.offer(t.left);
            }
            if(Objects.nonNull(t.right)) {
                queue.offer(t.right);
            }
        }
    }


    private static int getTreeMaxHeight(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        return Math.max(getTreeMaxHeight(treeNode.left),getTreeMaxHeight(treeNode.right))+1;
    }

    private static void levelTraversalRecursion(TreeNode root,List<List<Integer>> levelData,int level) {
        if(Objects.isNull(root)){
            return;
        }
        levelData.get(level).add(root.val);
        levelTraversalRecursion(root.left,levelData,level+1);
        levelTraversalRecursion(root.right,levelData,level+1);


    }


}


