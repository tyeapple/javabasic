package dsaajava2;

import java.util.Comparator;

public class BinarySearchTree<T extends Comparable<? super T>> {

	private BinaryNode<T> root;
	private Comparator<? super T> cmp;
	
	private static class BinaryNode<T> {
		BinaryNode(T theElement) {
			this(theElement, null, null);
		}
		BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt) {
			element = theElement; left = lt; right = rt;
		}
		T element;
		BinaryNode<T> left;
		BinaryNode<T> right;
	}
	
	public BinarySearchTree() {
		this(null);
	}
	public BinarySearchTree(Comparator<? super T> c) {
		root = null; cmp = c;
	}
	
	private int myCompare(T lhs, T rhs) {
		if(cmp != null)
			return cmp.compare(lhs, rhs);
		else
			return lhs.compareTo(rhs);
	}
	
	public void makeEmpty() {
		root = null;
	}
	public boolean isEmpty() { return root == null; }
	public boolean contains(T x) { return contains(x, root); }
	
	public T findMin() throws UnderflowException {
		if(isEmpty())
			throw new UnderflowException();
		return findMin(root).element;
	}
	
	public T findMax() throws UnderflowException {
		if(isEmpty()) 
			throw new UnderflowException();
		return findMax(root).element;
	}
	
	public void insert(T x) {
		root = insert(x, root);
	}
	public void remove(T x) {
		root = remove(x, root);
	}
	public void printTree() {
		
	}
	
	private boolean contains(T x, BinaryNode<T> t) {
		if(t == null)
			return false;
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0)
			return contains(x, t.left);
		else if(compareResult > 0)
			return contains(x, t.right);
		else
			return true;
	}
	private BinaryNode<T> findMin(BinaryNode<T> t) {
		if(t == null)
			return null;
		else if(t.left == null)
			return t;
		return findMin(t.left);
	}
	private BinaryNode<T> findMax(BinaryNode<T> t) {
		if(t != null)
			while(t.right != null)
				t = t.right;
		return t;
	}
	
	private BinaryNode<T> insert(T x, BinaryNode<T> t) {
		if(t == null)
			return new BinaryNode<T>(x, null, null);
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0)
			t.left = insert(x, t.left);
		else if(compareResult > 0)
			t.right = insert(x, t.right);
		else
			;
		return t;
	}
	
	private BinaryNode<T> remove(T x, BinaryNode<T> t) {
		if(t == null)
			return t;
		int compareResult = x.compareTo(t.element);
		if(compareResult < 0)
			t.left = remove(x, t.left);
		else if(compareResult > 0)
			t.right = remove(x, t.right);
		else if(t.left != null && t != null) {
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		}
		else
			t = (t.left != null) ? t.left : t.right;
		return t;	
	}
	
}
