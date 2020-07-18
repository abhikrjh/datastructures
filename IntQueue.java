
public class IntQueue {
    
	private int [] queue;
	private int front;
	private int rear;
	private int size;
	private int total;
	
	public IntQueue() {
		front = 0;
		rear = 0;
		size = 3;
		total= 0;
		queue = new int[size];
	}
	
	public IntQueue(int size) {
		front = 0;
		rear = 0;
		this.size = size;
		total= 0;
		queue = new int[this.size];
	}
	
	
	public boolean enQueue(int item) {
		if(!isFull()) {
			queue[rear++] = item;
			total++;
		}
		return false;
	}
	
	public int dequeue() {
		int data = 0;
		if(!isEmpty()) {
			data = queue[front++];
			total--;
		}
		return data;
	}
	
	public boolean isFull() {
		return (size == total);
	}
	
	public boolean isEmpty() {
		return (total == 0);
	}
	
	// main method is to test our custom stack 
	
		public static void main(String[] args) {
			IntQueue queue = new IntQueue(4);
			
			queue.enQueue(7);
			queue.enQueue(17);
			queue.enQueue(27);
			queue.enQueue(37);
			
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			
			
		}
	
}
