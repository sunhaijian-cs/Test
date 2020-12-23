package algo.lc;

import algo.other.tree.TreeNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: sunhaijian
 * @Date: 2020/7/22
 * @Description:
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
3
/ \
9  20
/  \
15   7
return its zigzag level order traversal as:
[
[3],
[20,9],
[15,7]
]
 **/
public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

    @Test
    public void test(){


        System.out.println(JSON.toJSONString(zigzagLevelOrder2(TreeNode.generateTree())));
    }


    /**
     * 虽然过了，还需要研究研究
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList();
        if(root!=null){
            deque.addFirst(root);
        }

        boolean flag=true;
        while(!deque.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            Deque<TreeNode> tempDeque=new LinkedList();

            int n=deque.size();
            for (int i = 0; i < n; i++) {

                TreeNode treeNode;
                if(flag){
                    treeNode=deque.pollLast();

                }else{
                    treeNode=deque.pollFirst();
                }


                if(treeNode ==null){
                    continue;
                }
                temp.add(treeNode.val);

                if(flag){
                    tempDeque.addFirst(treeNode.left);
                    tempDeque.addFirst(treeNode.right);


                }else{
                    tempDeque.addLast(treeNode.right);
                    tempDeque.addLast(treeNode.left);
                }
            }

            deque.addAll(tempDeque);
                flag=!flag;


            if(!temp.isEmpty()){
                res.add(temp);
            }

        }



        return res;

    }


    /**
     * 上面的想法把自己都绕晕了，  其实还是可以按正常的层序遍历，只在存储到list的时候正序和逆序存储就好。
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList();
        if(root!=null){
            deque.addFirst(root);
        }

        boolean flag=true;
        while(!deque.isEmpty()){
            List<Integer> temp=new ArrayList<>();

            int n=deque.size();
            for (int i = 0; i < n; i++) {

                TreeNode treeNode=deque.pollLast();

                if(treeNode ==null){
                    continue;
                }
                if(flag){
                    temp.add(treeNode.val);
                }else {
                    temp.add(0,treeNode.val);
                }

                deque.addFirst(treeNode.left);
                deque.addFirst(treeNode.right);

            }
            flag=!flag;
            if(!temp.isEmpty()){
                res.add(temp);
            }
        }
        return res;

    }
}
