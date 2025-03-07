package linkedlist.kk;

public class CustomDoublyLL {

    private Node head;
    private Node tail;
    private int size;

    void CustomLinkedList() {
        this.size = 0;
    }

    class Node {

        int value;
        Node next;
        Node prev;

        Node(int val) {
            this.value = val;
        }
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

    void display() {
        Node curNode = head;

        while (curNode != null) {

            System.out.print(curNode.value + " -> ");
            curNode = curNode.next;
        }

        System.out.print("END");
        System.out.println();
    }

    void displayInReverse() {

        System.out.println("Print in reverse");

        Node curNode = head;
        Node lastNode = head;

        while (curNode != null) {

            lastNode = curNode;
            curNode = curNode.next;
        }

        // from last node moving in backward direction

        Node prvNode = lastNode;

        while (prvNode != null) {
            System.out.print(prvNode.value + " -> ");
            prvNode = prvNode.prev;
        }
        System.out.print("START");
    }

    public void insertAtFirst(int val) {

        Node newNode = new Node(val);

        if (head == null && tail == null) {

            head = newNode;
            tail = newNode;

            increaseSize();

            return;
        }

        newNode.next = head;
        newNode.prev = null;

        head.prev = newNode;
        head = newNode;

        increaseSize();
    }

    public void insertAtLast(int val) {

        Node newNode = new Node(val);

        if (head == null && tail == null) {

            head = newNode;
            tail = newNode;

            increaseSize();

            return;
        }

        tail.next = newNode;

        newNode.prev = tail;
        newNode.next = null;

        tail = newNode;

        increaseSize();
    }

    public void insertAtIndex(int val, int index) {

        Node newNode = new Node(val);

        if (index == 0) {

            insertAtFirst(val);
            return;
        }

        if (index == size() - 1) {

            insertAtLast(val);
            return;
        }

        // now we will start checking from index 1,
        // because index 0 we have already checked at first if condition

        Node curNode = head;
        Node nextNode = head.next;

        int nxtIndex = 1;

        while (curNode != null) {

            if (index == nxtIndex) {

                curNode.next = newNode;

                newNode.prev = curNode;
                newNode.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = newNode;
                }

                increaseSize();
                return;
            }

            nxtIndex += 1;
            curNode = curNode.next;

            nextNode = curNode.next; // because we have already moved curNode to curNode.next
        }
    }


    public Node findNode(int val) {
        Node temp = head;

        while (temp != null) {

            if (temp.value == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addAfterNode(int givenNodeVal, int val) {

        Node newNode = new Node(val);

        Node givenNode = findNode(givenNodeVal);
        Node nextNode = null;

        if (null != givenNode) {
            nextNode = givenNode.next;
        }

        givenNode.next = newNode;
        newNode.prev = givenNode;

        newNode.next = nextNode;
        if (null != nextNode) {
            nextNode.prev = newNode;
        }
    }
}
