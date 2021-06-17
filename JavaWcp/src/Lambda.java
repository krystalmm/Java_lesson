
public class Lambda {
//	ラムダ式とは、Java8から導入された言語仕様で、関数型言語のような記述を可能にする記法！
	
//	関数は、引数を受け取ってなんらかの計算や処理を行い、結果を返すもの！（Javaのメソッドに近い！）
//	関数型言語では、関数を変数に代入したり、引数や戻り値として扱ったりすることができるのが大きな特徴！
//	Javaは関数型言語ではない（オブジェクト指向言語に分類されることが多い）ため、上記のような扱いは本来できないが、
//	関数型インターフェースというインターフェースを用いることで似たような記述を実現している！
	
	
//	関数型インターフェースとは、実装すべき抽象メソッドが１つしかないインターフェースのこと！
	
//	関数型インターフェース
//	関数型インターフェースには、それが関数型インターフェースであると明示するための@FunctionalInterfaceというアノテーションが用意されている！
	@FunctionalInterface
	public interface A {
		public String hello();
	}
	
//	関数型インターフェースではない（抽象メソッドが２つあるため）
	public interface B {
		public String hello();
		public String goodbye();
	}
	
//	関数型インターフェース（抽象メソッドは１つしか無いため）
	@FunctionalInterface
	public interface C {
		public String hello();
		public static String hi() {
			return "Hi!";
		}
	}
	
	
	
//	関数型インターフェースとラムダ式
	
	// 並び替え対象のリスト
//	List<Integer> numbers = Arrays.asList(1, -8, 4, 2);
//
//	Collections.sort(
//	    numbers,
//	    new Comparator<Integer>() {
//	      @Override
//	      public int compare(Integer x, Integer y) {
//	        // 数値が小さい順に並べる
//	        return Integer.compare(x, y);
//	      }
//	    });
//
//	System.out.println(numbers);
	
//	上記のComparatorが関数型インターフェース！
//	ラムダ式に置き換えることができる！
	
//	new Comparator<Integer>() {
//		public int compare(Integer x, Integer y) {
//			return Integer.compare(x, y);
//		}
//	};
	
//	ラムダ式で書くとこうなる！
//	(Integer x, Integer y) -> {
//		return Integer.compare(x, y);
//	};
	
//	(引数) -> {処理}　というのがラムダ式の基本形！
//	実装すべきメソッドが１つなので、メソッド名を明示しなくても{処理}に当たる部分がcompareメソッドの実装であることが明らか！
	
	
//	ラムダ式だけを書いても文とはみなされないため、メソッドの引数として渡したり、以下のように変数に格納したりする必要がある！
//	Comparator<Integer> c = (Integer x, Integer y) -> {
//		return Integer.compare(x, y);
//	};
	
	
	
//	関数型インターフェースを作る！
//	@FunctionalInterface
//	public interface Greeting {
//		public String hello();
//	}
//	
////	ラムダ式を使ってhelloを実装すると、以下のようになる！（今回は引数はないので()だけ書く！）
//	Greeting greeting = () -> {
//		return "こんにちは";
//	};
//	
////	Greetingは引数の型としても使うことができるので、例えば、次のようなメソッドを用意することも可能！
////	関数型インターフェースGreetngから特定されるメソッドは１つなので、メソッドを引数に渡しているかのような実装ができる！！
//	public static void sayHello(Greeting g) {
//		System.out.println(g.hello());
//	}
//	
	
	
//	メソッド参照
//	先程の例で、helloメソッドが文字列の引数を取る場合を考えてみる！
//	@FunctionalInterface
//	public interface Greeting {
//		public String hello(String word);
//	}
//	
////	ラムダ式を使って、引数を出力する実装
//	Greeting greeting = (String word) -> {
//		System.out.println(word);
//	};
//	
////	メソッド参照という仕組みを使うと、上記は以下のように書くこともできる！
//	Greeting greeting = System.out::println;
//	ラムダ式の中で呼び出すメソッドが１つだけの場合、ラムダ式を使わずとも上記のようにクラスとメソッド名を指定することで直接使うことができる！！
	
	
//	ラムダ式の省略記法
//	サンプル１
//	(Integer x, Integer y) -> {
//		return x + y;
//	};
	
//	サンプル２
//	(Integer x) -> {
//		return x * 5;
//	};
	
//	引数の型は省略できる！（サンプル１を例に）
//	(x, y) -> {
//		return x + y;
//	};
	
//  {}内の処理が１行の場合、{}とreturnは省略できる！（サンプル１を例に）
//	片方だけではなく、両方を省略する必要がある！
//	(Integer x, Integer y) -> x + y;
	
//	()は引数が1つの場合、型とともに省略できる！（サンプル２を例に）
//	x -> {
//		return x * 5;
//	};
	
//	省略ルールは複数適用可能！！
//	サンプル１の省略
//	(x, y) -> x + y;
	
//	サンプル２の省略
//	x -> x * 5;
}
