
public class Set {
//	Setとは、重複のない要素を管理するコレクション！Setは重複した要素を保持することができず、要素の順番も保証されない！
//	Setもインターフェースのため、HashSetやLinkedHashSetなどのSetを実装したクラスを使用する必要がある！
	
//	Setの生成
//	import java.util.HashSet;
//	import java.util.LinkedHashSet;
//	import java.util.Set;
	
//	HashSetを生成する場合
//	Set<String> set1 = new HashSet<String>();
	
//	LinkedHashSetを生成する場合
//	Set<Integer> set2 = new LinkedHashSet<Integer>();
	
	
//	Setの操作（set1を例にする）
	
//	要素の追加
//	set1.add("スイカ");
//	set1.add("メロン");
	
	
//	要素の取得
//	Setには位置（インデックス）やキーなどの要素を特定する考え方がなく、あくまで集合に過ぎない！
//	なので、要素を取り出したいときは繰り返し処理を用いる！！（拡張for文やラムダ式などを用いる）
	
	
//	要素の存在チェック
//	set1.contains("スイカ"); // trueを返す
//	set1.contains("なし"); // falseを返す
	
	
//	要素数の取得
//	set1.size(); // 2を返す
	
	
//	要素の削除
//	set1.remove("スイカ"); // 要素が文字列の場合、文字列として同じであれば削除される！
//	set1.remove("なし"); // 何もしない
}
