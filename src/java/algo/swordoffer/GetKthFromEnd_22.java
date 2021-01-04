package algo.swordoffer;

import org.junit.Test;

/**
 * @Author: sunhaijian
 * @Date: 2020/6/15
 * @Description:
 **/
public class GetKthFromEnd_22 {
    @Test
    public void test(){


    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;

    }

}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
