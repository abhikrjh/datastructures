package linkedlist;


public class LinkedListImpl {

    public static void main(String[] args) {

        LinkedList li = new LinkedList();

        li.addAtFront(70);
        li.addAtFront(50);
        li.addAtFront(30);
        li.addAtFront(10);

        li.printList();

        System.out.println("----------------------");

        li.insertAfter(li.head.next.next, 60);

        li.printList();

        System.out.println("-----------------------");

        li.addAtEnd(80);

        li.addAtEnd(100);

        li.printList();

        System.out.println("--------------------");

        li.deleteANode(100);

        li.printList();

    }

}
