package linkedlist.kk;
/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: list1 = [], list2 = []
Output: []

Input: list1 = [], list2 = [0]
Output: [0]
*/

public class LeetCode21 {

    private Node head;
    private Node tail;
    private int size;

    public LeetCode21() {
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

    public void insertAtEnd(int val) {

        Node newNode = new Node(val);

        if (head == null && tail == null) {

            head = newNode;
            tail = head;

        } else {

            tail.next = newNode;
            newNode.next = null;

            tail = newNode;
        }

        increaseSize();
    }


    public Node mergeTwoLists(Node node1, Node node2) {
        /*
        node1 = [1,2,4]
        node2 = [1,3,4,5]
        */

        Node dummy = new Node();
        Node current = dummy;


        while (node1 != null && node2 != null) {

            if (node1.value <= node2.value) {

                current.next = node1;
                node1 = node1.next;
            } else {

                current.next = node2;
                node2 = node2.next;
            }

            current = current.next;
        }

        // attach the remaining nodes if any

        if (node1 != null) {
            current.next = node1;
        }

        if (node2 != null) {
            current.next = node2;
        }

        return dummy.next;
    }

    public Node mergeTwoLists1(Node node1, Node node2) {

        /*
        node1 = [1,2,4]
        node2 = [1,3,4,5,6]
        o/p : 1, 1, 2, 3, 4, 4, 5, 6
        */

        Node dummyNode = new Node();
        Node currNode = dummyNode;

        while (node1 != null && node2 != null) {

            if (node1.value <= node2.value) {

                currNode.next = node1;
                currNode = node1;
                node1 = node1.next;
            } else {

                currNode.next = node2;
                currNode = node2;
                node2 = node2.next;
            }
        }

        // attach the remaining nodes if any

        if (node1 != null) {
            currNode.next = node1;
        }

        if (node2 != null) {
            currNode.next = node2;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {

        LeetCode21 l1 = new LeetCode21();
        l1.insertAtEnd(1);
        l1.insertAtEnd(2);
        l1.insertAtEnd(4);
        l1.insertAtEnd(6);
        l1.insertAtEnd(7);
        l1.insertAtEnd(8);

        l1.display();

        LeetCode21 l2 = new LeetCode21();
        l2.insertAtEnd(1);
        l2.insertAtEnd(3);
        l2.insertAtEnd(4);
        l2.insertAtEnd(5);
        l2.insertAtEnd(6);

        l2.display();

        l1.mergeTwoLists1(l1.getHead(), l2.getHead());
        l1.display();
    }
}
