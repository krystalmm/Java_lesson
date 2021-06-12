package extend.animal;

// abstract修飾子を設定して、抽象クラスとして宣言
// 抽象クラスの基本構文は、「アクセス修飾子 abstract class クラス名」
public abstract class Animal {
	protected String name;
	
//	共通メソッドを記述
	public void eat() {
		System.out.println(name + "が食事をしました！");
	}
	
//	サブクラスごとに違う処理は、抽象メソッドにしてサブクラスに実装させる！（抽象メソッドでは宣言のみ行う！）
//	抽象メソッドの宣言は、「アクセス修飾子 abstract 戻り値の型 メソッド名（引数）」
	public abstract void cry();
}

