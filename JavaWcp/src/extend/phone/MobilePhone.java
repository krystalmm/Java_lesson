package extend.phone;

// インターフェイスの基本構文は「[public] interface インターフェイス名 extends インターフェイス名, インターフェイス名」
// インターフェイスはインターフェイスを継承することができる！

// Phone,Cameraインターフェイスを実装したMobilePhoneクラスの宣言
// クラスによるインターフェイス実装の基本構文
public class MobilePhone implements Phone, Camera {
	private String number;
	
	public MobilePhone(String number) {
		this.number = number;
	}
	
//	Cameraインターフェイスのメソッドを実装
	public void takePicture() {
		System.out.println("写真を撮ります。");
	}
	
//	Phoneインターフェイスのメソッドを実装
	public void call(String number) {
		System.out.println(this.number + "から" + number + "に電話をかけます。");
	}
}
