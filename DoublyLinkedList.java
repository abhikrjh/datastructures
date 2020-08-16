
public class DoublyLinkedList {

	class Node {
		int value;
		Node next;
		Node prev;
	}

	static Node head;

	DoublyLinkedList(int data) {
		Node node = new Node();
		node.value = data;
		head = node;
		node.prev = null;
		node.next = null;
	}

	private void sortedInsert(Node head, int data) {

		Node currentNode = head;
		Node newNode = new Node();
		newNode.value = data;
		Node tempNode = head;
		int count = 0;
		while (currentNode != null) {
			if (count == 0 && currentNode.value > data) {
				currentNode.prev = newNode;
				newNode.next = currentNode;
				head = newNode;
				break;
			} else if (count > 0 && currentNode.value > data) {
				newNode.next = currentNode;
				currentNode.prev = newNode;
				newNode.prev = tempNode;
				tempNode.next = newNode;
				break;
			}
			if (currentNode.next != null) {
				tempNode = currentNode;
				currentNode = currentNode.next;
				tempNode.next = currentNode;
				currentNode.prev = tempNode;
			} else {
				if (currentNode.value < data) {
					currentNode.next = newNode;
					newNode.prev = currentNode;
					newNode.next = null;
					currentNode = newNode;
					break;
				}else {
					newNode.next = currentNode;
					currentNode.prev = newNode;
					newNode.prev = tempNode;
					tempNode.next = newNode;
					break;
				}
			}

			count = count + 1;
		}

	}

	public void insertAtBegning(int data) {
		Node newNode = new Node();
		newNode.value = data;
		newNode.prev = null;
		newNode.next = head;
		head = newNode;
	}

	private void printList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.value + " ");
			currentNode = currentNode.next;
		}

	}

	public static void main(String[] args) {

		DoublyLinkedList dl = new DoublyLinkedList(3);
		dl.insertAtBegning(2);
		dl.insertAtBegning(1);
		// dl.insertAtBegning(1);

		dl.sortedInsert(head, 4);

		dl.printList();

	}

}
