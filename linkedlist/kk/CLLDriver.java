package linkedlist.kk;

public class CLLDriver {

    public static void main(String[] args) {

        CircularLinkedList l1 = new CircularLinkedList();

        l1.insert(1);
        l1.insert(4);
        l1.insert(3);
        l1.insert(6);
        l1.insert(7);

        l1.display();

        System.out.println("-------------------------------");

        l1.delete(4);
        l1.display();
    }
}
