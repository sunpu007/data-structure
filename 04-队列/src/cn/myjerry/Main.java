package cn.myjerry;

public class Main {
	public static void main(String[] args) {
		CircleQueue<Integer> queue = new CircleQueue<Integer>();
		// 0 1 2 3 4 5 6 7 8 9
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		// null null null null null 5 6 7 8 9
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		// 15 16 17 18 19 f[5] 6 7 8 9
		for (int i = 15; i < 30; i++) {
			queue.enQueue(i);
		}
		// while (!queue.isEmpty()) {
		// System.out.println(queue.deQueue());
		// }
		// queue.clear();
		System.out.println(queue);
	}
}
