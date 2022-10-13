package stack;// based on LIFO -  last in first out

public class IntStack {

	private int[] stack;
	private int top;
	private int size;

	public IntStack() {
		top = -1;
		size = 3;
		stack = new int[3];
	}

	public IntStack(int size) {
		top = -1;
		this.size = size;
		stack = new int[size];
	}

	public boolean push(int item) {
		if (!isFull()) {
			stack[++top] = item;
			return true;
		}
		return false;
	}

	public int pop() {
		if (!isEmpty()) {
			return stack[top--];
		}
		return -1;
	}

	public boolean isFull() {
		return (top == stack.length - 1);
	}

	public boolean isEmpty() {
		return (top == -1);
	}
    
	
	// main method is to test our custom stack 
	
	public static void main(String[] args) {
		IntStack stack = new IntStack();
		
		stack.push(7);
		stack.push(8);
		stack.push(12);
		stack.push(15); // this will not added because size of stack is 3
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println();
	}
	
}
