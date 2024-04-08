package 算法;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 环形链表
 * @Author
 * @Date 2024/1/31
 * @Version 1.0
 */
public class CycleNode {
    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        node5.next = node3;
        System.out.println(hasCycle(node1));
        System.out.println(hasCycle2(node1));
    }

    /**
     * Set添加的方法
     * @param node
     * @return
     */
    private static boolean hasCycle(Node node){
        Set<Node> set = new HashSet<>();
        while (node != null){
            if (!set.add(node)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private static boolean hasCycle2(Node head){
        if (head == null || head.next == null){
            return false;
        }
        Node slow = head;
        Node quick = head.next;
        while (slow != quick){
            if (quick.next == null || quick.next.next == null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }



}
