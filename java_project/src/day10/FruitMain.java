package day10;

public class FruitMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit apple = new Fruit();
		apple.name = "사과";
		apple.color = "빨강";
		apple.isSeed = true;
		
		// 두번째 생성자를 사용하여 banana 객체생성
		Fruit banana = new Fruit("바나나");
		banana.color = "노랑";
		banana.isSeed = false;
		
		// 세번째 생성자를 사용하여 melon 객체생성
		Fruit melon = new Fruit("멜론", "녹색");
		melon.isSeed = true;
		
		// 네번째 생성자를 사용하여 orange 객체생성
		Fruit orange = new Fruit("오렌지", "주황", true);
		
		apple.print();
		banana.print();
		melon.print();
		orange.print();
	}

}







