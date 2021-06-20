package mockitoTest;

// Calculatorクラスを利用する
import unitTest.Calculator;

// モックを使ったテストを書くためのSampleクラス！

public class MockitoSample {
	private Calculator calc;
	
//	Calculatorクラスのインスタンス化
	public MockitoSample() {
		calc = new Calculator();
	}
	
//	Calculatorクラスのsquare()メソッドを呼び出し、その結果を文字列に結合して返す
	public String getSquareResult(int x) {
		int result = calc.square(x);
		return x + "の二乗の結果は" + result;
	}
}
