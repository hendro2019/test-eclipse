package linked.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import linked_list.Node;

class NodeTest {

	@Test
	void test() {
		Node<String> head = new Node<String>("this", null);
		head = new Node<String>("is", head);
		head = new Node<String>("a", head);
		head = new Node<String>("test", head);
		
		assertEquals(4, Node.listLength(head));
		head.printList();
		
	}
	
	@Test
	void test2() {
		
		Node<String> head = new Node<String>("this", null);
		Node<String> tail = head;
		head.addNodeAfter("is");
		tail = tail.getLink();
		tail.addNodeAfter("a");
		tail = tail.getLink();
		tail.addNodeAfter("test");
		tail = tail.getLink();
		
		
		head.printList();
		assertEquals(4, Node.listLength(head));
	}

}
