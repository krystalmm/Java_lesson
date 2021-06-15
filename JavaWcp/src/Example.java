import inner_class_sample.Outer;

// 内部クラスをインスタンス化
public class Example {
	public static void main(String[] args) {
//		クラスOuterをインスタンス化（外部クラスなので、この記述でインスタンス化できる！）
		Outer outer = new Outer();
//		クラスOuterの内部クラスInnerをインスタンス化（内部クラスなので、外部クラスのouterインスタンスを使ってインスタンスを作る必要がある！）
//		クラスを直接参照することができないため、型として用いる際はOuter.Innerと外部クラス名とともに指定するか、
//		import inner_class_sample.Outer.Inner;といったimport文を書かなくてはいけない！
		Outer.Inner inner = outer.new Inner();
		
//		もし内部クラスがstaticだったら、new Outer.Inner()のように書くことで直接インスタンス化できる！
//		import文を書けばnew Inner()のみでインスタンスを生成することが可能！
//		Outer.Inner inner = new Outer.Inner();
	}
}
