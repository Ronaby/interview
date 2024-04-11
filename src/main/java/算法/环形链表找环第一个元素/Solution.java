package 算法.环形链表找环第一个元素;

import 算法.ListNode;

/**
 * @Description: 环形链表找环第一个元素
 * @Author
 * @Date 2024/4/9
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
       ListNode node0 = new ListNode(3);
       ListNode node1 = new ListNode(2);
       ListNode node2 = new ListNode(0);
       ListNode node3 = new ListNode(-4);
       node0.next = node1;
       node1.next = node2;
       node2.next = node3;
       node3.next = node1;
       ListNode firstNode = firstCycleNode(node0);
       System.out.println(firstNode);

    }

    /**
     * 利用快慢指针，当第一次相遇后，满指针回到投节点
     */
    private static ListNode firstCycleNode(ListNode head){
        if (head == null) return null;
        ListNode faster = head,lower = head;
        boolean cycleFlag = false;
        while (faster.next != null && faster.next.next !=null ){
            faster = faster.next.next;
            lower = lower.next;
            if (lower == faster){
                cycleFlag = true;
                break;
            }
        }
        if (cycleFlag){
            lower = head;
            while (lower != faster){
                lower = lower.next;
                faster = faster.next;
            }
            return lower;
        }
        return null;
    }
}
