package dsaajava2;

public class SingleLinkedList<T extends Comparable<? super T>> {

	private int theSize = 0;
	private Node<T> head;
	
	private static class Node<T> {
		public T data;
		public Node<T> next;
		public Node(T d, Node<T> n) {
			data = d; next = n;
		}
	}
	
	public SingleLinkedList() { clear(); }
	public void clear() {
		head = new Node<T>(null, null);
		theSize = 0;
	}
	public int size() { return theSize; }
	public boolean add(T x) {
		add(size(), x);
		return true;
	}
	public void add(int idx, T x) {
		addAfter(getNode(idx), x);
	}
	public T get(int idx) {
		return getNode(idx+1).data;
	}
	private void addAfter(Node<T> p, T x) {
		Node<T> newNode = new Node<T>(x, p.next);
		p.next = newNode;
		theSize++;
	}
	private Node<T> getNode(int idx) {
		Node<T> p;
		if(idx<0 || idx>size())
			throw new IndexOutOfBoundsException();
		p = head;
		for(int i=0; i<idx; i++)
			p = p.next;
		return p;
	}
	public void insert(T x) {
		Node<T> p = head;
		for(int i=0; i<size(); i++) {
			if(p.next.data.compareTo(x) < 0) {
				p = p.next;
			}else{
				break;
			}
		}
		addAfter(p, x);
	}
	
	public void swap(T x, T y) {
		
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> list1 = new SingleLinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		SingleLinkedList<Integer> list2 = new SingleLinkedList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		
		for(int i=0; i<list2.size(); i++) {
			list1.insert(list2.get(i));
		}
		
		for(int i=0; i<list1.size(); i++) {
			System.out.println(list1.get(i));
		}
	}
}
