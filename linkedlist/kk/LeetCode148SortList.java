package linkedlist.kk;


/*

Given the head of a linked list, return the list after sorting it in ascending order.

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Input: head = []
Output: []
*/

import java.util.Arrays;

public class LeetCode148SortList {

    private Node head;
    private Node tail;
    private int size;

    public LeetCode148SortList() {
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

    public int length() {
        Node temp = head;
        int length = 0;
        while (temp != null) {

            temp = temp.next;
            length++;
        }
        return length;
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

    private Node getMid(Node head) {

        Node slow = head;
        Node fast = head;
        Node prev = null; // Keep track of node before mid

        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null; // Break the list into two halves
        }

        return slow;
    }

    private Node sortList(Node head) {

        if (head == null || head.next == null) {
            return head; //  Base case: 0 or 1 node, already sorted
        }

        // Step 1: Split the list into two halves

        Node mid = getMid(head); // find middle node and break list into two half

        Node rightHead = mid;

        // Step 2: Recursively divide each half

        Node left = sortList(head);
        Node right = sortList(rightHead);

        return mergeTwoList(left, right);
    }

    // Function to merge two sorted linked lists
    private Node mergeTwoList(Node left, Node right) {

        Node dummyHead = new Node();
        Node tail = dummyHead;

        while (left != null && right != null) {

            if (left.value < right.value) {

                tail.next = left;
                left = left.next;
            } else {

                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }

        // Append remaining nodes (if any)
        if (left != null)
            tail.next = left;

        if (right != null)
            tail.next = right ;

        return dummyHead.next; // we are returning head
    }

    public static void main(String[] args) {

        LeetCode148SortList l1 = new LeetCode148SortList();

        l1.insertAtEnd(6);
        l1.insertAtEnd(2);
        l1.insertAtEnd(7);
        l1.insertAtEnd(9);
        l1.insertAtEnd(1);
        l1.insertAtEnd(4);

        l1.display();

        l1.head = l1.sortList(l1.getHead());

        l1.display();
    }

}


