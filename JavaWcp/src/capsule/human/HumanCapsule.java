package capsule.human;

public class HumanCapsule {
//	privateのアクセス修飾子を設定して、外部から隠蔽
	private String name;
	private int age;
	
	public HumanCapsule(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
//	nameのgetterメソッド
	public String getName() {
		return this.name;
	}
	
//	nameのsetterメソッド
	public void setName(String name) {
		this.name = name;
	}
	
//	ageのgetterメソッド
//	ageは外部から変更禁止なので、setterメソッドは作成しない！
	public int getAge() {
		return this.age;
	}
}
