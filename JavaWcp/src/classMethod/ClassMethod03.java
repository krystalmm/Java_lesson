package classMethod;

import classMethod.human.Human03;

public class ClassMethod03 {
	public static void main(String[] args) {
		Human03 tanaka = new Human03();
		
		System.out.println("私の名前は、" + tanaka.name + "です。");
		String profile = tanaka.getProfile();
		System.out.println(profile + "です。");
		
		tanaka.greet("田辺");
		tanaka.greet(null);
	}
}
