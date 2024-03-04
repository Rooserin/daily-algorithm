package dailyAlgorithm.day_01;


/**
 * TODO 给定一个链表，每个节点包含一个额外的随机指针，该指针可以指向链表中的任何节点，也可以为 null。请返回这个链表的深度拷贝。
 */
public class Test {


    public static void main(String[] args) {
        CopyRandomLinkedList solution = new CopyRandomLinkedList();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node1.random = node3;
        node2.next = node3;
        node2.random = node2;
        node3.random = node2;

        Node copiedList = solution.copyRandomLinkedList(node1);

        while (copiedList != null) {
            System.out.print("Value: " + copiedList.val);
            if (copiedList.random != null) {
                System.out.println(",Random: " + copiedList.random.val);
            } else {
                System.out.println(",Random : null");
            }
            copiedList = copiedList.next;
        }
    }
}
