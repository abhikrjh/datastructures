package stack;

class Person{
	
	String name;
	String roll;
	
	public Person(String name, String roll) {
		this.name =  name;
		this.roll = roll;
	}
	
	public String toString() {
		return "Name : "+ this.name+" roll : "+ this.roll;
	}
	
}

public class ObjectStack {
	private Person[] stack;
	private int top;
	private int size;

	public ObjectStack() {
		top = -1;
		size = 3;
		stack = new Person[3];
	}

	public ObjectStack(int size) {
		top = -1;
		this.size = size;
		stack = new Person[size];
	}

	public boolean push(Person item) {
		if (!isFull()) {
			stack[++top] = item;
			return true;
		}
		return false;
	}

	public Person pop() {
		if (!isEmpty()) {
			return stack[top--];
		}
		return null;
	}

	public boolean isFull() {
		return (top == stack.length - 1);
	}

	public boolean isEmpty() {
		return (top == -1);
	}
	// main method is to test our custom stack 
	
		public static void main(String[] args) {
			
			ObjectStack stack = new ObjectStack();
			
			stack.push(new Person("a", "7"));
			stack.push(new Person("B", "17"));
			
			System.out.println(stack.pop().toString());
			System.out.println(stack.pop().toString());
			
			System.out.println();
		}
	
}
