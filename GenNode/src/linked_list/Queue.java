package linked_list;

import java.util.NoSuchElementException;

public class Queue<E> {
	
	private int manyNodes;
	private Node<E> front;
	private Node<E> rear;
	/**
	 * Initialize empty Queue
	 */
	public Queue() {
		
		front = null;
		rear = null;
	}
	
	public void add(E item) {
		if (isEmpty()) {
			front = new Node<E>(item, null);
			rear = front;
		}
		else {
			rear.addNodeAfter(item);
			rear = rear.getLink();
		}
		manyNodes++;
	}
	
	public boolean isEmpty() {
		return manyNodes == 0;
	}
	
	public E remove() {
		E answer;
		
		if (manyNodes == 0)
			throw new NoSuchElementException("Queue underflow");
		
		answer = front.getData();
		front = front.getLink();
		manyNodes--;
		
		if (manyNodes == 0)
			rear = null;
		
		return answer;
	}
	
	public int size() {
		return manyNodes;
	}
	
	
	
}
