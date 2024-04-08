package 算法.合并两个有序链表;

import 算法.ListNode;

/**
 * @Description: 合并两个有序链表
 * @Date 2024/4/8
 * @Version 1.0
 */
class Solution {

    public static void main(String[] args) {
       ListNode nodeA0 = new ListNode(1);
       ListNode nodeA1 = new ListNode(2);
       ListNode nodeA2 = new ListNode(4);
       nodeA0.next = nodeA1;
       nodeA1.next = nodeA2;
       /****************************/
        ListNode nodeB0 = new ListNode(1);
        ListNode nodeB1 = new ListNode(3);
        ListNode nodeB2 = new ListNode(4);
        nodeB0.next = nodeB1;
        nodeB1.next = nodeB2;

        ListNode res = mergeTwoListNode(nodeA0,nodeB0);
        System.out.println(res);
    }
    private static ListNode mergeTwoListNode(ListNode list1,ListNode list2){
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode resListNode = new ListNode(0);
        ListNode p = resListNode;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 == null){
            p.next = list2;
        }
        if (list2 == null){
            p.next = list1;
        }
         return  resListNode.next;
    }
}


