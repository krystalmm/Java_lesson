package exception;

public class Exception02 {
	public static void main(String[] args) {
		try {
//			例外が発生する可能性がある処理
			System.out.println("100 ÷ 0 は？");
			int result = 100 / 0;
			System.out.println("計算結果" + result);
		} catch (ArithmeticException e) {
//			例外が発生したときに実行する処理（例外クラスが一致したら実行）
			System.out.println("例外が発生");
		} finally {
//			例外発生の有無にかかわらず必ず実行する処理
			System.out.println("プログラム終了");
		}
	}
}
