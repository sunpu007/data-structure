package cn.myjerry;


//import cn.myjerry.BinarySearchTree.Visitor;
import cn.myjerry.printer.BinaryTrees;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < 30; i++) {
			bst.add((int)(Math.random() * 1000));
		}
		BinaryTrees.println(bst);
		System.out.println(bst.height());
//		bst1.levelOrder(new Visitor<Integer>() {
//			
//			@Override
//			public boolean visit(Integer element) {
//				return false;
//			}
//		});
		

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
