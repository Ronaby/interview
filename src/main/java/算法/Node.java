package 算法;

/**
 * @Description: 节点
 * @Author
 * @Date 2024/1/16
 * @Version 1.0
 */
public class Node {
    Node next;
    Node prev;

    int val;

    public Node(int val){
        this.val = val;
    }

    public Node(int val,Node next){
        this.val = val;
        this.next = next;
    }

}
