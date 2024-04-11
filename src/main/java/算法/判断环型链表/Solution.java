package 算法.判断环型链表;

import 算法.ListNode;

/**
 * @ClassName: Solution
 * @Description: 判断环形链表
 * @Author
 * @Date 2024/4/8
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        boolean res = hasCycle(head);
        System.out.println(res);
    }


    /**
     * 快慢指针
     */
    private static boolean hasCycle(ListNode head){
        if (head == null)return false;
        ListNode faster = head,slower = head;
        while (faster.next != null && faster.next.next != null){
            faster = faster.next;
            slower  = slower.next;
            if (slower == faster){
                return true;
            }
        }
        return false;
    }
}
