package linkedlist.kk;
/*

Return the Node where cycle begins, If there is no cycle then return null.

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle.
Note that pos is not passed as a parameter.

*/


import java.util.HashMap;
import java.util.Map;

public class LeetCode142 {

    private Node head;
    private Node tail;
    private int size;

    public LeetCode142() {
        this.size = 0;
    }

    public class Node {

        private int value;
        private Node next;

        Node() {

        }

        Node(int val) {
            this.value = val;
        }
    }

    public void display() {
        Node temp = head;

        while (temp != null) {

            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public void increaseSize() {
        size += 1;
    }

    public void decreaseSize() {
        size -= 1;
    }

    public int size() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public void insertAtEnd(int val, boolean createCycle) {

        Node newNode = new Node(val);

        if (head == null && tail == null) {

            head = newNode;
            tail = head;

        } else {

            tail.next = newNode;
            newNode.next = null;

            tail = newNode;
        }

        tail.next = createCycle ? head : null;

        increaseSize();
    }

    // Method 1 : Hashing

    public Node cycleBeginingNode(Node head) {

        Map<Node, Integer> nodeMap = new HashMap<>();

        Node temp = head;

        while (temp != null) {

            if (nodeMap.get(temp) == null) {
                nodeMap.put(temp, 1);
            } else {
                return temp;
            }

            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {

        LeetCode142 l1 = new LeetCode142();
        l1.insertAtEnd(1, false);
        l1.insertAtEnd(2, false);
        l1.insertAtEnd(4, false);
        l1.insertAtEnd(6, false);
        l1.insertAtEnd(7, false);
        l1.insertAtEnd(8, true);
    }

}
