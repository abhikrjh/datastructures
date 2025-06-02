package linkedlist.practice;

public class LnkedList {

    Node head;
    Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    LnkedList(int value) {
        Node newNode = new Node(value);

        head = newNode;
        tail = head;

        tail.next = null;
    }

    private Node createNode(int value) {
        return new Node(value);
    }

    private void insertAtStart(int value) {

        Node newNode = new Node(value);

        newNode.next = head;

        head = newNode;
    }

    private void insertAtEnd(int value) {

        Node newNode = new Node(value);

        tail.next = newNode;

        tail = newNode;

        tail.next = null;
    }

    private void deleteNode1(Node node) {

        Node curr = head;
        Node prv = head;

        while (curr.value != node.value) {

            prv = curr;
            curr = curr.next;
        }

        curr = curr.next;
        prv.next = curr;

        if (node.value == tail.value) {
            tail = prv;
        }
    }

    private void deleteNode(Node node) {

        Node curr = head;
        Node prv = head;

        if (head.value == node.value) {
            curr = curr.next;
            prv = curr;
            head = curr;
            return;
        }
        while (curr.value != node.value) {
            prv = curr;
            curr = curr.next;
        }
        curr = curr.next;
        prv.next = curr;
    }

    private void print() {
        Node temp = head;

        while (temp.next != null) {

            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print(temp.value + " -> null");
        System.out.println();
        System.out.print("head :" + head.value + " tail " + tail.value);
        System.out.println("-------------------------------");
    }


    public static void main(String[] args) {

        LnkedList list = new LnkedList(1);
        /*
        list.insertAtStart(2);
        list.insertAtStart(3);
        list.insertAtStart(4);
        list.insertAtStart(5);

        list.print();
        */

        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        list.print();

        Node nodeToBeDeleted = list.createNode(1);
        list.deleteNode(nodeToBeDeleted);


        list.print();
    }
}
