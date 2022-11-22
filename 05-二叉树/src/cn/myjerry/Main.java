package cn.myjerry;


//import cn.myjerry.BinarySearchTree.Visitor;
import cn.myjerry.printer.BinaryTrees;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < 10; i++) {
			bst.add((int)(Math.random() * 100));
		}
		BinaryTrees.println(bst);
		bst.reverseRecursive();
		BinaryTrees.println(bst);
	}

}
