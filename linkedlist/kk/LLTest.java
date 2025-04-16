package linkedlist.kk;

public class LLTest {

    Node head;
    Node tail;

    class Node {

        int value;
        Node next;

        Node(int val) {
            this.value = val;
        }
    }

    LLTest(int val) {

        head = new Node(val);
        tail = head;
        tail.next = null;
    }

    private void print() {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println();
    }

    private void insertAtStart(int val) {

        Node newNode = new Node(val);

        newNode.next = head;

        head = newNode;
    }

    private void insertAtEnd(int val) {

        Node newNode = new Node(val);

        tail.next = newNode;
        newNode.next = null;

        tail = newNode;
    }

    private void insertInCircular(int val) {

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

    private boolean isCircular(Node head) {

        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    private Node reverseLinkedList() {

        Node prvNode = null;
        Node curNode = head;

        while (curNode != null) {


            Node nextNode = curNode.next; // created just so that link to next node will not break;

            curNode.next = prvNode;

            prvNode = curNode;

            curNode = nextNode;

        }

        head = prvNode;

        return head;
    }

    public static void main(String[] args) {

        LLTest llTest = new LLTest(1);

       /* llTest.insertAtStart(2);
        llTest.insertAtStart(3);
        llTest.insertAtStart(4);
        llTest.insertAtStart(5);
        llTest.insertAtStart(6);*/

        llTest.insertAtEnd(2);
        llTest.insertAtEnd(3);
        llTest.insertAtEnd(4);
        llTest.insertAtEnd(5);
        llTest.insertAtEnd(6);

        llTest.print();

        llTest.reverseLinkedList();

        llTest.print();


//        llTest.insertInCircular(1);
//        llTest.insertInCircular(2);
//        llTest.insertInCircular(3);
//        llTest.insertInCircular(4);
//        llTest.insertInCircular(5);
//        llTest.insertInCircular(6);
//
//        System.out.println(llTest.isCircular(llTest.head));
    }

}
