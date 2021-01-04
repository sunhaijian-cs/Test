package algo.other.tree;

import java.util.Objects;

/**
 * @Author: sunhaijian
 * @Date: 2019/9/29
 * @Description:
   6
  / \
 /   \
 3   9
/ \ / \
2 4 8 10
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){
    }
    public TreeNode(int value){
        this.val=value;
    }


    public boolean isEmpty(){
        if(Objects.isNull(this)){
            return true;
        }else{
            return false;
        }
    }






    /**
     *
     * 6
     3    9
    2 4  8 10

     *
     * @return
     */
    public static TreeNode  generateTree(){
        TreeNode root=new TreeNode();
        root.val=6;

        TreeNode node2=new TreeNode();
        node2.val=2;
        TreeNode node4=new TreeNode();
        node4.val=4;
        TreeNode node8=new TreeNode();
        node8.val=8;
        TreeNode node10=new TreeNode();
        node10.val=10;

        TreeNode node3=new TreeNode();
        node3.val=3;
        node3.left=node2;
        node3.right=node4;
        TreeNode node9=new TreeNode();
        node9.val=9;
        node9.left=node8;
        node9.right=node10;


        root.left=node3;
        root.right=node9;

        return root;
    }


    /**
     *
     *  6
      3
     2 4

     *
     * @return
     */
    public static TreeNode  generateNonBalancedTree(){
        TreeNode root=new TreeNode();
        root.val=6;

        TreeNode node2=new TreeNode();
        node2.val=2;
        TreeNode node4=new TreeNode();
        node4.val=4;
//        TreeNode node8=new TreeNode();
//        node8.value=8;
//        TreeNode node10=new TreeNode();
//        node10.value=10;

        TreeNode node3=new TreeNode();
        node3.val=3;
        node3.left=node2;
        node3.right=node4;
//        TreeNode node9=new TreeNode();
//        node9.value=9;
//        node9.treeNodeLeft=node8;
//        node9.treeNodeRight=node10;


        root.left=node3;
//        root.treeNodeRight=node9;

        return root;
    }


    /**
     *
     *  6
     3
     2 4

     *
     * @return
     */
    public static TreeNode  generateNonSearchTree(){
        TreeNode root=new TreeNode();
        root.val=10;

        TreeNode node2=new TreeNode();
        node2.val=5;
        TreeNode node3=new TreeNode();
        node3.val=15;
        root.left=node2;
        root.right=node3;

        TreeNode node4=new TreeNode();
        node4.val=14;
        TreeNode node5=new TreeNode();
        node5.val=20;

        node3.left=node4;
        node3.right=node5;


        TreeNode node6=new TreeNode();
        node6.val=13;
        TreeNode node7=new TreeNode();
        node7.val=30;

        node5.left=node6;
        node5.right=node7;

        return root;
    }




    /**
     *
     *  6
           9

     *
     * @return
     */
    public static TreeNode  generateTestTree(){
        TreeNode root=new TreeNode();
        root.val=6;
        TreeNode node2=new TreeNode();
        node2.val=5;
        TreeNode node3=new TreeNode();
        node3.val=9;
        root.left=null;
        root.right=node3;

        return root;
    }

}
