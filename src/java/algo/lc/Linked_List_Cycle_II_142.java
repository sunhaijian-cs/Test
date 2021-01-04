package algo.lc;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/10
 * @Description:
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.




Follow-up:
Can you solve it without using extra space?

  如果有环，返回环开始的位置。
https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/shuang-zhi-zhen-ji-qiao
 **/
public class Linked_List_Cycle_II_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;

        while(fast!=null&&slow!=null){
            if(fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||slow==null){
            return null;
        }
        slow=head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        return slow;
    }
}
