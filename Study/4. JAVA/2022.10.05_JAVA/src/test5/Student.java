package test5;

public class Student {
	private String name;
	private int age;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	
	public void study()
	{
		System.out.println(this.name+" 학생은 공부해야지~");
	}
	
}
