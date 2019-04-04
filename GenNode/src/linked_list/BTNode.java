package linked_list;

public class BTNode<E> {
	
	private E data;
	private BTNode<E> left, right;
	
	public BTNode(E data, BTNode<E> left, BTNode<E> right) {
		
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public E getData() {
		return data;
	}
	
	public BTNode<E> getLeft() {
		return left;
	}
	
	public BTNode<E> getRight() {
		return right;
	}
	
	public E getLeftMostData() {
		if (left == null)
			return data;
		else 
			return left.getLeftMostData();
	}
	
	public E getRightMostData() {
		if (right == null)
			return data;
		else 
			return right.getRightMostData();
	}
	
	public void inOrderPrint() {
		if (left != null)
			left.inOrderPrint();
		System.out.println(data);
		if (right != null)
			right.inOrderPrint();
	}
	
	public void postOrderPrint() {
		if (left != null)
			left.postOrderPrint();
		if (right != null)
			right.postOrderPrint();
		System.out.println(data);
	}
	
	public void preOrderPrint() {
		System.out.println(data);
		if (left != null)
			left.preOrderPrint();
		if (right != null)
			right.preOrderPrint();
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	public void print(int depth) {
		int i;
		
		// print indentation and depth of curr node.
		for(i = 1; i <= depth; i++)
			System.out.print("   ");
		System.out.println(data);
		
		//print left subtree (of dash if there is no left but there is a right)
		if (left != null)
			left.print(depth + 1);
		else if (right != null) {
			for(i = 1; i <= depth + 1; i++)
				System.out.print("   ");
			System.out.println("--");
		}
		
		//print right subtree (of dash if there is no right c, but there is a left c)
		if (right != null)
			right.print(depth + 1);
		else if (left != null) {
			for(i = 1; i <= depth + 1; i++)
				System.out.print("   ");
			System.out.println("--");
		}
	}
	
	public BTNode<E> removeLeftMost() {
		if (left == null)
			return right;
		else {
			left = left.removeLeftMost();
			return this;
		} 		
	}
	
	public BTNode<E> removeRightMost() {
		if (right == null)
			return left;
		else {
			right = right.removeRightMost();
			return this;
		} 		
	}

	/**
	 * @param data the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BTNode<E> left) {
		this.left = left;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BTNode<E> right) {
		this.right = right;
	}
	
	public static <E> int treeSize(BTNode<E> root) {
		if (root == null)
			return 0;
		else
			return 1 + treeSize(root.left) + treeSize(root.right);
	}
	
	public static <E> BTNode<E> treeCopy(BTNode<E> source){
		BTNode<E> leftCopy, rightCopy;
		
		if (source == null)
			return null;
		else {
			leftCopy = treeCopy(source.left);
			rightCopy = treeCopy(source.right);
			return new BTNode<E>(source.data, leftCopy, rightCopy);
		}
	}

}

