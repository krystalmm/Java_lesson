// テストクラスとテストメソッドは、abstract、privateにしない！

package unitTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.DisplayName;

// デフォルトのimport
//import static org.junit.jupiter.api.Assertions.*;

// Testアノテーションのimport
import org.junit.jupiter.api.Test;

// 自動生成されたテスト！
// 自動生成した場合アクセス修飾子はデフォルトだか、publicでも問題ない！
// テストクラスの名前は自由だが、xxxTestやTestxxxといった命名規則にすることが多い！
class CalculatorTest {

//	テストメソッドの目印としてTestアノテーションをつける！
	@Test
//	メソッドのアクセス修飾子もデフォルトだが、publicでも問題ない！（テストメソッドはvoidにして戻り値を持たない！）
//	void test() {
////		org.junit.jupiter.api.Assertions.failメソッドは、必ずテストを失敗させるメソッド！
////		まだ自動で追加しただけなので、テストメソッドが未実装であることを示している！
//		fail("まだ実装されていません");
//	}
	
//	テストメソッドの実装！
//	DisplayNameアノテーションで、テスト結果表示画面に使う文言を設定できる！
//	DisplayNameアノテーションなしの場合は、テストメソッド名が表示される！
	@DisplayName("2の二乗は4になる")
	void testSquare2() {
//		1, テスト対象クラスのセットアップとして、インスタンス化や必要に応じて初期値のセットなどを行う！
		Calculator calc = new Calculator();
		
//		2, テスト対象メソッド（今回はsquareメソッド）を実行し、結果を取得する！
		int result = calc.square(2);
		
//		3, 実行結果の実測値と期待値の検証（アサーション）を行う！
//		ここでは、実測値（result）が期待結果（4）と一致するかどうかを検証！
//		assertThatメソッドは、hamcrestというライブラリーのもの！
		assertThat(result, is(4));
	}
	
	
//	rootメソッドに対するテストメソッド追加（正常な引数の時）
	@Test
	@DisplayName("4の平方根は2になる")
	void testRoot4() {
		Calculator calc = new Calculator();
		double result = calc.root(4.0);
		assertThat(result, is(2.0));
	}
	
//	rootメソッドに対するテストメソッド追加（例外が発生した時）
	@Test
	@DisplayName("-1の平方根は例外が発生する")
	void testRootException() {
		Calculator calc = new Calculator();
//		JUnitで例外の検証を行うためには、assertThrows()メソッドを使用する！
//		第一引数は、テストの期待結果の例外クラスを指定する！
//		第二引数は、テスト対象メソッドの実行をラムダ式で指定する！
		assertThrows(IllegalArgumentException.class, () -> calc.root(-1));
	}
	

}
