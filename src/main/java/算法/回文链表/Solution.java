package 算法.回文链表;

import 算法.ListNode;

import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 回文链表
 * @Author
 * @Date 2024/4/10
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
         ListNode head = new ListNode(1);
         ListNode node = new ListNode(2);
         head.next = node;
        boolean res = isPalindromeLink(head);
        System.out.println(res);
    }


    /**
     * 判断是否回文链表
     */
    //1-2-3-3-2-1
    //快 1-3-2-null
    //慢 1-2-3-3

    //1-2-3-4-3-2-1
    //快1-3-3-1
    //慢1-2-3-4
    public static boolean isPalindromeLink(ListNode head) {
        ListNode faster = head,slower = head;
        while (faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
        }
        if (faster != null){
            slower = slower.next;
        }
        slower = revertLinked(slower);
        faster = head;

        while (slower != null){
            if (faster.val != slower.val){
                return false;
            }
            faster = faster.next;
            slower = slower.next;
        }
        return true;

    }


    /**
     * 反转链表
     */
    private static ListNode revertLinked(ListNode head){
        ListNode preNode = null;
        while (head != null){
            ListNode next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }
        return preNode;
    }
}
