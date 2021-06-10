package classMethod;

import classMethod.human.Human04;

public class ClassMethod04 {
	public static void main(String[] args) {
//		Human04インスタンスを生成すると、コンストラクタ（インスタンス生成時に実行されるメソッドのこと）内の処理が実行される
		Human04 tanaka = new Human04("田中");
		
//		静的メンバーは、インスタンス生成せずに直接使用できる
		Human04.staticMethodPrint();
		
//		staticなクラス定数も、インスタンスを生成せずに参照できる
		System.out.println(Human04.GREETING);
		
//		インスタンスメンバーは直接使用できない（コンパイルエラーになる！）
//		Human04.instanceMethodPrint();
//		System.out.println(Human04.name);
		
//		インスタンスメンバーは、インスタンスを生成してから使用する
		tanaka.instanceMethodPrint();
	}
}
