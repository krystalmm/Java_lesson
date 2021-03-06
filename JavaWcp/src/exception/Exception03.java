package exception;

public class Exception03 {
	public static void main(String[] args) {
		try {
//			divisionメソッドを呼び出し
			Exception03.division(100, 0);
//			ArithmeticExceptionクラスの例外が発生した場合の例外処理
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException例外が発生");
//			IllegalArgumentExceptionクラスの例外が発生した場合の例外処理
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException例外が発生");
//			キャッチした例外インスタンスをスロー
//			この文があることで、スタックトレースが表示される
			throw e;
		}
//		finallyブロックでないので処理が実行されない！
		System.out.println("プログラム終了");
	}
	
	public static void division(int a, int b) {
		System.out.println(a + " ÷ " + b + " は？");
		if (b == 0) {
//			意図的に例外を発生させたいときthrow文を使う（このことを「例外をスローする」と表現する！）
//			throw 例外インスタンス で、例外をスローする
//			throw new 例外クラス で、例外インスタンスを生成してスローする
			throw new IllegalArgumentException("引数が不正です");
		}
		int result = a / b;
		System.out.println("計算結果" + result);
	}
}
