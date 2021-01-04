package algo.other.tree.completeBinaryTree;

import algo.other.tree.TreeNode;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/26
 * @Description:
 **/
public class CompleteBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 普通二叉树计算所有结点数量
     * 时间复杂度
     * @param treeNode
     * @return
     */
    public int countNodes(TreeNode treeNode){
        if(treeNode==null) {
            return 0;
        }
        return 1+countNodes(treeNode.left)+countNodes(treeNode.right);
    }

    /**
     * 满二叉树计算所有结点数量
     * 时间复杂度O(logN)
     * @param treeNode
     * @return
     */
    public int countNodesForPerfectBinaryTree(TreeNode treeNode){
        int h=0;
        while (treeNode!=null){

            treeNode=treeNode.left;
            h++;

        }
        return (int)(Math.pow(2,h)-1);
    }

    /**
     * 完全二叉树计算所有结点数量
     * 时间复杂度O(logN*logN)
     看图就明显了吧，由于完全二叉树的性质，其子树一定有一棵是满的，所以一定会触发 hl == hr，只消耗 O(logN) 的复杂度而不会继续递归。
     综上，算法的递归深度就是树的高度 O(logN)，每次递归所花费的时间就是 while 循环，需要 O(logN)，所以总体的时间复杂度是 O(logN*logN)。
     * @param treeNode
     * @return
     */
    public int countNodesForCompleteBinaryTree(TreeNode treeNode){
        TreeNode l = treeNode, r = treeNode;
        int lh=0,rh=0;
        while (l!=null){
            l=l.left;
            lh++;

        }
        while (r!=null){
            r=r.left;
            rh++;

        }
        if(rh==lh){
            return (int)(Math.pow(2,rh)-1);
        }

        return 1+countNodesForCompleteBinaryTree(treeNode.left)+countNodesForCompleteBinaryTree(treeNode.right);
    }
}
