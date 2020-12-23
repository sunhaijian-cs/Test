package algo.lc;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/10
 * @Description:
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.




Follow up:

Can you solve it using O(1) (i.e. constant) memory?

 判断单链表是否有环
 **/
public class Linked_List_Cycle_141 {
    @Test
    public void test(){

    }
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;

        while(fast!=null&&slow!=null){
            if(fast.next==null){
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;

    }

}
