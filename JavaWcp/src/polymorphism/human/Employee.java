package polymorphism.human;

// Humanクラスを継承
public class Employee extends Human {
	private String department;
	
	public Employee(String name, int age, String department) {
//		スーパークラスのコンストラクタを呼び出し
		super(name, age);
		this.department = department;
	}
	
//	オーバーライドして、Employeeクラス用に処理を変更
	@Override
	public String getProfile() {
		String profile = "年齢は" + this.age + "です。";
		profile += "サラリーマンで、部署は" + this.department + "です。";
		return profile;
	}
}

