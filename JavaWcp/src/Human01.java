
public class Human01 {
//	メンバー変数
//	アクセス修飾子publicを用いてどこからでもアクセスできるクラスを定義している！
	public String name;
//	メンバー変数
	public int age;
	
//	引数なしのコンストラクタ
//	アクセス修飾子publicを用いてどこからでもアクセスできるクラスを定義している！
	public Human01() {
		name = "田中";
		age = 20;
	}
	
//	引数２つのコンストラクタ
//	アクセス修飾子publicを用いてどこからでもアクセスできるクラスを定義している！
	public Human01(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
