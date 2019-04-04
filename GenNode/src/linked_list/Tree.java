package linked_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;




public class Tree<E> {
	protected enum PathDirection {
		LEFT, RIGHT;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void setAsChild(BTNode currNode,  BTNode newNode) {
			if (this == LEFT) {
				currNode.setLeft(newNode);
			} else {
				currNode.setRight(newNode);
			}
		}

		@SuppressWarnings("rawtypes")
		public BTNode getChildOf(BTNode currNode) {
			return (this == LEFT) ? currNode.getLeft() : currNode.getRight();
		}
	}

	private BTNode<E> root;
	private int numNodes;

	public void add(E item) {
		BTNode<E> newNode = new BTNode<E>(item, null, null);

		if (numNodes == 0) {
			root = newNode;
		} else {
			add(root, newNode, getPath(numNodes));
		}
		numNodes++;
	}
	
	@SuppressWarnings("unchecked")
	private void add(BTNode<E> currNode, BTNode<E> newNode, Stack<PathDirection> pathStack) {
		PathDirection direction = pathStack.pop();
		if (pathStack.isEmpty()) {
			direction.setAsChild(currNode, newNode);
		} else {
			add(direction.getChildOf(currNode), newNode, pathStack);
		}
	}
	
	public void addAt(E item, int index) {
		BTNode<E> newNode = new BTNode<E>(item, null, null);
		if (index == 0 && numNodes == 0) {
			root = new BTNode<E>(item, null, null);
			numNodes++;
		}
		else if (index == 0) {
			root = new BTNode<E>(item, root.getLeft(), root.getRight());
		}
		else {
			if (numNodes == 0) {
				root = new BTNode<E>(null, null, null);
			}
			addAt(root, newNode, getPath(index));
			numNodes++;
		}
		
	}
	@SuppressWarnings("unchecked")
	private void addAt(BTNode<E> currNode, BTNode<E> newNode, Stack<PathDirection> pathStack) {
		// TODO Auto-generated method stub
		PathDirection direction = pathStack.pop();
		if (direction.getChildOf(currNode) == null)
			direction.setAsChild(currNode, new BTNode<E>(null, null, null));
		if (pathStack.isEmpty()) {
			if (direction.getChildOf(currNode) != null) {
				newNode.setLeft(direction.getChildOf(currNode).getLeft());
				newNode.setRight(direction.getChildOf(currNode).getRight());
				numNodes--;
			}
			direction.setAsChild(currNode, newNode);
		} else {
			addAt(direction.getChildOf(currNode), newNode, pathStack);
		}
		
	}

	public static Stack<PathDirection> getPath(int i) {
		return getPath(new Stack<PathDirection>(), i);
	}

	public static Stack<PathDirection> getPath(Stack<PathDirection> stack, int i) {
		
		if (i > 0) {
			stack.push(i % 2 == 0 ? PathDirection.RIGHT : PathDirection.LEFT);
			System.out.printf("%d : %s\n", i, stack.peek());
			getPath(stack, (i - 1) / 2);
		}
		return stack;
	}

	public int getNodeCount() {
		return numNodes;
	}

	public BTNode<E> getRoot() {
		return root;
	}
	
	public List<E> traverseInOrder() {
		// TODO Auto-generated method stub
		return traverseInOrder(root, new LinkedList<E>());
	}

	private List<E> traverseInOrder(BTNode<E> currNode, LinkedList<E> lst) {
		if (currNode != null) {
			traverseInOrder(currNode.getLeft(), lst);
			lst.add(currNode.getData());
			traverseInOrder(currNode.getRight(), lst);	
		}
		return lst;
	}
	
	public List<E> traversePreOrder() {
		// TODO Auto-generated method stub
		return traversePreOrder(root, new LinkedList<E>());
	}

	private List<E> traversePreOrder(BTNode<E> currNode, LinkedList<E> lst) {
		if (currNode != null) {
			lst.add(currNode.getData());
			traversePreOrder(currNode.getLeft(), lst);
			traversePreOrder(currNode.getRight(), lst);	
		}
		return lst;
	}
	
	public List<E> traversePostOrder() {
		// TODO Auto-generated method stub
		return traversePostOrder(root, new LinkedList<E>());
	}

	private List<E> traversePostOrder(BTNode<E> currNode, LinkedList<E> lst) {
		if (currNode != null) {
			traversePostOrder(currNode.getLeft(), lst);
			traversePostOrder(currNode.getRight(), lst);
			lst.add(currNode.getData());
		}
		return lst;
	}
	
	
}
