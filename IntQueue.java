
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
			queue[rear] = item;
			//rear++;  
			rear =(rear+1)%size;
			total++;
			return true;
		}
		return false;
	}
	
	public int dequeue() {
		int data = 0;
		if(!isEmpty()) {
			data = queue[front];
			queue[front] =0;
			//front++;
			front = (front+1)%size;
			total--;
		}
		return data;
	}
	
	public boolean isFull() {
		if(size == total) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		return (total == 0);
	}
	
	// main method is to test our custom Queue 
	
		public static void main(String[] args) {
			IntQueue q = new IntQueue(4);
			
			q.enQueue(7);
			q.enQueue(17);
			q.enQueue(27);
			q.enQueue(37);
			
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			
			
			//System.out.println(Arrays.toString(q));
			
			q.enQueue(47);
			System.out.println(q.dequeue());
			
		}
	
}
