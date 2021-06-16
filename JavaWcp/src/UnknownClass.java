
public class UnknownClass {
//	無名クラス
	//	無名クラスとは、名前を持たない（＝クラス定義しない）クラスの作り方で、すでに存在するクラスを利用する際に、暫定的に変更を加えたい場合や、
	//	あるインターフェースを実装するときに、あえて名前をつけてクラスファイルにするまでも無い場合に使う！

	//	無名クラスの使い方
	//	クラスは通常、１クラス＝１ファイルで定義し、名前をつける！

	public class Chapter20 {

	}

	public class A {
		public String hello() {
			return "Hello A!";
		}
	}
	
//	このクラスを利用するとき、通常は以下のようになる！
//	A a = new A();
//	System.out.println(a.hello());
	
	
//	このクラスAの動きを少しだけ変えてみる！
//	まず、Aのインスタンスを作る際に{}を追加する！
//	A a = new A(){};
//	System.out.println(a.hello());
//	上記コードは、まだHello A!と出力される！
	
	
//	クラスAを書き換えずに、無名クラスを使ってHello B!と出力させる！
//	A b = new A() {
////		{}のなかにメソッドを追加する！
//		
////		クラスAのhelloメソッドをオーバーライドする！
//		@Override
//		public String hello() {
//			return "Hello B!";
//		}
//	};
//	System.out.println(b.hello());
//	上記コードはHello B!と出力される！！
	
	
	
//	インターフェースを実装する無名クラスの使い方
	
	public interface B {
		public String hello();
	}
	
//	このインターフェースを実装するとき、無名クラスを使わない場合は以下のようなクラスを実装することになる！
	public class BImpl implements B {
		@Override
		public String hello() {
			return "Hello B!";
		}
	}
	
//	実装したBImplクラスを実行するときは、以下のようなコードになる！
//	B b = new BImpl();
//	System.out.println(b.hello());
//	上記コードはHello B!と出力される！
	
	
//	BImplクラスが同じシステムの中で何度も使われるならこのように１つのクラスとして実装する方がいいが、そうでなければ無名クラスを使う！
//	無名クラスで実装する場合は、BImplクラスは必要ない！
//	インターフェースBをインスタンス化するようなイメージでクラスを作ることができる！！
	
//	()の後に{}を追加
//	B b = new B() {
////		helloメソッドを実装
//		@Override
//		public String hello() {
//			return "Hello B!";
//		}
//	};
//	System.out.println(b.hello());
//	上記コードもHello B!と出力される！
}
