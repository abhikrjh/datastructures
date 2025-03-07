package linkedlist.kk;

public class ReverseLL {

    private Node head;
    private Node tail;
    private int size;

    public ReverseLL() {
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

    public void setHead(Node newHead){
        head =  newHead;
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

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> END
    private void reverseLLUsingRecursion(Node node) {

        if (node == tail) {
            head = tail;
            return;
        }
        reverseLLUsingRecursion(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> END
    // 1 <- 2

    // 1 <- 2 <- 3 <- 4 <- 5 <- 6
    private Node reverseLL(Node head) {

        Node prvNode = null;
        Node curNode = head;

        while (curNode != null) {

            Node nextNode = curNode.next; // created this node so that reference to next node will not break

            curNode.next = prvNode;
            prvNode = curNode;

            curNode = nextNode;
        }

        head = prvNode;

        return head;
    }


    public static void main(String[] args) {

        ReverseLL l1 = new ReverseLL();

        l1.insertAtEnd(1);
        l1.insertAtEnd(2);
        l1.insertAtEnd(3);
        l1.insertAtEnd(4);
        l1.insertAtEnd(5);
        l1.insertAtEnd(6);

        l1.display();

//        l1.reverseLLUsingRecursion(l1.getHead());
//
//        l1.display();

        Node head = l1.getHead();

        l1.setHead(l1.reverseLL(head));

        l1.display();
    }
}
