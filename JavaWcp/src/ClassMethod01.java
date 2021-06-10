
public class ClassMethod01 {
	public static void main(String[] args) {
//		実行用のファイル！
		
//		引数なしのコンストラクタを用いてHuman01クラスのインスタンスを生成
		Human01 tanaka = new Human01();
		System.out.println("名前は" + tanaka.name + "で、年齢は" + tanaka.age + "です。");
		
//		引数２つのコンストラクタを用いてHuman01クラスのインスタンスを生成
		Human01 sato = new Human01("佐藤", 25);
		System.out.println("名前は" + sato.name + "で、年齢は" + sato.age + "です。");
	}
}
