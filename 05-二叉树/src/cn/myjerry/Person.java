package cn.myjerry;

public class Person implements Comparable<Person> {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return age - o.age;
	}
}
