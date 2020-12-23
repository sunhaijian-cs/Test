package algo.lc;

import org.junit.Test;

import java.util.Objects;

/**
 * @Author: sunhaijian
 * @Date: 2020/5/29
 * @Description:
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
反转单链表：迭代法，递归法

 扩展问题：
反转链表前 N 个节点
反转链表的一部分，区间[m,n]
https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/di-gui-fan-zhuan-lian-biao-de-yi-bu-fen



 **/
public class Reverse_Linked_List_206 {

    @Test
    public void test(){
        ListNode node5=new ListNode();
        node5.val=5;
        node5.next=null;

        ListNode node4=new ListNode();
        node4.val=4;
        node4.next=node5;

        ListNode node3=new ListNode();
        node3.val=3;
        node3.next=node4;

        ListNode node2=new ListNode();
        node2.val=2;
        node2.next=node3;

        ListNode node1=new ListNode();
        node1.val=1;
        node1.next=node2;

//        printList(node1);

//        ListNode result=reverseLinkedListIteration(node1);
        ListNode result=reverseLinkedListRecursion(node1);
        printList(result);

    }



    public ListNode reverseLinkedListIteration(ListNode listNode){

        if(listNode==null||listNode.next==null){
            return listNode;
        }
        ListNode pre=null;
        ListNode cur=listNode;
        ListNode lat=cur.next;
        while (cur!=null){
            cur.next=pre;
            pre=cur;
            cur=lat;
            if(lat.next==null){
                break;
            }
            lat =lat.next;
        }
        cur.next=pre;
        return cur;
    }

    public ListNode reverseLinkedListRecursion(ListNode listNode){

        if(listNode==null||listNode.next==null){
            return listNode;
        }
        ListNode node=reverseLinkedListRecursion(listNode.next);
        listNode.next.next=listNode;
        listNode.next=null;
        return node;
    }





    public void printList(ListNode listNode){

        ListNode temp=listNode;
        while (Objects.nonNull(temp)){
            System.out.println(temp.val);
            temp=temp.next;
        }


    }



}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}