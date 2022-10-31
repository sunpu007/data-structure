package cn.myjerry;

import java.util.LinkedList;
import java.util.List;

/**
 * 队列
 */
public class Queue<E> {
  // 使用双向链表实现队列
  private List<E> list = new LinkedList<>();
  
  // 元素的数量
  public int size() {
    return list.size();
  }

  // 是否为空
  public boolean isEmpty() {
    return list.isEmpty();
  }

  // 入队
  public void enQueue(E element) {
    list.add(element);
  }

  // 出队
  public E deQueue() {
    return list.remove(0);
  }

  // 获取队列的头元素
  public E front() {
    return list.get(0);
  }
}
