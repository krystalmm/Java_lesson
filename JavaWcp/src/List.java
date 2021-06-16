
public class List {
//	Listとは、配列と同じようにインデックス番号の順序に要素を管理するコレクション！
//	配列との違いは、オブジェクト生成時に要素数の指定は必要がなく、要素を追加・削除するたびにサイズが増減すること！
//	Listはインターフェイスなので、使用する場合は、Listを実装しているクラスを使用する必要がある！（ArrayListやLinkedListなど）
	
//	Listの生成
//	import java.util.ArrayList;
//	import java.util.LinkedList;
//	import java.util.List;
	
//	ArrayListを生成する場合
//	List<String> list1 = new ArrayList<String>();
	
//	LinkedListを生成する場合
//	List<Integer> list2 = new LinkedList<Integer>();
	
	
//	Listの操作（ここではArrayListのlist1を例にしている！）
	
//	要素の追加（位置を指定しなかったら末尾に追加される！）
//	list1.add("リンゴ");
//	list1.add("みかん");
//	位置を指定して要素を追加する！
//	list1.add(1, "バナナ");
	
	
//	要素の取得
//	list1.get(0);
	
	
//	要素の存在チェック（trueかfalseか）
//	list1.contains("バナナ"); // true
//	list1.contains("なし");  // false
	
	
//	要素数の取得
//	list1.size(); // 3を返す
	
	
//	要素の削除
//	要素が文字列の場合、文字列として同じであれば削除される！
//	list1.remove("バナナ");
//	list1.remove("なし"); // 何もしない
	
//	位置を指定して要素を削除する
//	list1.remove(0);
//	list1.remove(5); // コレクションの要素数より大きい位置を指定すると実行時エラー
}
