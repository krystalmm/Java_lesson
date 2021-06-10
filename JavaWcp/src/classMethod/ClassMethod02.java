// パッケージ宣言
package classMethod;

// インポート文（これがないと、毎回new classMethod.human.Human02()という風にパッケージの指定が必要になる！）
import classMethod.human.Human02;

public class ClassMethod02 {
	public static void main(String[] args) {
		Human02 tanaka = new Human02(); 
		System.out.println("名前は" + tanaka.name + "で、年齢は" + tanaka.age + "です。");
		
		Human02 sato = new Human02("佐藤", 25);
		System.out.println("名前は" + sato.name + "で、年齢は" + sato.age + "です。");
	}
}
