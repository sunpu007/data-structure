package cn.myjerry;

public class Main {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(11);
    list.add(22);
    list.add(33);
    list.add(44);
    list.add(2, 55);
    System.out.println(list.get(3));
    System.out.println(list.toString());
  }
}
