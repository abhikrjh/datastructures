package linkedlist;

import java.util.HashSet;

public class CustomLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    public void insertAtStart(int data) {
        // 4->3->2->1->null   here elemeent which we add will be the head
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void insertAtEnd(int data) {
        // 1->2->3->4-null
        if (head == null) {
            Node node = new Node(data);
            head = node;
            return;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        Node newNode = new Node(data);
        node.next = newNode;
        newNode.next = null;
    }

    // Find the middle element of a singly linked list in one pass?
    // Read more: https://www.java67.com/2018/06/data-structure-and-algorithm-interview-questions-programmers.html#ixzz7hnXRdqTz
    // slow pointer will increase by one unit and fast pointer will increase by 2 unit
    public Node middleNode() {
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null) {
            if (null != fastPointer && null != fastPointer.next && null != fastPointer.next.next) {
                fastPointer = fastPointer.next.next;
            } else {
                return slowPointer;
            }
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    // Find the nth node from the end in a singly linked list?
    //    Read more: https://www.java67.com/2018/06/data-structure-and-algorithm-interview-questions-programmers.html#ixzz7hnYwKJoK
    // 1->2->3->4->5->null
    // 1st node from end is n th node from start
    // 2nd node from end is n-1 th node from start
    // 3rd node from end is n-2 th node from start
    public Node nthNodeFromEnd(int n) {
        int l = length();
        // we need l-(n-1) th node from start
        int currIndex = 0;
        Node node = head;
        while (node != null) {
            currIndex++;
            if (currIndex == l - (n - 1)) {
                break;
            }
            node = node.next;
        }
        return node;
    }

    //    Check if a given linked list contains a cycle? How to find the starting node of the cycle?
//    Read more: https://www.java67.com/2018/06/data-structure-and-algorithm-interview-questions-programmers.html#ixzz7ho2Uzkxh
    public boolean hasContainsACycle() {
        Node node = head;
        HashSet<Node> s = new HashSet<>();
        while (node != null) {
            if (s.contains(node)) {
                return true;
            }
            s.add(node);
            node = node.next;
        }
      return false;
    }

    public int length() {

        int length = 0;
        Node node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        CustomLinkedList c = new CustomLinkedList();
        c.insertAtStart(1);
        c.insertAtStart(2);
        c.insertAtStart(3);
        c.insertAtStart(4);
        c.insertAtStart(5);
        c.insertAtStart(6);
        c.insertAtStart(7);
        c.printList();
//        c.insertAtEnd(1);
//        c.insertAtEnd(2);
//        c.insertAtEnd(3);
//        c.insertAtEnd(4);
//        c.printList();
        System.out.println("############################");
        int n = 2;
        Node nthNodeFromEnd = c.nthNodeFromEnd(4);
        System.out.println(n + "th node from end is : " + nthNodeFromEnd.data);

        System.out.println("############################");

        Node middleNode = c.middleNode();
        System.out.println("middle element is : " + middleNode.data);

    }
}
