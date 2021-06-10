
public class DoWhile01 {
	public static void main(String[] args) {
		int number = 1;
		do {
			number *= 2;
			System.out.println("DoWhile01 = " + number);
		} while (number < 50);
		
		
//		do-while文は条件式を後から評価するので、以下の処理は一度だけ実行される！
		number = 100;
		do {
			number *= 2;
			System.out.println(number);
		} while (number < 50);
	}
}
