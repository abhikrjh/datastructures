package linkedlist.kk;
/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
*/


public class LeetCode141 {

    private Node head;
    private Node tail;
    private int size;

    public LeetCode141() {
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

    public boolean hasCycle(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int lengthOfCycle(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // calculate the length of cycle

                int length = 0;

                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);
                return length;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        LeetCode141 l1 = new LeetCode141();
        l1.insertAtEnd(1, false);
        l1.insertAtEnd(2, false);
        l1.insertAtEnd(4, false);
        l1.insertAtEnd(6, false);
        l1.insertAtEnd(7, false);
        l1.insertAtEnd(8, true);

        boolean isCyclic = l1.hasCycle(l1.getHead());

        System.out.println("Cycle is present : " + isCyclic);

        int lengthOfCycle = l1.lengthOfCycle(l1.getHead());

        System.out.println("Length of cycle : " + lengthOfCycle);

    }
}
