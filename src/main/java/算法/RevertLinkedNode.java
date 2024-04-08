package 算法;

/**
 * @Description: 反转链表
 * @Author
 * @Date 2024/1/17
 * @Version 1.0
 */
public class RevertLinkedNode {
    public static void main(String[] args) {
        Node node1 = new Node(5,null);
        Node node2 = new Node(4,node1);
        Node node3 = new Node(3,node2);
        Node node4 = new Node(2,node3);
        Node node5 = new Node(1,node4);
        Node resNode =  revertLink(node5);
        System.out.println(resNode);

        Node resNode1 =  revertLink(node5);
        System.out.println(resNode1);
    }

    //迭代法反转链表
    private static Node revertLink(Node head){
        Node prev = null,next;
        Node curNode = head;
        while (curNode != null){
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode  = next;
        }
        return prev;
    }

    /**
     * 递归法律反转链表
     */
    private static Node recursionLink(Node head){
        while(head == null || head.next == null){
            return head;
        }
        Node new_head = recursionLink(head);
        head.next.next = head;
        head.next = null;
        return new_head;
    }
}


