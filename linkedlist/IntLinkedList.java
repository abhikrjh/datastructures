package linkedlist;/*
Linked list is a linear data structure where the elements are not stored in contiguous locations and 
every element is a separate object with a data part and address part. 
The elements are linked using pointers and addresses. Each element is known as a node. 
Due to the dynamicity and ease of insertions and deletions, they are preferred over the arrays. 
It also has few disadvantages like the nodes cannot be accessed directly 
instead we need to start from the head and follow through the link to reach to a node we wish to access.
*/

public class IntLinkedList {

    class Node {
        int value;
        Node next;
    }

    Node head;

    public IntLinkedList(int item) {
        Node n = new Node();
        n.value = item;
        head = n;
    }

    public void insertAtStart(int item) {
        Node node = new Node();

        node.value = item;
        node.next = head;
        head = node;
    }

    public void insertAtEnd(int item) {

        // go to last node

        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        // now add new node here
        Node newNode = new Node();

        newNode.value = item;
        newNode.next = null;
        currentNode.next = newNode;

    }

    public void deleteItem(int item) {

        Node current = head;
        Node previous = head;

        if (item == head.value) {
            current = head.next;
            head = current;
        } else {

            while (current.next != null) {

                if (current.value == item) {
                    break;
                } else {
                    previous = current;
                    current = current.next;
                }

            }
            previous.next = current.next;
            current = current.next;

        }

    }

    // used bubble sort algorithm to sort this
    public void sortList() {
        Node first = head;
        int temp = 0;
        while (first.next != null) {
            Node second = first.next;
            while (second != null) {
                if (first.value < second.value) {
                    temp = second.value;
                    second.value = first.value;
                    first.value = temp;
                }
                second = second.next;
            }
            first = first.next;
        }

    }

    // reverse LinkedList

    public void reversedLinkedList() {
        // 5 -> 4 -> 3 -> 2 -> 1 -> null
        // null <- 5 <- 4 <- 3 <- 2 <- 1
        if (head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            // link nodes
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update nodes
            prevNode = currNode;
            currNode = nextNode;

        }
        head.next = null; // here still head was 5 i.e, head.next will be null
        head = prevNode;
    }

    // find nth node from end of linked list

    public boolean isCircular(){
        Node n = head;
        while(n.next != null){
            if(n.next == head){
                return true;
            }
            n = n.next;
        }

        return false;
    }

    public Node findNthNodeFromEnd(int n) {
        // 5 -> 4 -> 3 -> 2 -> 1 -> null
        // (size - n) from start
        Node node = head;
        int size = size();
        int index = 0;
        while (node != null) {
            if (index == size - n) {
                return node;
            }
            node = node.next;
            index++;
        }

        return null;
    }

    // delete nth node from end of linked list

    public void deleteNthNodeFromEnd(int n) {
        // 5 -> 4 -> 3 -> 2 -> 1 -> null
        // (size - n) from start
        Node node = head;
        int size = size();
        int index = 0;
        Node prevNodeOfNthNode = null;
        Node nthNode = null;
        while (node != null) {
            if (index == size - n - 1) {
                prevNodeOfNthNode = node;
            }
            if (index == size - n && prevNodeOfNthNode != null) {
                nthNode = node;
                // linking previous node to next of nthNode to delete nthNode
                prevNodeOfNthNode.next = nthNode.next;
            }
            node = node.next;
            index++;
        }
    }


    public int size() {
        int size = 0;
        Node n = head;
        while (n.next != null) {
            n = n.next;
            size++;
        }
        size = size + 1;
        return size;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.value + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }

    // main method is to test our LinkedList

    public static void main(String[] args) {

        IntLinkedList li = new IntLinkedList(20);

        li.insertAtStart(13);
        li.insertAtStart(5);
        li.insertAtStart(77);
        li.insertAtStart(28);
        li.insertAtStart(7);
        li.printList();
        // o/p - 8, 7, 5, 3

        /*
         * System.out.println("#########################");
         *
         *
         * linkedlist.IntLinkedList li1 = new linkedlist.IntLinkedList(1);
         *
         * li1.insertAtEnd(3); li1.insertAtEnd(5); li1.insertAtEnd(7);
         * li1.insertAtEnd(8);
         *
         * li1.printList();
         */

        // o/p - 3, 5, 7, 8

        /*
         * System.out.println("#########################");
         *
         * li.deleteItem(8); li.printList();
         * System.out.println("#########################"); li.insertAtEnd(9);
         *
         * li.printList();
         */

        /*
         *
         * System.out.println("######## After Sorting ############");
         *
         * li.sortList(); li.printList();
         *
         * System.out.println("#########################");
         * System.out.println("size of list : " + li.size());
         *
         */
        System.out.println("#########################");
		/*IntLinkedList li = new IntLinkedList(1);

		li.insertAtEnd(2);
		li.insertAtEnd(3);
		li.insertAtEnd(4);
		li.insertAtEnd(5);
		li.insertAtEnd(6);
		li.insertAtEnd(7);

		li.printList();

		System.out.println("###### Reversed LinkedList ########");
		li.reversedLinkedList();
		li.printList();*/

        System.out.println("########### Nth Node from end #################");

        li.printList();

        Node nthNode = li.findNthNodeFromEnd(3);
        System.out.println(nthNode.value);

        System.out.println("############## Delete nth node from end #################");
        li.deleteNthNodeFromEnd(3);
        li.printList();

        System.out.println("############## checking circluar linked list  #################");
        System.out.println("is circular "+li.isCircular());

        System.out.println("###### Reversed LinkedList ########");
        li.reversedLinkedList();
        li.printList();
    }

}
