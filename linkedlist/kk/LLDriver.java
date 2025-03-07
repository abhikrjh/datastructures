package linkedlist.kk;

public class LLDriver {

    public static void main(String[] args) {

        CustomLinkedList l1 = new CustomLinkedList();

        l1.insertAtFirst(1);
        l1.insertAtFirst(4);
        l1.insertAtFirst(3);
        l1.insertAtFirst(6);

        l1.display();
        System.out.println("size = " + l1.size());

        System.out.println("-------------------------------");

        l1.insertAtEnd(8);
        l1.insertAtEnd(7);

        l1.display();
        System.out.println("size = " + l1.size());

        System.out.println("-------------------------------");

        l1.insertAtIndex(0, 5);
        l1.insertAtIndex(6, 26);
        l1.insertAtIndex(3, 9);
        l1.insertAtIndex(6, 16);

        l1.display();
        System.out.println("size = " + l1.size());

        System.out.println("-------------------------------");

        int deletedVal = l1.deleteFirst();

        l1.display();

        System.out.println("Deleted Value = " + deletedVal);
        System.out.println("size = " + l1.size());

        System.out.println("-------------------------------");

        deletedVal = l1.deleteLast();

        l1.display();

        System.out.println("Deleted Value = " + deletedVal);
        System.out.println("size = " + l1.size());

        System.out.println("-------------------------------");

        deletedVal = l1.deleteAtIndex(8);

        l1.display();

        System.out.println("Deleted Value = " + deletedVal);
        System.out.println("size = " + l1.size());

        System.out.println("-------------------------------");

        l1.insertAtIndexUsingRecursion(5, 1);

        l1.display();

    }
}
