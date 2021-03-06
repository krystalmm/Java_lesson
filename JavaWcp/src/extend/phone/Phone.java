package extend.phone;

// Phoneインターフェースの宣言
public interface Phone {
//	フィールドの宣言（定数）
//	(public static final) 定数の型 定数名 = 初期値;
	int MAX_NUMBER_DIGITS = 11;
	
//	public abstractが自動で追加される（抽象メソッド）
//	(public abstract) 戻り値の型 メソッド名（引数）;
	public void call(String number);
	
//	defaultメソッドの宣言（メソッドの宣言にdefaultを指定するとdefaultメソッドになる！）
	default void powerOff() {
		System.out.println("電源を切ります。");
	}
}
