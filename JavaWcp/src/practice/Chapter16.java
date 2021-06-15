package practice;

public class Chapter16 {
	public static void main(String[] args) {
		Human human = new Human();
		Human.HumanLeg leg = human.new HumanLeg();
		leg.kick();
		
//		上記を1行で書くこともできる！
//		new Human().new HumanLeg().kick();
	}
}
