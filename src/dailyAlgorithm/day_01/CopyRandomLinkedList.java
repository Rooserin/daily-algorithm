package dailyAlgorithm.day_01;


import java.util.HashMap;
import java.util.Map;

public class CopyRandomLinkedList {

    public CopyRandomLinkedList() {
    }

    public Node copyRandomLinkedList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        //第一次遍历，建立映射关系
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        //第二次遍历设置新节点的next和random指针
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
