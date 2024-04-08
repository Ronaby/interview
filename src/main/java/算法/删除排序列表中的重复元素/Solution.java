package 算法.删除排序列表中的重复元素;

import 算法.ListNode;

import java.util.List;

/**
 * @Date 2024/4/8
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        ListNode res = removeRepeat(listNode0);
        System.out.println(res);
    }

    /**
     * 双指针做法
     */
    private static ListNode removeRepeat(ListNode head){
        if (head == null) return head;
        ListNode currentNode = head;
        while (currentNode.next != null){
            if (currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
            }else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    /**
     * 递归用法
     */
    private static ListNode removeRepeatWithRecursive(ListNode head){
        if (head == null || head.next == null) return head;
        head.next = removeRepeatWithRecursive(head.next);
        return head.val == head.next.val? head.next: head;
    }
}
