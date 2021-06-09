
public class Null01 {

	public static void main(String[] args) {
		String string1;
//		"あいう"の文字列を出力
		string1 = "あいう";
		System.out.println(string1 + "の文字数：" + string1.length());
		
//		空文字を出力
		string1 = "";
		System.out.println(string1 + "の文字数：" + string1.length());
		
//		nullの変数を参照するとNullPointerExceptionのエラーになる！
		string1 = null;
		System.out.println(string1 + "の文字数：" + string1.length());
	}
}
