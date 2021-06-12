package extend.human;

// Humanクラスを継承したStudentクラス
public class Student extends Human {
//	サブクラスで追加したフィールド
	private int score;
	
	public Student(String name, int age, int score) {
//		スーパークラスのコンストラクタを呼び出し（引数があるコンストラクタを呼び出すときはsuperを使って明示的に記述する必要がある！）
		super(name, age);
		this.score = score;
	}
	
//	サブクラスで追加したメソッド
	public String getStudentProfile() {
//		親インスタンスのフィールドをsuper変数で参照
		String profile = "年齢は" + super.age + "です。";
		profile += "学生で、テストの点数は" + this.score + "点です。";
		return profile;
	}
}
