package linkedlist.kk;

public class CustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
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

    public Node getHead(){
        return head;
    }

    public void insertAtFirst(int val) {

        Node newNode = new Node(val);

        newNode.next = head;

        head = newNode;

        if (tail == null) {
            tail = head;
        }

        increaseSize();
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

    public void insertAtIndex(int index, int val) {

        if (index == 0) {

            insertAtFirst(val);

            return;
        }

        if (index == size() - 1) {

            insertAtEnd(val);

            return;
        }

        // now we will start checking from index 1,
        // because index 0 we have already checked at first if condition

        Node prvNode = head;
        Node currNode = head.next;
        int currentIndex = 1;

        while (currNode != null) {

            if (currentIndex == index) {

                Node newNode = new Node(val);

                prvNode.next = newNode;
                newNode.next = currNode;

                increaseSize();

                return;
            }

            prvNode = currNode;
            currNode = currNode.next;

            currentIndex += 1;
        }
    }

    public int deleteFirst() {

        int valueToBeDeleted = head.value;

        head = head.next;

        if (head == null) {
            tail = null;
        }

        decreaseSize();

        return valueToBeDeleted;
    }

    public int deleteLast() {

        if (tail == null) {
            return -1;
        }


        Node prvNode = head;
        Node currNode = head;

        while (currNode.next != null) {

            prvNode = currNode;
            currNode = currNode.next;
        }

        int valueToBeDeleted = currNode.value; // this is actually tail value

        prvNode.next = null;
        tail = prvNode;

        decreaseSize();

        return valueToBeDeleted;
    }

    public int deleteAtIndex(int index) {

        Node prevNode = head;
        Node currentNode = head;
        int currentIndex = 0;

        while (currentNode != null) {

            if (currentIndex == index) {
                break;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;

            currentIndex += 1;
        }

        if (currentNode != null) {

            prevNode.next = currentNode.next;
            decreaseSize();
        }

        return currentNode != null ? currentNode.value : -1;
    }

    public Node getNodeAtIndex(int index) {

        Node currNode = head;

        if (index == 0) {

            return currNode;
        }

        if (index == size()) {

            return null;
        }

        for (int i = 0; i < index; i++) {  // we have looped till previous index so that it will give current index node

            currNode = currNode.next;
        }

        return currNode;
    }

    public void insertAtIndexUsingRecursion(int val, int index) {

        head = insertAtUsingRec(val, index, head);
    }

    public Node insertAtUsingRec(int val, int index, Node node) {

        // base condition
        // when we reach at 0 that means we need to add the new node at that index
        // because we are decreasing it from given index to add

        if (index == 0) {

            Node newNode = new Node(val);

            newNode.next = node;

            size++;

            return newNode;
        }

        index = index - 1;
        node.next = insertAtUsingRec(val, index , node.next);

        return node;
    }
}
