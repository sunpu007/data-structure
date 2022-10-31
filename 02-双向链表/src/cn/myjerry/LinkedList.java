package cn.myjerry;

public class LinkedList<E> {
  /**
   * 头节点
   */
  private Node<E> first;
  /**
   * 尾节点
   */
  private Node<E> last;
  /**
   * 链表长度
   */
  private int size;

  public Boolean isEmity() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  /**
   * 往最后添加节点
   * @param data 节点信息
   */
  public void add(E data) {
    Node<E> node = new Node<>();
    if (first == null) {
      node.setPrev(null);
      node.setData(data);
      node.setNext(null);
      
      this.first = node;
      this.last = node;
    } else {
      node.setPrev(this.last);
      node.setData(data);
      node.setNext(null);

      this.last.setNext(node);

      this.last = node;
    }
    this.size++;
  }

  /**
   * 往指定位置添加节点
   * @param index 节点位置
   * @param data 节点信息
   */
  public void add(int index, E data) {
    this.rangeCheck(index);

    Node<E> node = node(index);

    Node<E> newNode = new Node<>();
    newNode.setData(data);
    if (node != null) {
      Node<E> prev = node.getPrev();
      prev.setNext(newNode);
      newNode.setPrev(prev);

      node.setPrev(newNode);
      newNode.setNext(node);

      this.size++;
    }
  }

  public E remove(int index) {
    this.rangeCheck(index);

    Node<E> node = node(index);

    if (node != null) {
      Node<E> prev = node.getPrev();
      Node<E> next = node.getNext();

      prev.setNext(next);
      next.setPrev(prev);

      this.size--;
    }

    return node.getData();
  }

  public E get(int index) {
    this.rangeCheck(index);

    Node<E> node = node(index);

    return node.getData();
  }

  public void clear() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }

  public void set(int index, E data) {
    this.rangeCheck(index);

    Node<E> node = node(index);

    if (node != null) {
      node.setData(data);
    } 
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				stringBuilder.append(",");
			}
			stringBuilder.append(node(i).getData());
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
  }

  private Node<E> node(int index) {
    Node<E> node = null;
    if (this.first != null) {
      node = this.first;
      for (int i = 0; i < index; i++) {
        node = node.getNext();
      }
    }
    return node;
  }

  private void rangeCheck(int index) {
    if (index < 0 || index >= this.size) {
      throw new Error("Subscript out of bounds");
    }
  }

  /**
   * 内部节点类
   */
  class Node<T> {
    private Node<T> prev;
    private T data;
    private Node<T> next;

    public Node<T> getPrev() {
      return prev;
    }
    public void setPrev(Node<T> prev) {
      this.prev = prev;
    }
    public T getData() {
      return data;
    }
    public void setData(T data) {
      this.data = data;
    }
    public Node<T> getNext() {
      return next;
    }
    public void setNext(Node<T> next) {
      this.next = next;
    }
  }
}
