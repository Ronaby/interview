package 算法.反转链表;

import 算法.ListNode;

/**
 * @Description: 反转链表
 * @Author
 * @Date 2024/4/10
 * @Version 1.0
 */
public class RevertLinked {
    public static void main(String[] args) {
    }


    private static ListNode revertLinked(ListNode head){
      if (head == null) return null;
      ListNode preNode = null;
      ListNode curNode = head;
      while (curNode != null){
          ListNode next = curNode.next;
          curNode.next = preNode;
          preNode = curNode;
          curNode = next;
      }
      return preNode;
    }
}
