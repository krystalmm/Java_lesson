
import java.math.BigDecimal;

public class Genelix {
//	ジェネリクスとは、型をパラメータとして抽象的に扱うことで、プログラムを汎用的に用いるための仕組み！
//	Listなどの生成をする際に<>で型情報を付与することができ、これにより追加する要素の型が限定され、ここで活用されているのがジェネリクス！

	
//	SetとMapを使った例！
//	import java.util.HashMap;
//	import java.util.LinkedHashSet;
//	import java.util.Map;
//	import java.util.Set;
	
//	Set<Integer> set = new LinkedHashSet<>();
//	set.add(1); // OK!
//	set.add("Two"); // コンパイルエラー
	
//	Map<Integer, String> map = new HashMap<>();
//	map.put(1, "Taro"); // OK!
//	map.put(2, "Hanako"); // OK!
//	int value = map.get(0); // コンパイルエラー
	
	
	
//	ジェネリクスを使ったクラス
	
	public static void main(String[] args) {
	
	//	Basketというクラスを生成し、カゴには特定の型の中身を１つ入れることができ、中身を入れ替えても同じ型しか受け付けられないものとする！
		
		class Basket<E> {
			private E elem;
			
			Basket(E e) {
				elem = e;
			}
			
			void replace(E e) {
				elem = e;
			}
			
			E get() {
				return elem;
			}
		}
		
//		上記コードは、コンパイル後には以下のようになっていると考える！
//		class Bascket {
//			private Apple elem;
//			
//			Basket(Apple e) {
//				elem = e;
//			}
//			
//			void replace(Apple e) {
//				elem = e;
//			}
//			
//			Apple get() {
//				return elem;
//			}
//		}
		
	//	カゴの中身として、Apple、Peachというクラスを用意！
		class Apple {
			private String name;
			
			Apple(String name) {
				this.name = name;
			}
			
			String getName() {
				return name;
			}
	 	}
		
		class Peach {
			private String name;
			
			Peach(String name) {
				this.name = name;
			}
			
			String getName() {
				return name;
			}
		}
		
	//	Apple用のBasketを用意！
		Basket<Apple> appleBasket = new Basket<>(new Apple("ふじ"));
		System.out.println(appleBasket.get().getName());
	
//		中身を書き換えるために用意したreplaceも使ってみる！
		appleBasket.replace(new Apple("紅玉"));
		System.out.println(appleBasket.get().getName());
		
//		replaceの引数にPeachクラスのインスタンスを渡そうとするとコンパイルエラー
//		appleBasket.replace(new Peach("黄金桃"));
	}
	
	
//	境界型パラメータ
//	型パラメータとして受け取れるクラスを、特定のインターフェースや抽象クラスを継承（実装）したクラスに限定することもできる！
//	AppleやPeachがFruitという抽象クラスを継承しているとする！
	
	abstract class Fruit {
		String name;
//		BigDecimalはimportする！
		BigDecimal price;
		
		Fruit(String name, BigDecimal price) {
			this.name = name;
			this.price = price;
		}
		
		abstract protected String getName();
		abstract protected BigDecimal getPrice();
	}
	
	class Apple extends Fruit {
		Apple(String name, BigDecimal price) {
			super(name, price);
		}
		
		@Override
		protected String getName() {
			return name;
		}
		@Override
		protected BigDecimal getPrice() {
			return price;
		}
	}
	
	class Peach extends Fruit {
		Peach(String name, BigDecimal price) {
			super(name, price);
		}
		
		@Override
		protected String getName() {
			return name;
		}
		
		@Override
		protected BigDecimal getPrice() {
			return price;
		}
	}
	
	
//	Basket型を用意し、Fruitのサブクラスしか受け取れないよう、extendsキーワードを用いて以下にように定義する！
//	インターフェースで制限する場合も、implementsではなくextendsと書く！
	
	class Basket<E extends Fruit> {
		private E elem;
//		カゴのお金
		private final BigDecimal PRICE = new BigDecimal(100);
		
		Basket(E e) {
			elem = e;
		}
		
		void replace(E e) {
			elem = e;
		}
		
		E get() {
			return elem;
		}
		
		void printName() {
			// EはFruitのサブクラスなので、getNameが使えると保証されている！
			System.out.println("カゴの中身は" + elem.getName() + "です"); 
		}
		
		void printTotalPrice() {
			BigDecimal totalPrice = PRICE.add(elem.getPrice());
			System.out.println(elem.getName() + "の入ったカゴは合計" + totalPrice + "円です");
		}
	}
	
//	上記を実行するのは以下のようにする！
//	Basket<Apple> appleBasket = new Basket<>(new Apple("ふじ", new BigDecimal(200)));
//	Basket<Peach> peachBasket = new Basket<>(new Peach("黄金桃", new BigDecimal(300)));
//	
//	appleBasket.printTotalPrice();
//	peachBasket.printTotalPrice();
	
	
	
//  境界ワイルドカード
//	境界型パラメータで？記号を用いることができる！（Fruitクラスを継承したAppleクラスを例に！）
//	Fruitを要素にもつListとAppleを要素に持つListを用意！
	
//	import java.util.ArrayList;
//	imoprt java.util.List;
	
//	List<Fruit> fruits = new ArrayList<>();
//	List<Apple> apples = new ArrayList<>();
	
//	このとき、FruitとAppleには親子関係があるが、List<Fruit>とList<Apple>に親子関係が無いのがJavaの特徴
//	なので、fruitsにapplesを代入しようとするとコンパイルエラーになる！
//	もしListの親子関係も認めてしまうと、実体がAppleのListであるにもかかわらずFruitのListとして扱われてしまうから！！
	
//	fruits = apples // 要素は親子関係にあるが、この代入は成り立たずコンパイルエラー
//	// 上記を許してしまうと、実体がAppleのListなのに別の型の要素を追加できてしまう
//	fruits.add(new Peach("黄金桃", new BigDecimal(300)));
	
	
//  代入だけでなく、次のようなList<Fruit>を引数に持つメソッドの利用もできない！
//	void doSomething(List<Fruit> fruits) {
////		なんらかの処理
//	}
	
//	doSomething(apples); // コンパイルエラー
	
	
//	ここで活用できるのがワイルドカード！
//	？を使って、Fruitを継承したクラスであれば要素として認めるコードを書くことができる！
	
//	List<? extend Fruit> fruits; // 型パラメータとして、Fruitを継承したクラスを指定
//	List<Apple> apples = new ArrayList<>();
	
//	fruits = apples; // コンパイルエラーにならない！
	
	
//	void doSomething(List<? extends Fruit> fruits) {
////		なんらかの処理
//	}
	
//	doSomething(apples); // コンパイルエラーにならない！
	
}
