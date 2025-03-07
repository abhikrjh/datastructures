package linkedlist.kk;

/*
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Input: head = [5], left = 1, right = 1
Output: [5]
*/

public class LeetCode92 {

    private Node head;
    private Node tail;
    private int size;

    public LeetCode92() {
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

    public void setHead(Node newHead) {
        head = newHead;
    }

    private void insertAtEnd(int val) {

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

//    Input: head = [1,2,3,4,5], left = 2, right = 4
//    Output: [1,4,3,2,5]

    public Node reverseBetween(Node head, int left, int right) {

        if (head == null || head.next == null || left == right) {

            return head;
        }

        Node dummy = new Node();
        dummy.next = head;

        Node prv = dummy;

        for (int i = 1; i < left; i++) {

            prv = prv.next;
        }

        Node start = prv.next;
        Node then = start.next;

        /*
        First iteration

        1 -> 2 -> 4 -> 5        start.next = then.next

        3 -> 2 -> 4 -> 5        then.next = prv.next

        1 -> 3 -> 2 -> 4 -> 5   prv.next = then

        then = start.next  // moved then to 4

        Second iteration

        1 -> 3 -> 2 -> 5       start.next = then.next  // 4 breaks out

        4 -> 3 -> 2 -> 5       then.next = prv.next // 4 points to 3

        1 -> 4 -> 3 -> 2 -> 5  prv.next = then // 1 points to 4

        1 -> 4 -> 3 -> 2 -> 5  then = start.next // moved then to 5
        */

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prv.next;
            prv.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        LeetCode92 l1 = new LeetCode92();

//        l1.insertAtEnd(1);
//        l1.insertAtEnd(2);
//        l1.insertAtEnd(3);
//        l1.insertAtEnd(4);
//        l1.insertAtEnd(5);
//        l1.insertAtEnd(6);
//
//        l1.display();
//
//        l1.reverseBetween(l1.getHead(), 2, 5);
//
//        l1.display();

        l1.insertAtEnd(3);
        l1.insertAtEnd(5);


        l1.display();

        l1.setHead(l1.reverseBetween(l1.getHead(), 1, 2));

        l1.display();
    }
}
