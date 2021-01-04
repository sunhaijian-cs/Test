package algo.lc;

import algo.other.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/9/4
 * @Description:
 *
 * Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

1
/   \
2     3
\
5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 **/
public class Binary_Tree_Paths_257 {
    List<String> result=new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return result;
        }

        String path=String.valueOf(root.val);

        if(root.left==null&&root.right==null){
            result.add(new String(path));
            return result;
        }
        if(root.left!=null){
            getLeafPath(root.left,path);
        }
        if(root.right!=null){
            getLeafPath(root.right,path);
        }

        return result;
    }


    public void getLeafPath(TreeNode root,String path){

        path=path+"->"+root.val;
        if(root.left==null&&root.right==null){
            result.add(new String(path));
            return ;
        }

        if(root.left!=null){
            getLeafPath(root.left,path);
        }
        if(root.right!=null){
            getLeafPath(root.right,path);
        }

    }
}
