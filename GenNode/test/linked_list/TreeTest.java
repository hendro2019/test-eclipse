package linked_list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static linked_list.Tree.PathDirection.*;


import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import linked_list.Tree.PathDirection;



	
public class TreeTest {

		@Test
		public void testPath() {

			checkPath(0);
			checkPath(1, LEFT);
			checkPath(2, RIGHT);
			checkPath(3, LEFT, LEFT);
			checkPath(4, LEFT, RIGHT);
			checkPath(5, RIGHT, LEFT);
			checkPath(6, RIGHT, RIGHT);

		}

		@Test
		public void demoPath() {
			Stack<Tree.PathDirection> path;
			path = Tree.getPath(300);
			System.out.println(Arrays.toString(path.toArray()));
		}

		private void checkPath(int n, Tree.PathDirection... path) {
			Stack<Tree.PathDirection> route;
			route = Tree.getPath(n);
			assertEquals(path.length, route.size());

			for (PathDirection currPath : path) {
				assertEquals(currPath, route.pop());
			}
		}

		@Test
		public void testAdd() {
			Tree<Integer> t = new Tree<>();

			t.add(0);
			assertEquals(1, t.getNodeCount());

			assertEquals(Integer.valueOf(0), t.getRoot().getData());

			t.add(1);
			assertEquals(2, t.getNodeCount());
			assertEquals(Integer.valueOf(1), t.getRoot().getLeft().getData());
			assertNull(t.getRoot().getRight());

			t.add(2);
			checkNode(t, 3, 2, RIGHT);

			t.add(3);
			checkNode(t, 4, 3, LEFT, LEFT);

			t.add(4);
			checkNode(t, 5, 4, LEFT, RIGHT);

			t.add(5);
			checkNode(t, 6, 5, RIGHT, LEFT);

			t.add(6);
			checkNode(t, 7, 6, RIGHT, RIGHT);
		}

		@Test
		public void testPostOrderTraversal() {
			Tree<Integer> t = new Tree<>();

			int numNodes = 15;
			for (int i = 1; i <= numNodes; i++) {
				t.add(i);
			}
			Integer[] nodes = t.traversePostOrder().toArray(new Integer[numNodes]);
			assertEquals(numNodes, nodes.length);
			System.out.println(Arrays.toString(nodes));
		}

		@Test
		public void testPreOrderTraversal() {
			Tree<Integer> t = new Tree<>();

			int numNodes = 15;
			for (int i = 1; i <= numNodes; i++) {
				t.add(i);
			}
			Integer[] nodes = t.traversePreOrder().toArray(new Integer[numNodes]);
			assertEquals(numNodes, nodes.length);
			System.out.println(Arrays.toString(nodes));
		}
		
		@Test
		public void testPrint() {
			Tree<Integer> t = new Tree<>();

			int numNodes = 15;
			for (int i = 1; i <= numNodes; i++) {
				t.add(i);
			}
			t.getRoot().print(0);
			t.getRoot().setRight(t.getRoot().getRight().removeLeftMost());
			t.getRoot().getLeft().setRight(t.getRoot().getLeft().getRight().removeLeftMost());
			t.getRoot().print(0);
			t.addAt(42, 9);
			t.addAt(42, 11);
			t.addAt(400, 0);
			t.getRoot().print(0);
			assertEquals(15, t.getNodeCount());
		}
		
		@Test
		public void testAddAt() {
			Tree<Integer> t = new Tree<>();
			t.addAt(42, 10);
			t.getRoot().print(0);
		}
		
		private <E> void checkNode(Tree<E> t, int numNodes, Object value, PathDirection... path) {

			assertEquals(numNodes, t.getNodeCount());
			BTNode<E> currNode = t.getRoot();
			for (PathDirection direction : path) {
				currNode = direction == LEFT ? currNode.getLeft() : currNode.getRight();
			}
			assertEquals(value, currNode.getData());
		}
	}


