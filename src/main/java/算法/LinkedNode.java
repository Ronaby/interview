package 算法;

/**
 * @Description: 链表
 * @Author
 * @Date 2024/1/16
 * @Version 1.0
 */
public class LinkedNode {

    private Node head ;

    public LinkedNode(){}

    public LinkedNode(Node head){
        this.head = head;
    }

    public LinkedNode(int val){
        this.head  = new Node(val);
    }


    public static void main(String[] args) {
        Node node1 = new Node(5,null);
        Node node2 = new Node(4,node1);
        Node node3 = new Node(3,node2);
        Node node4 = new Node(2,node3);
        Node node5 = new Node(1,node4);
        LinkedNode linkedNode  = new LinkedNode();
        linkedNode.head = node5;
        System.out.println(linkedNode.toString());
    }

    @Override
    public String toString() {
        if (head == null){
            return "";
        }
        StringBuilder strb = new StringBuilder();
        strb.append(head.val);
        Node curNode = head.next;
        while (curNode != null){
            strb.append("-->").append(curNode.val);
            curNode = curNode.next;
        }
        return strb.toString();
    }
}
