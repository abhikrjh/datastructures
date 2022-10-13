package LinkedList;/*
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

		Node previousNode = null;
		Node currentNode = head;
		Node nextNode = null;

		while (currentNode.next != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		head = currentNode;
		head.next = previousNode;

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
		while (n.next != null) {
			System.out.println(n.value);
			n = n.next;
		}
		System.out.println(n.value);
	}

	// main method is to test our LinkedList

	public static void main(String[] args) {

		/*
		 * LinkedList.IntLinkedList li = new LinkedList.IntLinkedList(20);
		 * 
		 * li.insertAtStart(13); li.insertAtStart(5); li.insertAtStart(77);
		 * li.insertAtStart(28); li.insertAtStart(7); li.printList();
		 */
		// o/p - 8, 7, 5, 3

		/*
		 * System.out.println("#########################");
		 * 
		 * 
		 * LinkedList.IntLinkedList li1 = new LinkedList.IntLinkedList(1);
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
		IntLinkedList li = new IntLinkedList(1);

		li.insertAtEnd(2);
		li.insertAtEnd(3);
		li.insertAtEnd(4);
		li.insertAtEnd(5);
		li.insertAtEnd(6);
		li.insertAtEnd(7);

		li.printList();

		System.out.println("###### Reversed LinkedList ########");
		li.reversedLinkedList();
		li.printList();
	}

}
