package algo.other.tree;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: sunhaijian
 * @Date: 2019/12/20
 * @Description:
 *
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

示例 :
给定二叉树

1
/ \
2   3
/ \
4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 **/
public class DiameterOfBinaryTree {


    public static void main(String[] args) {


        TreeNode treeNode=new TreeNode().generateTree();
        System.out.println(diameterOfBinaryTree(treeNode));;


    }

    public static int diameterOfBinaryTree(TreeNode root) {
        AtomicReference<Integer> ret = new AtomicReference<>(0);
        find(root, ret);
        return ret.get();
    }

    private static int find(TreeNode node, AtomicReference<Integer> result) {
        if (node == null) return 0;
        int left = 0, right = 0;
        if (node.treeNodeLeft != null) left = find(node.treeNodeLeft,result) + 1;
        if (node.treeNodeRight != null) right = find(node.treeNodeRight,result) + 1;
        int tmp = Math.max(result.get(), left + right);
        result.set(tmp);
        return Math.max(left, right);
    }

}
