package 算法.链表中间节点;

import 算法.ListNode;

/**
 * @ClassName: Solution
 * @Description: 链表中间节点
 * @Author
 * @Date 2024/4/10
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode centerNode = centerNode(head);
        System.out.println(centerNode);
//      1 2 3 4 5 6
//            快 1-3-5-null
//            慢 2-3-4
//     1 2 3 4 5 6 7
//     快 1-3-5-7
//     慢 1-2-3-4
    }

    /**
     * 快慢指针
     */
    private static ListNode centerNode(ListNode head){
        ListNode faster = head,slower = head;
        while (faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
        }
        return slower;
    }
}
