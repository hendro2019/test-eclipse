package linked.list;

import java.util.EmptyStackException;

public class Stack<E> {
	
	private Node<E> top;
	private int count;
	
	public Stack() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public E peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.getData();
	}
	
	public E pop() {
		if (top == null)
			throw new EmptyStackException();
		
		E answer = top.getData();
		top = top.getLink();
		count--;
		return answer;
	}
	
	public void push(E item) {
		top = new Node<E>(item, top);
		count++;
	}
	
	public int size() {
		return count;
	}
}
