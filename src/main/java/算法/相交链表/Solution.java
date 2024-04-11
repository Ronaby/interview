package 算法.相交链表;

import 算法.ListNode;

/**
 * @Description: 相交链表,返回相交的链表节点
 * @Author
 * @Date 2024/4/10
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode headA1 = new ListNode(1);
        ListNode headC0 = new ListNode(2);
        ListNode headC1 = new ListNode(3);
        ListNode headC2 = new ListNode(4);
        headA.next = headA1;
        headA1.next = headC0;
        headC0.next = headC1;
        headC1.next = headC2;

        ListNode headB = new ListNode(5);
        ListNode headB1 = new ListNode(6);
        ListNode headB2 = new ListNode(7);
        headB.next = headB1;
        headB1.next = headB2;
        headB2.next= headC0;
//        ListNode resNode = getIntersectFirstNode(headA,headB);
        ListNode resNode = getIntersectFirstNode1(headA,headB);
        System.out.println("resNode===" + resNode);
    }
    /**
     * 双指针算法
     */
    private static ListNode getIntersectFirstNode(ListNode headA, ListNode headB){
        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;
        while (currentNodeA != currentNodeB){
            currentNodeA = currentNodeA==null ? headB:currentNodeA.next;
            currentNodeB = currentNodeB==null? headA:currentNodeB.next;
        }
        return currentNodeA;
    }

    /**
     * 通过长度差来找到第一个节点
     */
    private static ListNode getIntersectFirstNode1(ListNode headA, ListNode headB){
        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;
        int l1 = 0,l2 = 0,diff = 0;
        while (currentNodeA != null){
            currentNodeA = currentNodeA.next;
            l1++;
        }
        while (currentNodeB != null){
            currentNodeB = currentNodeB.next;
            l2++;
        }
        if (l1 < l2){
            currentNodeA = headB;
            currentNodeB = headA;
            diff = l2 - l1;
        }else {
            currentNodeA = headA;
            currentNodeB = headB;
            diff = l1 - l2;
        }
        for (int i=0;i<diff;i++){
            currentNodeA = currentNodeA.next;
            while (currentNodeA != currentNodeB){
                return currentNodeA;
            }
            currentNodeA = currentNodeA.next;
            currentNodeB = currentNodeB.next;
        }
        return null;
    }
}
