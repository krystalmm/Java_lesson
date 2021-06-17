
public class Stream {
//	ストリーム処理
//	ラムダ式と同様、Java8から導入された言語仕様に「Stream API(java.util.stream.Stream)」がある！
//	これは、コレクションや配列に対する繰り返し処理を実現する「ストリーム処理」を可能とするもの！
//	for文やwhile文も繰り返し処理を実現できるが、ストリーム処理では処理を繋げたパイプラインに要素の集合を通していくようなイメージを持つといい！
	
//	ストリーム処理の流れ
//	１、ストリームを生成する
//	２、要素の集合に対する処理を行う：中間操作
//	３、最終的な処理結果を得る：終端操作
	
//	フルーツのリストを題材にする！（在庫数を管理）
//	・在庫数が10個以下のフルーツを抽出する
//	・抽出したものに対し、20個ずつ発注（個数を加算）する
//	・個数が少ない順に並び替える
//	という処理をする場合を考える！！
	
	
//	フルーツクラス
	public class Fruit {
//		名前
		public String name;
		
//		在庫数
		public int quantity;
		
//		名前と在庫数を引数にしたコンストラクタ
		public Fruit(String name, int quantity) {
			this.name = name;
			this.quantity = quantity;
		}
		
//		在庫数を増やしたフルーツを返すメソッド
		public Fruit order(int quantityToAdd) {
			return new Fruit(this.name, this.quantity + quantityToAdd);
		}
		
//		出力用にtoStringをオーバーライド
		@Override
		public String toString() {
			return name + "：" + quantity + "個";
		}
	}
	
	
//	java.util.Listクラスを使って、フルーツのリストを作る！
//	List<Fruit> fruits = new ArrayList<>();
//	fruits.add(new Fruit("りんご", 7));
//	fruits.add(new Fruit("みかん", 15));
//	fruits.add(new Fruit("いちご", 4));
//	fruits.add(new Fruit("メロン", 8));
//	fruits.add(new Fruit("ぶどう", 20));
	
	
//	初めに、ラムダ式を使わずに処理を実装してみる
	
//	10個以下に絞り込まれたリストを作る
//	List<Fruit> filtered = new ArrayList<>();
////	拡張forでfruitsをループ
//	for (Fruit fruit : fruits) {
////		if文で10個以下に絞る
//		if (fruit.quantity <= 10) {
////			絞り込まれたリストに追加
//			filtered.add(fruit);
//		}
//	}
//	
////	20個ずつ追加する
//	List<Fruit> ordered = new ArrayList<>();
//	for (Fruit fruit : filtered) {
//		ordered.add(fruit.order(20));
//	}
//	
////	個数が少ない順に並べ替える
//	ordered.sort(new Comparator<Fruit>() {
//		@Override
//		public int compare(Fruit f1, Fruit f2) {
//			return f1.quantity - f2.quantity;
//		}
//	});
//	
////	絞り込んで並べ替えたリストを拡張for文でループしながら出力する
//	for (Fruit fruit : ordered) {
//		System.out.println(fruit);
//	}
	
//	このコードを実行すると、以下のように出力される！
//	いちご：24個
//	りんご：27個
//	メロン：28個
	
	
	
//	上記をラムダ式を使って書くと以下のようになる！
//	fruits.stream() // Streamを生成
//		.filter(f -> f.quantity <= 10) // 中間操作１：個数が10個以下のものを抽出
//		.map(f -> f.order(20)) // 中間操作２：20個ずつ発注
//		.sorted((f1, f2) -> f1.quantity - f2.quantity) // 中間操作３：個数の少ない順に並び替え
//		.forEach(System.out.println); // 終端操作：標準出力
}
