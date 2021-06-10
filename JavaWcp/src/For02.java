
public class For02 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
//		拡張for文という！（配列やコレクションの変数の要素を順番に取得し、指定した型の変数に代入しながらブロック内の処理を行う！）
		for (int number : array) {
			System.out.println("For02 = " + number);
		}
	}
}
