package cn.myjerry;

import cn.myjerry.printer.BinaryTrees;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
		bst1.add(66);
		bst1.add(88);
		bst1.add(77);
		bst1.add(44);
		bst1.add(22);
		bst1.add(33);
		bst1.add(55);
		bst1.add(11);
		bst1.add(99);
		BinaryTrees.println(bst1);
		bst1.levelOrder();
		

//		BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;
//			};
//		});
//		bst2.add(77);
//		bst2.add(88);
//		bst2.add(55);
//		bst2.add(44);
//		bst2.add(99);
	}

}
