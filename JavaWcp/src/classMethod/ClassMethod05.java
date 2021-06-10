package classMethod;

import classMethod.human.Human05;

public class ClassMethod05 {
	public static void main(String[] args) {
		Human05 tanaka = new Human05();
		
//		nameとageはprivateな変数なので直接参照はできない
//		System.out.println("名前は" + tanaka.name + "で、年齢は" + tanaka.age + "です。");
		
//		nameとageそれぞれの値を返すpublicなメソッドを通して参照し、出力することはできる
		System.out.println("名前は" + tanaka.getName() + "で、年齢は" + tanaka.getAge() + "です。");
	}
}
