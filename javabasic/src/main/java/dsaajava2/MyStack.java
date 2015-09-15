package dsaajava2;

public class MyStack<T> {

	private int size;
	private Node<T> head;
	
	private static class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public MyStack() {
		clear();
	}
	public void clear() {
		head = new Node<T>(null, null);
		size = 0;
	}
	public int size() {
		return size;
	}
	public void push(T x) {
		Node<T> newNode = new Node<>(x, null);
		newNode.next = head.next;
		head.next = newNode;
	}
	public T pop() {
		Node<T> p = head.next;
		if(p == null) 
			return null;
		head.next = p.next;
		return p.data;
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		Node<T> p = head.next;
		while(p != null) {
			sb.append(p.data);
			p = p.next;
		}
		return sb.toString();
	}
	
	public java.util.Iterator<T> iterator() {
		return new MyStackIterator<T>(head);
	}
	
	private static class MyStackIterator<T> implements java.util.Iterator<T> {
		
		private Node<T> current;
		
		public MyStackIterator(Node<T> head) {
			current = head;
		}
		public boolean hasNext() {
			return current.next != null;
		}
		@Override
		public T next() {
			
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			T nextItem = current.next.data;
			return nextItem;
		}
	}
}
