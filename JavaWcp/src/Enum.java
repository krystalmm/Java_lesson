
public class Enum {
//	Enumとは、プログラムの中で定義する定数を拡張し、さらに安全かつ便利にする仕組み！
//	Enumの書き方
	public enum Dessert {
		APPLE, ICE_CREAM, CAKE
	}
	
//	呼び出すときは、System.out.println(Dessert.APPLE);のようにする！
	
//	以下のようにして変数としても使える！
	Dessert apple = Dessert.APPLE;
	Dessert iceCream = Dessert.ICE_CREAM;
	Dessert cake = Dessert.CAKE;
//	呼び出すときは、System.out.println(apple);のようにする！
	
	
//	引数の型に用いることができる！
	static void printDessertName(Dessert dessert) {
		System.out.println(dessert);
	}
//	呼び出すときは、printDessertName(Dessert.APPLE);のようにする！
	
	
//	新しいインスタンスを生成できない
//	Dessert orange = new Dessert();
//  列挙型はクラスとは違い、これはコンパイルエラーになる！！
	
	
//	==で比較できる！
//	Javaの==演算子は、値が同じでもfalseを返す場合がある！
//	参照型（Object型）に対して==を使う場合は、==は、インスタンスが完全に同一である場合のみtrueを返す！
//	列挙型はコンパイル時に列挙した定数がそれぞれDessert型のstatic finalの定数として宣言されるので、==で比較してもtrueを返す！
//	Dessert x = Dessert.APPLE;
//	Dessert y = Dessert.APPLE;
//	System.out.println(x == y); // trueを返す！
//	System.out.println(x.equals(y));
	
	
//	列挙型の機能
//	・name()：列挙した定数名そのものをString型で返す！
//	System.out.println(Dessert.APPLE.name());
	
	
//	・valueOf(String name)：name()とは逆に、String型の名称から列挙型のインスタンスを取得したい場合に使う！
//	Dessert apple = Dessert.valueOf("APPLE");
//	System.out.println(apple);
//	valueOf()に列挙されていない文字列を指定すると例外が発生するので、注意が必要！
	
	
//	・ordinal()：列挙した順序をintがたで返す！（0スタート）
//	public enum Dessert {
//		APPLE, ICE_CREAM, CAKE
//	}
//	System.out.println(Dessert.APPLE.ordinal());
//	System.out.println(Dessert.ICE_CREAM.ordinal());
//	System.out.println(Dessert.CAKE.ordinal());
//	上記コードを実行すると、
//  0
//	1
//	2
//	と出力される！
	
	
	
//	列挙型のさらなる活用！！
//	値を追加できる！
	
//	public enum Dessert {
////		それぞれに値段を指定する
//		APPLE(100), ICE_CREAM(200), CAKE(300),;
//		
////		値段を保持するフィールド
//		private int price;
//		
////		コンストラクタを追加、引数はint型の値段
//		private Dessert(int price) {
//			this.price = price;
//		}
//		
////		値段を取得するメソッドを追加
//		public int getPrice() {
//			return price;
//		}
//	}
	
//	これで、それぞれのデザートから値段が取得できる！
//	System.out.println(Dessert.APPLE.getPrice());
//	System.out.println(Dessert.ICE_CREAM.getPrice());
//	System.out.println(Dessert.CAKE.getPrice());
//	上記コードを実行すると、
//	100
//	200
//	300
//	と出力される！
	
	
//	メソッドを追加できる！
	
//	public enum Dessert {
//		APPLE(100) {
//			@Override
//			void advertise() {
////				りんご用のadvertiseの実装
//				System.out.println("まっかなリンゴが" + getPrice() + "円！"); // getPriceメソッドも活用できる！
//			}
//		},
//		
//		ICE_CREAM(200) {
//			@Override
//			void advertise() {
////				アイスクリーム用のadvertiseの実装
//				System.out.println("夏にぴったりアイスクリームが" + getPrice() + "円！");
//			}
//		},
//		
//		CAKE(300) {
//			@Override
//			void advertise() {
////				ケーキ用のadvertiseの実装
//				System.out.println("みんな大好き甘いケーキが" + getPrice() + "円！");
//			}
//		},;
//		
//		private int price;
//		
//		private Dessert(int price) {
//			this.price = price;
//		}
//		
//		public int getPrice() {
//			return price;
//		}
//		
////		宣伝文句を出力する抽象メソッド。各インスタンスで実装する！
//		abstract void advertise();
//	}
	
//	それぞれ次のようにして実行することができる！
//	Dessert.APPLE.advertise();
//	Dessert.ICE_CREAM.advertise();
//	Dessert.CAKE.advertise();
}
