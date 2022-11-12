package cn.myjerry;

import java.util.ArrayList;

public class Stack<E> {
  private ArrayList<E> list;

  public Stack() {
    this.list = new ArrayList<>();
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public void push(E element) {
    list.add(element);
  }

  public E pop() {
    return list.remove(list.size() - 1);
  }
  
  public E top() {
    return list.get(list.size() - 1);
  }

  public void clear() {
    list.clear();
  }
}
