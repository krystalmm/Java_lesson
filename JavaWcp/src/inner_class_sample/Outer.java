package inner_class_sample;

// 内部クラス
// staticクラスは、クラス外から直接インスタンス化できる！
// 非staticクラスは、外部クラスのインスタンスからのみインスタンス化できる！
public class Outer {
//	外部クラスに定義したフィールドgreeting
	private String greeting = "こんにちは";
	
	public class Inner {
		public String hello() {
//			内部クラスInnerから、外部クラスOuterのフィールドgreetingを参照
			return greeting;
		}
	}
	
//	外部クラスのフィールドを内部クラスから参照できるが、内部クラスがstaticの場合は、参照できずにコンパイルエラーになる！
//	public static class Inner {
//		public String hello() {
//	外部クラスOuterのフィールドgreetingは非staticなので、コンパイルエラー
//			return greeting;
//		}
//	}
	
//	もし、greetingがstaticなフィールドだったら、内部クラスがstaticでも参照できる！！
//	private static String greeting = "こんにちは";
//	
//	public static class Inner {
//		public String hello() {
//			return greeting;
//		}
//	}
	
	
//	内部クラスを使うケース
//	１、定数クラスを読みやすくするケース
//	内部クラスを使わずに定数化すると以下のようになる！
//	public class Constants {
//		public static final String CAT_NAME = "猫";
//		public static final int CAT_LEG_COUNT = 4;
//		public static final String OCTOPUS_NAME = "タコ";
//		public static final int OCTOPUS_LEG_COUNT = 8;
//	}
	
//	この定数を使うコードは以下のようになる！
//	System.out.println(Constants.CAT_NAME);
//	System.out.println(Constants.CAT_LEG_COUNT);
//	System.out.println(Constants.OCTOPUS_NAME);
//	System.out.println(Constants.OCTOPUS_LEG_COUNT);
	
	
//	定数クラスを内部クラスを使って書き換えると以下のようになる！（こっちの方が読みやすい！）
//	public class Constants {
////		内部クラスCatの中に、猫関係の定数を定義
//		public static class Cat {
//			public static final String NAME = "猫";
//			public static final int LEG_COUNT = 4;
//		}
//		
////		内部クラスOctopusの中に、タコ関係の定数を定義
//		public static class Octopus {
//			public static final String NAME = "タコ";
//			public static final int LEG_COUNT = 8;
//		}
//	}
	
//	この定数を使うコードは以下のようになる！
//	System.out.println(Constants.Cat.NAME);
//	System.out.println(Constants.Cat.LEG_COUNT);
//	System.out.println(Constants.Octopus.NAME);
//	System.out.println(Constants.Octopus.LEG_COUNT);
	
	
//	２、クラス間の関連性を強調するケース
//	内部クラスを使わずに4つのクラスを作ってみると以下のようになる！
//	public class Cat {
//	}
//	public class CatNail {
//	}
//	public class Tako {
//	}
//	public class TakoSucker {
//	}
	
//	猫の爪クラスと猫クラス、タコクラスとタコの吸盤クラスはそれぞれセットであることがわかる方が読みやすく、使う時の間違いも減らせそう！
//	内部クラスを用いてみると以下のようになる！
//	public class Cat {
//		public class CatNail {
//		}
//	}
//	
//	public class Tako {
//		public class TakoSucker {
//		}
//	}
}
