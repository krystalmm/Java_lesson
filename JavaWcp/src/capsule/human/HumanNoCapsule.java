package capsule.human;

public class HumanNoCapsule {
//	publicアクセス修飾子のため、外部から参照が可能！
	public String name;
	public int age;
	
	public HumanNoCapsule(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
