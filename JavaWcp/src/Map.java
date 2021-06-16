
public class Map {
//	Mapとは、「キー」と「値」の組み合わせで要素を管理するコレクション！（１つのキーに対して１つの値が存在する）
//	MapもList同様にインターフェイスのため、HashMapやTreeMapなどのMapを実装したクラスを使用する必要がある！
	
//	Mapの生成
//	import java.util.HashMap;
//	import java.util.Map;
//	imoprt java.util.TreeMap;
	
//	HashMapを生成する場合
//	Map<Integer, String> map1 = new HashMap<Integer, String>();
	
//	TreeMapを生成する場合
//	Map<String, String> map2 = new TreeMap<String, String>();
	
	
//	Mapの操作（HashMapのmap1を例とする）
	
//	要素の追加
//	map1.put(0, "ぶどう");
//	map1.put(3, "もも");
	
//	登録済みのキーで追加すると上書きされる
//	map1.put(0, "マスカット");
	
	
//	要素の取得
//	map1.get(0);  // マスカットを返す
//	map1.get(1);  // nullを返す（存在しないキーなので）
	
	
//	要素の存在チェック
//	キーの存在チェック（trueを返す）
//	map1.containsKey(0);
	
//	値の存在チェック（falseを返す）
//	map1.containsValue("ぶどう");
	
	
//	要素数の取得
//	map1.size(); // 2を返す
	
	
//	要素の削除（キーのみかキーと値の両方の指定ができる！）
//	キーを指定して要素を削除する
//	map1.remove(0);
//	map1.remove(1);  // 何もしない
	
//	キーと値を指定して要素を削除する
//	map1.remove(3, "もも"); // 両方一致するので削除される！
//	map1.remove(3, "なし"); // 何もしない
}
