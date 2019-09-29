package algo.other.tree;

/**
 * @Author: sunhaijian
 * @Date: 2019/9/29
 * @Description:
 **/
public class TreeNode {

    int value;
    TreeNode treeNodeLeft;
    TreeNode treeNodeRight;

    /**
     *
     * 6
     3    9
    2 4  8 10

     *
     * @return
     */
    public TreeNode  generateTree(){
        TreeNode root=new TreeNode();
        root.value=6;

        TreeNode node2=new TreeNode();
        node2.value=2;
        TreeNode node4=new TreeNode();
        node4.value=4;
        TreeNode node8=new TreeNode();
        node8.value=8;
        TreeNode node10=new TreeNode();
        node10.value=10;

        TreeNode node3=new TreeNode();
        node3.value=3;
        node3.treeNodeLeft=node2;
        node3.treeNodeRight=node4;
        TreeNode node9=new TreeNode();
        node9.value=9;
        node9.treeNodeLeft=node8;
        node9.treeNodeRight=node10;


        root.treeNodeLeft=node3;
        root.treeNodeRight=node9;

        return root;
    }
}
