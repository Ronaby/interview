package 算法;

/**
 * @Description: 链表反转
 * @Author
 * @Date 2024/1/16
 * @Version 1.0
 */
public class RevertLinked {

    public static void main(String[] args) {
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,node1);
        Node node3 = new Node(3,node2);
        Node node4 = new Node(4,node3);
        Node node5 = new Node(5,node4);
        System.out.println(iterator(node5));
    }

    private static Node iterator(Node head){
        Node prev = null,next;
        Node curNode = head;
        while (curNode != null){
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }
        return prev;
    }

}


