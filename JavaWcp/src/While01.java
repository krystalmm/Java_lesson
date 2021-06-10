
public class While01 {
	public static void main(String[] args) {
		int number = 1;
		while (number < 50) {
			number *= 2;
			System.out.println("While01 = " + number);
		}
		
//		while文は条件式を先に評価するので以下の処理は実行されない！
		number = 100;
		while (number < 50) {
			number *= 2;
			System.out.println(number);
		}
	}
}
