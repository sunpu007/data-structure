package cn.myjerry;

public abstract class Visitor<E> {
	boolean stop;
	
	public boolean visit(E element);
}
