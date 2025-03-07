package linkedlist.kk;

public class DLLDriver {

    public static void main(String[] args) {

        CustomDoublyLL l1 = new CustomDoublyLL();

        l1.insertAtFirst(1);
        l1.insertAtFirst(4);
        l1.insertAtFirst(3);
        l1.insertAtFirst(6);
        l1.insertAtFirst(7);

        l1.display();
        l1.displayInReverse();

        System.out.println();
        System.out.println("size = " + l1.size());

        System.out.println("-------------------------------");

        l1.insertAtLast(8);
        l1.insertAtLast(9);

        l1.display();

        System.out.println("-------------------------------");

        l1.insertAtIndex(5, 7);

        l1.display();

        System.out.println("-------------------------------");

        l1.addAfterNode(5, 2);

        l1.display();
    }
}
