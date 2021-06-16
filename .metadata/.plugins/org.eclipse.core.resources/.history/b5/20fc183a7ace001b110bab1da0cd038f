
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
	}
}
