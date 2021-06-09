
public class Array01 {

	public static void main(String[] args) {
//		配列の宣言と生成
		int[] array1 = new int[3];
//		インデックス番号を指定して要素にデータを代入
		array1[0] = 60;
		array1[2] = 20;
		array1[1] = 20;
//		3番目の要素を取得し、変数int2に代入
		int int2 = array1[2];
		
//		[]は変数名の後ろでもOK!
		int array2[] = null;
		
//		宣言と初期化を同時にする書き方１
		int[] array3 = new int[] { 10, 20, 50 };
//		書き方２
		int[] array4 = { 10, 20, 50 };
	}
}
