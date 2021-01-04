package algo.lc;

import algo.other.tree.BTreePrinter;
import algo.other.tree.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/25
 * @Description:
 **/
public class Construct_Binary_Search_Tree_From_Preorder_Tranversal_1008 {

    public static void main(String[] args) {
        int[] preorder={8,5,1,7,10,12};
//        int[] preorder={3,1,2};



//        TreeNode treeNode=new TreeNode(preorder[0]);
//        buildTree(preorder,treeNode,0,preorder.length-1);
//
//        Integer [] result=levelTranversal(treeNode,preorder.length);
//
//        System.out.println(JSON.toJSONString(result));

        TreeNode treeNode=dfs(preorder,0,preorder.length-1);

        BTreePrinter.printTreeNode(treeNode);
    }

    private static Integer[] levelTranversal(TreeNode treeNode,int length) {

        if(Objects.isNull(treeNode)){
            return null;
        }
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(treeNode);

        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            list.add(temp.val);

            if(Objects.nonNull(temp.left)){
                stack.push(temp.left);
            }

            if(Objects.nonNull(temp.right)){
                stack.push(temp.right);
            }
        }

        return list.toArray(new Integer[list.size()]);



    }

    /**
     * 我的做法
     * @param preorder
     * @param treeNode
     * @param start
     * @param end
     * @return
     */
    public static  TreeNode buildTree(int[] preorder,TreeNode treeNode,int start,int end){


        for(int i=start+1 ;i <end+1;i++){
            if(preorder[i]>preorder[start]
                    && preorder[i]==preorder[start+1]){
                treeNode.right=new TreeNode(preorder[i]);
                buildTree(preorder,treeNode.right, i, end);

                return null;
            }
            if(preorder[i]>preorder[start]){
                treeNode.left=new TreeNode(preorder[start+1]);
                treeNode.right=new TreeNode(preorder[i]);
                buildTree(preorder,treeNode.left, start+1, i-1);
                buildTree(preorder,treeNode.right, i, end);

                return null;
            }
            if(preorder[i]<preorder[start]
                    &&preorder[i]==preorder[end]){
                treeNode.left=new TreeNode(preorder[start+1]);
                buildTree(preorder,treeNode.left, start+1, i);

                return null;
            }

        }
        return null;
    }

    /**
     * 比较清楚简洁的做法
     * @param preorder
     * @param start
     * @param end
     * @return
     */
    public static TreeNode dfs(int [] preorder,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode treeNode=new TreeNode(preorder[start]);

        int index;
        for (index = start+1;  index <=end; index++) {
            if(preorder[index]>preorder[start]){
                break;
            }
        }

        treeNode.left=dfs(preorder,start+1,index-1);
        treeNode.right=dfs(preorder,index,end);
        return treeNode;
    }


}
