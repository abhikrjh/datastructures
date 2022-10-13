package queue;

class Person1{
	
	String name;
	String roll;
	
	public Person1() {
		
	}
	
	public Person1(String name, String roll) {
		this.name =  name;
		this.roll = roll;
	}
	
	public String toString() {
		return "Name : "+ this.name+" roll : "+ this.roll;
	}
	
}
public class ObjectQueue {
	private Person1 [] queue;
	private int front;
	private int rear;
	private int size;
	private int total;
	
	public ObjectQueue() {
		front = 0;
		rear = 0;
		size = 3;
		total= 0;
		queue = new Person1[size];
	}
	
	public ObjectQueue(int size) {
		front = 0;
		rear = 0;
		this.size = size;
		total= 0;
		queue = new Person1[this.size];
	}
	
	
	public boolean enQueue(Person1 item) {
		if(!isFull()) {
			queue[rear] = item;
			//rear++;  
			rear =(rear+1)%size;
			total++;
			return true;
		}
		return false;
	}
	
	public Person1 dequeue() {
		Person1 data = new Person1() ;
		if(!isEmpty()) {
			data = queue[front];
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
		ObjectQueue q = new ObjectQueue();
		
		q.enQueue(new Person1("A", "27"));
		q.enQueue(new Person1("B", "28"));
		q.enQueue(new Person1("C", "29"));
		
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		q.enQueue(new Person1("D", "30"));
		q.enQueue(new Person1("E", "31"));
		q.enQueue(new Person1("F", "32"));
		q.enQueue(new Person1("G", "33"));
		
		System.out.println(q.dequeue());
		
		
		
	}
}
