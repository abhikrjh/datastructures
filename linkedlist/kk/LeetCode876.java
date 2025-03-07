package linkedlist.kk;

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
*/

public class LeetCode876 {

    private Node head;
    private Node tail;
    private int size;

    public LeetCode876() {
        this.size = 0;
    }

    public class Node {

        private int value;
        private Node next;

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

    private Node middle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        LeetCode876 l1 = new LeetCode876();
        l1.insertAtEnd(1);
        l1.insertAtEnd(2);
        l1.insertAtEnd(4);
        l1.insertAtEnd(6);
        l1.insertAtEnd(7);
        l1.insertAtEnd(8);

        l1.display();

        Node middle = l1.middle(l1.getHead());

        System.out.println(middle.value);
    }
}
