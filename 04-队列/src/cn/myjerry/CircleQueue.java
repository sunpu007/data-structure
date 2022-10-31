package cn.myjerry;

@SuppressWarnings("all")
public class CircleQueue<E> {

  private static final int DEFAULT_CAPACITY = 10;

  // 记录队头索引
  private int front;
  // 当前队列存储的元素个数
  private int size;
  // 用来存储元素的数组
  private E[] elements;

  public CircleQueue() {
    elements = (E[]) new Object[DEFAULT_CAPACITY];
  }

  // 当前队列存储的元素数量
  public int size() {
    return size;
  }

  // 当前队列是否为空
  public boolean isEmpty() {
    return size == 0;
  }

  // 入队
  public void enQueue(E element) {
    ensureCapacity(size + 1);
    elements[index(size)] = element;
    size++;
  };

  // 出队
  public E deQueue() {
    E element = elements[front];
    elements[front] = null;
    front = index(1);
    size--;
    return element;
  }

  // 查看队头元素
  public E front() {
    return elements[front];
  }

  private int index(int index) {
    index += front;
    return index - (index >= elements.length ? elements.length : 0);
  }

  /**
	 * 保证要有capacity的容量
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;

    front = 0;
	}

  @Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capcacity=").append(elements.length).append(" size=").append(size).append(" front=")
				.append(front).append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
}
