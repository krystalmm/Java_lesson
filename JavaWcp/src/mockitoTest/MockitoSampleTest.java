package mockitoTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// BeforeEachのimport
import org.junit.jupiter.api.BeforeEach;
// DisplayNameのimport
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// ExtendWithのimport
import org.junit.jupiter.api.extension.ExtendWith;
// InjectMocksのimport
import org.mockito.InjectMocks;
// Mockのimport
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
// MockitoExtensionのimport
import org.mockito.junit.jupiter.MockitoExtension;

// Calculatorクラスのimport
import unitTest.Calculator;


// 拡張機能を追加（MockitoがJUnit5に対応するための設定）
@ExtendWith(MockitoExtension.class)
class MockitoSampleTest {
	
//	モック化するクラスをフィールドに追加（今回はCalculatorクラス）
//	これは、Calculatorクラスのメソッドは持っているが、中身の処理は何も実装されていないような挙動をするもの！
	@Mock
	private Calculator calc;
	
//	テスト対象クラス（＝モックを利用するクラス）をフィールドに追加
	@InjectMocks
	private MockitoSample sample;
	
//	全てのテストメソッドの前に実行されるように設定する！
	@BeforeEach
	void setUp() {
//		モック設定の初期化をするメソッドを呼び出す
		MockitoAnnotations.initMocks(this);
	}

	@Test
//	テスト結果表示用にテストメソッドの説明を記載
	@DisplayName("getSquareResultに5を渡した時に25が表示できる")
	void test() {
//		テストの前準備として、モック化したクラスのセットアップを行う
		when(calc.square(5)).thenReturn(25);
		
//		テストの実行
//		テスト対象メソッド（今回はgetSquareResultメソッド）を実行し、結果を取得する！
		String result = sample.getSquareResult(5);
		
//		実行結果の実測値と期待値の検証（アサーション）を行う
		assertThat(result, is("5の二乗の結果は25"));
	}

}
