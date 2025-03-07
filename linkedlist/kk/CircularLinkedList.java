package linkedlist.kk;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    class Node {

        int value;
        Node next;

        Node(int val) {
            this.value = val;
        }
    }

    CircularLinkedList() {
        head = null;
        tail = null;
    }

    public void display() {

        Node temp = head;

        if (temp != null) {
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("HEAD");
        }
    }

    public void insert(int val) {

        Node newNode = new Node(val);

        if (head == null) {

            head = newNode;
            tail = newNode;

            return;
        }


        tail.next = newNode;
        newNode.next = head;

        tail = newNode;
    }

    public void delete(int val) {

        if (head == null) {
            return;
        }

        if (head.value == val) {

            head = head.next;
            tail.next = head;

            return;
        }

        Node node = head;

        do {
            Node n = node.next;

            if (n.value == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

}
