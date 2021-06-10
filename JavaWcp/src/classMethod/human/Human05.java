package classMethod.human;

public class Human05 {
//	privateはクラス内部からのみアクセス可能
	private String name;
	private int age;
	
	public Human05() {
		name = "田中";
		age = 20;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
