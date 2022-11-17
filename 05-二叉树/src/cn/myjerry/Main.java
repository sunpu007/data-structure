package cn.myjerry;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
		bst1.add(77);
		bst1.add(88);
		bst1.add(55);
		bst1.add(44);
		bst1.add(99);
		

		BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			};
		});
		bst2.add(77);
		bst2.add(88);
		bst2.add(55);
		bst2.add(44);
		bst2.add(99);
	}

}
