package cn.myjerry;

import java.awt.PageAttributes.OriginType;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import cn.myjerry.printer.BinaryTreeInfo;

/**
 * 二叉搜索树
 * @author jerry
 *
 */
@SuppressWarnings("all")
public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		super();
		this.comparator = comparator;
	}

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
	
	public void remove(E element) {
		if (contains(element)) {
			Node<E> node = root;
			Node<E> curNode = null;
			while(curNode != null) {
				int com = compare(element, node.element);
				if (com == 0) {
					curNode = node;
				} else if (com > 0) {
					node = node.right;
				} else {
					node = node.left;
				}
			}
		}
	}
	
	public boolean contains(E element) {
		Node<E> node = root;
		Boolean flag = false;
		while(!flag) {
			int com = compare(element, node.element);
			if (com == 0) {
				flag = true;
			} else if (com > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return flag;
	}

//	/**
//	 * 先序遍历
//	 */
//	public void preorder() {
//		this.preorder(root);
//	}
//	private void preorder(Node<E> node) {
//		if (node == null) return;
//		
//		System.out.println(node.element);
//		preorder(node.left);
//		preorder(node.right);
//	}
	/**
	 * 先序遍历(增强遍历)
	 */
	public void preorder(Visitor<E> visitor) {
		if (visitor == null) return;
		this.preorder(root, visitor);
	}
	private void preorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		
		visitor.stop = visitor.visit(node.element);
		preorder(node.left, visitor);
		preorder(node.right, visitor);
	}
	
//	/**
//	 * 中序遍历
//	 */
//	public void inorder() {
//		this.inorder(root);
//	}
//	private void inorder(Node<E> node) {
//		if (node == null) return;
//		
//		inorder(node.left);
//		System.out.println(node.element);
//		inorder(node.right);
//	}
	/**
	 * 中序遍历(增强遍历)
	 */
	public void inorder(Visitor<E> visitor) {
		if (visitor == null) return;
		this.inorder(root, visitor);
	}
	private void inorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		
		inorder(node.left, visitor);
		if (visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		inorder(node.right, visitor);
	}

//	/**
//	 * 后续遍历
//	 */
//	public void postorder() {
//		this.postorder(root);
//	}
//	private void postorder(Node<E> node) {
//		if (node == null) return;
//		
//		postorder(node.left);
//		postorder(node.right);
//		System.out.println(node.element);
//	}
	/**
	 * 后续遍历(增强遍历)
	 */
	public void postorder(Visitor<E> visitor) {
		if (visitor == null) return;
		this.postorder(root, visitor);
	}
	private void postorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		
		postorder(node.left, visitor);
		postorder(node.right, visitor);
		if (visitor.stop) return;
		System.out.println(node.element);
	}

//	/**
//	 * 层序遍历
//	 */
//	public void levelOrder() {
//		if (root == null) return;
//		
//		Queue<Node<E>> queue = new LinkedList<>();
//		queue.offer(root);
//		
//		while(!queue.isEmpty()) {
//			Node<E> node = queue.poll();
//			System.out.println(node.element);
//			
//			if (node.left != null) {
//				queue.offer(node.left);
//			}
//			if (node.right != null) {
//				queue.offer(node.right);
//			}
//		}
//	}
	/**
	 * 层序遍历(增强遍历)
	 */
	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null) return;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (visitor.visit(node.element)) return;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	/**
	 * 判断是否为完全二叉树
	 * @return
	 */
//	public boolean isComplete() {
//		if (root == null) return false;
//		
//		Queue<Node<E>> queue = new LinkedList<>();
//		queue.offer(root);
//		
//		boolean leaf = false;
//		while(!queue.isEmpty()) {
//			Node<E> node = queue.poll();
//			
//			if (leaf && !node.isLeaf()) return false;
//			
//			if (node.hasTwoChildren()) {
//				queue.offer(node.left);
//				queue.offer(node.right);
//			} else if (node.left == null && node.right != null) {
//				return false;
//			} else {
//				leaf = true;
//				if (node.left != null) {
//					queue.offer(node.left);
//				}
//			}
//		}
//		return true;
//	}
	
	/**
	 * 判断是否为完全二叉树
	 * @return
	 */
	public boolean isComplete() {
		if (root == null) return false;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		boolean leaf = false;
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			
			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) {
				return false;
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			} else {
				leaf = true;
			}
		}
		return true;
	}
	
	public int height() {
		if (root == null) return 0;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		int height = 0;
		int levelSize = 1;
		
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			if (levelSize == 0) {
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}
	
	/**
	 * 获取树的高度(递归实现)
	 */
	public int heightRecursive() {
		if (root == null) return 0;
		return heightRecursive(root);
	}
	private int heightRecursive(Node<E> node) {
		if (node == null) return 0;
		return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
	}
	
	/**
	 * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
	 */
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	public static abstract class Visitor<E>{
		boolean stop;
		public abstract boolean visit(E element);
	}
	
	
	private static class Node<E> {
		E element;
		Node<E> parent;
		Node<E> left;
		Node<E> right;
		
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		public boolean hasTwoChildren() {
			return left != null && right != null;
		}
	}


	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		return ((Node<E>)node).element;
	}
	
}
