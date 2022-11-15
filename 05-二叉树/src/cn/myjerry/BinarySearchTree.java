package cn.myjerry;

/**
 * 二叉搜索树
 * @author jerry
 *
 */
@SuppressWarnings("all")
public class BinarySearchTree<E> {
	private int size;
	private Node<E> root;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {}
	
	public void add(E element) {
		elementNotNullCheck(element);
		
		if (root == null) {
			root = new Node<E>(element, null);
			size++;
			return;
		}
		
		Node<E> node = root;
		Node<E> parent = root;
		int com = 0;
		while(node != null) {
			com = compare(element, node.element);
			parent = node;
			if (com > 0) {
				node = node.right;
			} else if (com < 0) {
				node = node.left;
			} else {
				return;
			}
		}
		Node<E> newNode = new Node<>(element, parent);
		if (com > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
	}
	
	public void remove(E element) {}
	
	public boolean contains(E element) {
		return false;
	}
	
	/**
	 * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
	 */
	private int compare(E e1, E e2) {
		return 0;
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	
	private class Node<E> {
		E element;
		Node<E> parent;
		Node<E> left;
		Node<E> right;
		
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
	}
	
}
